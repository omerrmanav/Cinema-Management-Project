package javaapplication1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SqlConnection {
    
    static final String URL = "jdbc:mysql://localhost:3306/cinema";
    static final String USERNAME = "root";
    static final String PASSWORD = "password";
   
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }
    
    public static void main(String[] args) throws SQLException {
        
        Connection connection = null;
        
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("Veritabanına başarıyla bağlandı!");
            
        } catch(SQLException e) {
            System.out.println("Veritabanına bağlanırken bir hata oluştu: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
}
