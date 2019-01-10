package service;

import domains.QuestionCategory;
import utils.DatabaseConnection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class QuestionCategoryService {

    public void addQuestionCategory(HttpServletRequest request){
        QuestionCategory questionCategory=getQuestionCategory(request);
        String query="insert into question_category (category) values(?)";

        try {

            PreparedStatement preparedStatement=new DatabaseConnection().getPreparedStatement(query);
            preparedStatement.setString(1, questionCategory.getCategory());
            preparedStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteQuestionCategory(int id){
        String query="delete from question_category where id=?";
        try {
            PreparedStatement preparedStatement=new DatabaseConnection().getPreparedStatement(query);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<QuestionCategory> getQuestionCategoryList(){
        List<QuestionCategory> questionCategories=new ArrayList<>();
        String query="select * from question_category";
        ResultSet resultSet;

        try {
            PreparedStatement preparedStatement=new DatabaseConnection().getPreparedStatement(query);
            resultSet=preparedStatement.executeQuery();

            while (resultSet.next()){
                QuestionCategory questionCategory=new QuestionCategory();
                questionCategory.setId(resultSet.getInt("id"));
                questionCategory.setCategory(resultSet.getString("category"));

                questionCategories.add(questionCategory);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return questionCategories;
    }

    private QuestionCategory getQuestionCategory(HttpServletRequest request){
        QuestionCategory questionCategory=new QuestionCategory();

        questionCategory.setCategory(request.getParameter("category"));

        return questionCategory;
    }
}
