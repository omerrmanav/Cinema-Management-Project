/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication1.controller;

/**
 *
 * @author omerrmanav
 */
import javaapplication1.SqlConnection;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.PreparedStatement;
import javaapplication1.Alerts;

public class SignUpController {

    @FXML
    private AnchorPane account;

    @FXML
    private Button buttonExit;

    @FXML
    private Button buttonSignUp;

    @FXML
    private Hyperlink hyperLinkLogin;

    @FXML
    private Label label2;

    @FXML
    private Label labelCreateAccount;

    @FXML
    private TextField textFieldPassword;

    @FXML
    private TextField textFieldUsername;
    
    public void initialize() {
        textFieldUsername.setStyle("-fx-background-color: black; -fx-text-fill: white; -fx-border-radius: 20; -fx-border-color: white;");
        textFieldPassword.setStyle("-fx-background-color: black; -fx-text-fill: white; -fx-border-radius: 20; -fx-border-color: white;");
    }


    @FXML
    void buttonExitClicked(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    void buttonSignUpClicked(ActionEvent event) {
        try {
            Connection connection = SqlConnection.getConnection();
            
            String username = textFieldUsername.getText();
            String password = textFieldPassword.getText();
            
            String query = "INSERT INTO admin (username, password) VALUES (?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            
            statement.setString(1, username);
            statement.setString(2, password);
            
            int rowsEffected = statement.executeUpdate();
            
            if(rowsEffected > 0) {
                System.out.println("Admin informations succefuly saved to database");
                Alerts.succesAddingAdmin();
                textFieldPassword.clear();
                textFieldUsername.clear();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

}

