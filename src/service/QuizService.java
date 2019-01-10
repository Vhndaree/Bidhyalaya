package service;

import domains.Question;
import utils.DatabaseConnection;

import javax.servlet.http.HttpServletRequest;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class QuizService {
    public List<Question> getQuestionList(HttpServletRequest request){
        String[] categories=request.getParameterValues("category");
        String difficulty=request.getParameter("difficulty");
        int questionNumber=Integer.parseInt(request.getParameter("questionnumber"));
        String query="select * from question where category in "+getQuestionMark(categories.length)+" and difficulty_level=? limit ?";
        ResultSet resultSet;
        List<Question> questionList=new ArrayList<>();

        try {
            PreparedStatement preparedStatement=new DatabaseConnection().getPreparedStatement(query);
            for(int i=1;i<=categories.length;i++){
                preparedStatement.setString(i, categories[i-1]);
            }
            preparedStatement.setString(categories.length+1, difficulty);
            preparedStatement.setInt(categories.length+2, questionNumber==0?1:questionNumber);
            resultSet=preparedStatement.executeQuery();

            while(resultSet.next()){
                Question question=new Question();

                question.setId(resultSet.getInt("id"));
                question.setQuestion(resultSet.getString("question"));
                question.setCategory(resultSet.getString("category"));
                question.setDifficultyLevel(resultSet.getString("difficulty_level"));
                question.setOption1(resultSet.getString("option_1"));
                question.setOption2(resultSet.getString("option_2"));
                question.setOption3(resultSet.getString("option_3"));
                question.setOption4(resultSet.getString("option_4"));
                question.setCorrectAnswer(resultSet.getString("correct_answer"));

                questionList.add(question);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return questionList;
    }

    private String getQuestionMark(int length){
        String a="";
        if(length==1){
            a="(?)";
        } else {
            for (int i = 0; i < length; i++) {
                if (i == 0) {
                    a = "(?,";
                } else if (i < length - 1) {
                    a += " ?,";
                } else {
                    a += " ?)";
                }
            }
        }
        return a;
    }
}
