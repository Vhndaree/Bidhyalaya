package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseConnection {
    Connection connection=null;

    private final String url="jdbc:mysql://localhost:3306/bidhyalaya";
    private final String username="root";
    private final String password="";

    public DatabaseConnection(){
        try {
            connection=DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public PreparedStatement getPreparedStatement(String query){

        PreparedStatement preparedStatement=null;

        try {
            preparedStatement= connection.prepareStatement(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return preparedStatement;
    }
}
