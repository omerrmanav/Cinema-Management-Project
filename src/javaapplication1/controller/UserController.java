/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication1.controller;

/**
 *
 * @author omerrmanav
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javaapplication1.Alerts;
import javaapplication1.Movie;
import javaapplication1.SqlConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class UserController {

    @FXML
    private Button buttonSave;

    @FXML
    private ComboBox<Integer> comboBoxSeats;

    @FXML
    private AnchorPane header;

    @FXML
    private ImageView imageViewSeats;

    @FXML
    private Label labelMail;

    @FXML
    private Label labelName;

    @FXML
    private Label labelSeat;

    @FXML
    private Label labelUserPanel;

    @FXML
    private AnchorPane main;

    @FXML
    private TableColumn<Movie, String> tableColumnTitle;

    @FXML
    private TableView<Movie> tableViewMovie;

    @FXML
    private TextField textFieldMail;

    @FXML
    private TextField textFieldName;
    
    public void initialize() {
        
        ObservableList<Integer> seatOptions = FXCollections.observableArrayList();
        for (int i = 1; i <= 20; i++) {
            seatOptions.add(i);
        }
        
        comboBoxSeats.setItems(seatOptions);
        
        comboBoxSeats.getSelectionModel().selectFirst(); 
        
        tableColumnTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        
        loadMovieList();
    }
    
    
    private void loadMovieList() {
    Connection connection;
    try {
        connection = SqlConnection.getConnection();
        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery("SELECT title FROM movies");

        ObservableList<Movie> movieList = FXCollections.observableArrayList();

        while (resultSet.next()) {
            String title = resultSet.getString("title");
            movieList.add(new Movie(title));
        }

        // Set the items to the TableView
        tableViewMovie.setItems(movieList);

    } catch (SQLException ex) {
        ex.printStackTrace();
    }

}

    @FXML
    void buttonSaveClicked(ActionEvent event) {
        String sname = textFieldName.getText();
        String smail = textFieldMail.getText();
        String seat = comboBoxSeats.getValue().toString();
        String title = tableViewMovie.getSelectionModel().getSelectedItem().getTitle();
        
        if(sname.isEmpty() || smail.isEmpty() || seat.isEmpty() || title.isEmpty()) {
             Alerts.errorUser();
        }
        
        
        try {
            Connection connection = SqlConnection.getConnection();
            
            String query = "INSERT INTO user (name, mail, seatnumber, moviename) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            
            
            statement.setString(1, sname);
            statement.setString(2, smail);
            statement.setString(3, seat);
            statement.setString(4, title);
            
            
            int rowsEffected = statement.executeUpdate();
            
            if(rowsEffected > 0) {
                System.out.println("Order success.");
                Alerts.successUser();
                
            } else {
                Alerts.errorUser();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
    }

}

