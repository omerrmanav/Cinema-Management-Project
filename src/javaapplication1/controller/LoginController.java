
package javaapplication1.controller;

/**
 *
 * @author omerrmanav
 */
import java.io.IOException;
import javaapplication1.SqlConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javaapplication1.Alerts;
import javafx.scene.Node;

public class LoginController {

    @FXML
    private Button buttonNext;

    @FXML
    private GridPane gridPaneLogIn;

    @FXML
    private Hyperlink hyperlinkCreateAccount;

    @FXML
    private ImageView imageViewMain;

    @FXML
    private Label labelCinema;

    @FXML
    private Label labelManagement;

    @FXML
    private Label labelPassword;

    @FXML
    private Label labelUsername;

    @FXML
    private AnchorPane main;

    @FXML
    private PasswordField passwordField;

    @FXML
    private TextField textFieldUsername;
    
    

    @FXML
    void buttonNextClicked(ActionEvent event) {
        //boşkontrolü
        String username = textFieldUsername.getText();
        String password = passwordField.getText();
        
        if(username.isBlank() || password.isBlank()) {
            Alerts.errorEmptyLogin();
            return;
        }
        
        try {
            Connection connection = SqlConnection.getConnection();
            
            String query = "SELECT * FROM admin WHERE username = ? AND password = ?";
            
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, username);
            statement.setString(2, password);
            
            ResultSet resultSet = statement.executeQuery();
            
            if(resultSet.next()) {
                System.out.println("Succesfully login");
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/javaapplication1/fxml/dashboard.fxml")); 
                    Parent newRoot = loader.load();
                    Scene currentScene = ((Node) event.getSource()).getScene();
                    currentScene.setRoot(newRoot);
                } catch (Exception e) {
                    e.printStackTrace();  
                }
            } else {
                System.out.println("Failed login");
                Alerts.errorLogin();
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    void hyperlinkCreateAccountClicked(ActionEvent event) {
        try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/javaapplication1/fxml/signup.fxml"));
        Parent root = loader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root, 438, 401));
        stage.show();
    } catch (IOException e) {
        e.printStackTrace();
    }
    }

}

