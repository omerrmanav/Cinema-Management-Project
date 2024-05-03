package javaapplication1.controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;
import javaapplication1.SqlConnection;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class DashboardController {

    @FXML
    private AnchorPane anchorPaneMovies;

    @FXML
    private AnchorPane anchorPaneTickets;

    @FXML
    private Button buttonAdd;

    @FXML
    private Button buttonCustomers;

    @FXML
    private Button buttonDashboard;

    @FXML
    private Button buttonEdit;

    @FXML
    private Button buttonMovies;

    @FXML
    private Button buttonSignOut;

    @FXML
    private ImageView imageViewAddMovies;

    @FXML
    private ImageView imageViewAdmin;

    @FXML
    private ImageView imageViewCustomers;

    @FXML
    private ImageView imageViewDashboard;

    @FXML
    private ImageView imageViewEditMovies;

    @FXML
    private ImageView imageViewMovies;

    @FXML
    private ImageView imageViewMoviess;

    @FXML
    private ImageView imageViewSignOut;

    @FXML
    private ImageView imageViewStudents;

    @FXML
    private ImageView imageViewTotalSoldTickets;

    @FXML
    private Label labelAdmin;

    @FXML
    private Label labelDashboard;

    @FXML
    private Label labelMovies;

    @FXML
    private Label labelTotalSoldTickets;

    @FXML
    private Label labelWelcome;

    @FXML
    private AnchorPane leftSide;

    @FXML
    private AnchorPane mainPage;

    @FXML
    private Separator seperator;

    @FXML
    private Label totalCustomer;

    @FXML
    private Label totalMovie;
    
    // labelda adet gösterilcek kalsın
    String movie;
    String user;

    private int getRowCount() {
        int rowCount = 0;
        try {
            Connection connection = SqlConnection.getConnection();
            String query = "SELECT COUNT(*) AS rowCount FROM cinema.movies";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next()) {
                rowCount = resultSet.getInt("rowCount");
                movie = String.valueOf(rowCount); 
            }
            statement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return rowCount;
    }
    
    private int getUserCount() {
    int userCount = 0;
    try {
        Connection connection = SqlConnection.getConnection();
        String query = "SELECT COUNT(*) AS userCount FROM cinema.user"; 
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        if (resultSet.next()) {
            userCount = resultSet.getInt("userCount");
            user = String.valueOf(userCount); 
        }
        statement.close();
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
    return userCount;
}

    public void initialize() {
        int rowCount = getRowCount(); 
        totalMovie.setText(movie); 
        
        int userCount = getUserCount(); 
        totalCustomer.setText(user); 
    }

    @FXML
    void buttonAddClicked(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/javaapplication1/fxml/addmovies.fxml")); 
            Parent newRoot = loader.load();
            Scene currentScene = ((Node) event.getSource()).getScene();
            currentScene.setRoot(newRoot);
        } catch (Exception e) {
            e.printStackTrace();  
        }
    }   



    @FXML
    void buttonCustomersClicked(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/javaapplication1/fxml/customers.fxml")); 
            Parent newRoot = loader.load();
            Scene currentScene = ((Node) event.getSource()).getScene();
            currentScene.setRoot(newRoot);
        } catch (Exception e) {
            e.printStackTrace();  
        }
    }

    @FXML
    void buttonDashboardClicked(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/javaapplication1/fxml/dashboard.fxml")); 
            Parent newRoot = loader.load();
            Scene currentScene = ((Node) event.getSource()).getScene();
            currentScene.setRoot(newRoot);
        } catch (Exception e) {
            e.printStackTrace();  
        }
    }

    @FXML
    void buttonEditClicked(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/javaapplication1/fxml/editmovies.fxml")); 
            Parent newRoot = loader.load();
            Scene currentScene = ((Node) event.getSource()).getScene();
            currentScene.setRoot(newRoot);
        } catch (Exception e) {
            e.printStackTrace();  
        }
    }

    @FXML
    void buttonMoviesClicked(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/javaapplication1/fxml/movies.fxml")); 
            Parent newRoot = loader.load();
            Scene currentScene = ((Node) event.getSource()).getScene();
            currentScene.setRoot(newRoot);
        } catch (Exception e) {
            e.printStackTrace();  
        }
    }

    @FXML
    void buttonSignOutClicked(ActionEvent event) {
        Platform.exit();
    }

}


