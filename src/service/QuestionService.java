package service;

import domains.Question;
import utils.DatabaseConnection;

import javax.servlet.http.HttpServletRequest;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class QuestionService {
    
    public void addQuestion(Question question){
        String query="insert into question (question, category, difficulty_level, option_1, option_2, option_3, option_4, correct_answer) values(?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement preparedStatement=new DatabaseConnection().getPreparedStatement(query);
            preparedStatement.setString(1, question.getQuestion());
            preparedStatement.setString(2, question.getCategory());
            preparedStatement.setString(3, question.getDifficultyLevel());
            preparedStatement.setString(4, question.getOption1());
            preparedStatement.setString(5, question.getOption2());
            preparedStatement.setString(6, question.getOption3());
            preparedStatement.setString(7, question.getOption4());
            preparedStatement.setString(8, question.getCorrectAnswer());

            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Question> getQuestionList(){
        String query="select * from question";
        ResultSet resultSet;
        List<Question> questionList=new ArrayList<Question>();

        try {
            PreparedStatement preparedStatement=new DatabaseConnection().getPreparedStatement(query);
            resultSet=preparedStatement.executeQuery();

            while (resultSet.next()){
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

    public void deleteQuestion(int id) {
        String query="delete from question where id=?";
        try {
            PreparedStatement preparedStatement=new DatabaseConnection().getPreparedStatement(query);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void updateQuestion(Question question, int id){
        String query="update question set question=?, category=?, difficulty_level=?, option_1=?, option_2=?, option_3=?, option_4=?, correct_answer=? where id=?";

        try {
            PreparedStatement preparedStatement=new DatabaseConnection().getPreparedStatement(query);
            preparedStatement.setString(1, question.getQuestion());
            preparedStatement.setString(2, question.getCategory());
            preparedStatement.setString(3, question.getDifficultyLevel());
            preparedStatement.setString(4, question.getOption1());
            preparedStatement.setString(5, question.getOption2());
            preparedStatement.setString(6, question.getOption3());
            preparedStatement.setString(7, question.getOption4());
            preparedStatement.setString(8, question.getCorrectAnswer());
            preparedStatement.setInt(9,question.getId());

            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public Question selectQuestion(int id){
        String query="select * from question where id=?";
        ResultSet resultSet;
        Question question=new Question();
        try {
            PreparedStatement preparedStatement=new DatabaseConnection().getPreparedStatement(query);
            preparedStatement.setInt(1, id);
            resultSet=preparedStatement.executeQuery();

            while (resultSet.next()){
                question.setQuestion(resultSet.getString("question"));
                question.setCategory(resultSet.getString("category"));
                question.setDifficultyLevel(resultSet.getString("difficulty_level"));
                question.setOption1(resultSet.getString("option_1"));
                question.setOption2(resultSet.getString("option_2"));
                question.setOption3(resultSet.getString("option_3"));
                question.setOption4(resultSet.getString("option_4"));
                question.setCorrectAnswer(resultSet.getString("correct_answer"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return question;
    }
    
    public Question getQuestion(HttpServletRequest request){
        Question question=new Question();
        
        question.setQuestion(request.getParameter("question"));
        question.setCategory(request.getParameter("category"));
        question.setDifficultyLevel(request.getParameter("difficulty"));
        question.setOption1(request.getParameter("option1"));
        question.setOption2(request.getParameter("option2"));
        question.setOption3(request.getParameter("option3"));
        question.setOption4(request.getParameter("option4"));
        question.setCorrectAnswer(request.getParameter("correctanswer"));
        
        return question;
    }
}
