package service;

import utils.DatabaseConnection;
import domains.User;

import javax.servlet.http.HttpServletRequest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserService {



    public void registerUser(User user){

        PreparedStatement preparedStatement=null;

        String query="insert into user(name, email, password) values(?, ?, ?)";
        try{
            preparedStatement= new DatabaseConnection().getPreparedStatement(query);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.execute();
            System.out.println("query executed!!");
            preparedStatement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public User loginUser(String email, String password){

        PreparedStatement preparedStatement=null;
        String query="select * from user where email=? and password=?";
        ResultSet resultSet;
        User user=null;

        try{
            preparedStatement=new DatabaseConnection().getPreparedStatement(query);
            preparedStatement.setString(1,email);
            preparedStatement.setString(2, password);
            resultSet=preparedStatement.executeQuery();

            while (resultSet.next()){
                user=new User();
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return user;
    }

    public List<User> userList(){

        PreparedStatement preparedStatement=null;
        String query="select * from user";
        ResultSet resultSet;
        List<User> userList = new ArrayList<User>();

        try{
            preparedStatement= new DatabaseConnection().getPreparedStatement(query);
            resultSet=preparedStatement.executeQuery();

            while (resultSet.next()){
                User user=new User();
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setEmail(resultSet.getString("email"));
                user.setRole(resultSet.getString("role"));

                userList.add(user);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return userList;
    }

    public void deleteUser(int id){
        PreparedStatement preparedStatement=null;
        String query="delete from user where id=?";

        try {
            preparedStatement=new DatabaseConnection().getPreparedStatement(query);
            preparedStatement.setInt(1,id);
            preparedStatement.execute();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public void updateUser(User user){
        PreparedStatement preparedStatement=null;
        String query="update user set name=?, email=?, password=? where id=?";

        try{
            preparedStatement=new DatabaseConnection().getPreparedStatement(query);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(1, user.getEmail());
            preparedStatement.setString(1, user.getPassword());
            preparedStatement.setInt(4,user.getId());

            preparedStatement.execute();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public User selectUser(int id){
        PreparedStatement preparedStatement=null;
        String query="select * from user where id=?";
        ResultSet resultSet;
        User user=new User();

        try{
            preparedStatement=new DatabaseConnection().getPreparedStatement(query);
            preparedStatement.setInt(1, id);
            resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));
                user.setRole(resultSet.getString("role"));
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return user;
    }

    public User getUser(HttpServletRequest request){
        User user=new User();

        user.setName(request.getParameter("username"));
        user.setEmail(request.getParameter("email"));
        user.setPassword(request.getParameter("password"));
        user.setRole(request.getParameter("role"));

        return user;
    }
}
