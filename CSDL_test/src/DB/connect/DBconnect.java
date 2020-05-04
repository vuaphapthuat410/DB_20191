/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB.connect;

/**
 *
 * @author vuaphapthuat410
 */
import com.mysql.jdbc.Driver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBconnect {

    private Connection connection;
    private Statement statement;

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public boolean initialize(String user, String password) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/CourseDB?allowMultiQueries=true", user, password);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBconnect.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DBconnect.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (connection == null) {
            return false;
        }
        return true;
    }

    //Create Statement in database
    public void createStatement() {
        if (statement == null) {
            try {
                statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    //Retrieve data from db to object ResultSet
    public ResultSet retrieveData(String sqlCommand) {
        try {
            createStatement();
            ResultSet resultSet = statement.executeQuery(sqlCommand);
            return resultSet;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
    }

    public int insertData(String sqlCommand, String values[]) {
        return executeUpdate(sqlCommand, values);
    }

    public int deleteData(String sqlCommand, String values[]) {
        return executeUpdate(sqlCommand, values);
    }

    public int updateData(String sqlCommand, String values[]) {
        return executeUpdate(sqlCommand, values);
    }

    public int executeUpdate(String sqlCommand, String values[]) {
        if (sqlCommand == null) {
            throw new NullPointerException("SQL command is null");
        }
        int rowNumber = 0;
        try {
            PreparedStatement ps = connection.prepareStatement(sqlCommand);
            for (int i = 0; i < values.length; i++) {
                ps.setString(i + 1, values[i]);
            }
            rowNumber = ps.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return rowNumber;
    }

}