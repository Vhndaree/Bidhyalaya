package service;

import domains.Question;
import domains.QuizResult;
import utils.DatabaseConnection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class QuizService {
    public Question getQuestion(HttpServletRequest request){
        int id=Integer.parseInt(request.getParameter("id"));
        HttpSession queryParameter = request.getSession(false);
        if(request.getParameterValues("category")!=null) {
            String[] categories=request.getParameterValues("category");
            String selectedCategory = "'" + String.join("', '", categories) + "'";
            String query = "select * from question where id>? and category in ( " + selectedCategory + " ) and difficulty_level='"+request.getParameter("difficulty")+"' limit 1";
            queryParameter.setAttribute("query", query);
        }
        ResultSet resultSet;
        Question question=new Question();
        try {
            PreparedStatement preparedStatement=new DatabaseConnection().getPreparedStatement((String)queryParameter.getAttribute("query"));
            preparedStatement.setInt(1, id);
            resultSet=preparedStatement.executeQuery();

            if(resultSet.isBeforeFirst()) {
                while (resultSet.next()) {
                    question.setId(resultSet.getInt("id"));
                    question.setQuestion(resultSet.getString("question"));
                    question.setCategory(resultSet.getString("category"));
                    question.setDifficultyLevel(resultSet.getString("difficulty_level"));
                    question.setOption1(resultSet.getString("option_1"));
                    question.setOption2(resultSet.getString("option_2"));
                    question.setOption3(resultSet.getString("option_3"));
                    question.setOption4(resultSet.getString("option_4"));
                    question.setCorrectAnswer(resultSet.getString("correct_answer"));
                }
            } else {
                question=null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return question;
    }

    public QuizResult getQuizPlayResult(HttpServletRequest request){
        int id=Integer.parseInt(request.getParameter("id"));
        String userAnswer=request.getParameter(request.getParameter("id"));
        String[] questionAnswer=getQuestionAnswer(id);
        QuizResult quizResult=new QuizResult();
        quizResult.setId(id);
        quizResult.setQuestion(questionAnswer[0]);
        quizResult.setUsersAnswer(userAnswer);
        quizResult.setCorrectAnswer(questionAnswer[1]);

        return quizResult;
    }

    private String [] getQuestionAnswer(int id){
        String [] questionAnswer=new String[2];
        ResultSet resultSet;
        String query="select question, correct_answer from question where id=?";
        try {
            PreparedStatement preparedStatement=new DatabaseConnection().getPreparedStatement(query);
            preparedStatement.setInt(1, id);
            resultSet=preparedStatement.executeQuery();

            while (resultSet.next()){
                questionAnswer[0]=resultSet.getString("question");
                questionAnswer[1]=resultSet.getString("correct_answer");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return questionAnswer;
    }
}
