
package sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class UserQueries {
    private static final String URL = "jdbc:mysql://remotemysql.com:3306/obsZ7jMTsl?autoReconnect=true&useSSL=false";
    private static final String USERNAME = "obsZ7jMTsl";
    private static final String PASSWORD = "U7CiN59KBE";
    
    private Connection connection;
    private PreparedStatement addUser;
    private Statement deleteUser;
    private PreparedStatement selectAllUsers;
    
    public UserQueries(){
        try{
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            
            addUser = connection.prepareStatement(
                    "INSERT INTO InfoUser "
                    + "(NameUser) VALUES (?)");
            
            deleteUser = connection.createStatement();
            
            selectAllUsers = connection.prepareStatement("SELECT NameUser "
                    + "FROM InfoUser");
            
        }catch(SQLException sql){
            Logger.getLogger(UserQueries.class.getName()).log(Level.SEVERE, null, sql);
        } 
    }
    
    public int AddUser (String name){
        try {
            addUser.setString(1, name);
            return addUser.executeUpdate();
        }catch(SQLException sql){
            Logger.getLogger(UserQueries.class.getName()).log(Level.SEVERE, null, sql);
            return 0;
        }
    }

    public int DeleteUser(String name){
        
        try {
            return deleteUser.executeUpdate("DELETE FROM InfoUser "
                    + "WHERE NameUser = '" + name+ "' ");
        } catch (SQLException sql) {
            Logger.getLogger(UserQueries.class.getName()).log(Level.SEVERE, null, sql);
            return 0;
        }
        
    }
    
    public List<String> getAllUsers(){
        
        try (ResultSet resultSet = selectAllUsers.executeQuery()){
            List<String> results = new ArrayList<>();
            
            while(resultSet.next()){
                results.add(resultSet.getString("NameUser"));
            }
            
            return results;
            
        }catch(SQLException sql){
            Logger.getLogger(UserQueries.class.getName()).log(Level.SEVERE, null, sql);
            return null;
        }
    }
    
    public void Close(){
        try{
            connection.close();
        }catch (SQLException sql){
            Logger.getLogger(UserQueries.class.getName()).log(Level.SEVERE, null, sql);
        }
    }
}
