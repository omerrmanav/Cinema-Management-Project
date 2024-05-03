package javaapplication1.controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import javaapplication1.Movie;
import javaapplication1.SqlConnection;
import javaapplication1.User;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class CustomersController {

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
    private ImageView imageViewSignOut;

    @FXML
    private Label labelAdmin;

    @FXML
    private Label labelDashboard;

    @FXML
    private Label labelWelcome;

    @FXML
    private AnchorPane leftSide;

    @FXML
    private AnchorPane mainPage;

    @FXML
    private Separator seperator;

    @FXML
    private TableColumn<User, String> tableColumnSeat;

    @FXML
    private TableColumn<User, String> tableColumnMovie;

    @FXML
    private TableColumn<User, String> tableColumnName;

    @FXML
    private TableColumn<User, String> tableColumnMail;

    @FXML
    private TableView<User> tableViewCustomers;
    
    public void initialize() {
        tableColumnSeat.setCellValueFactory(new PropertyValueFactory<>("seatNumber"));
        tableColumnName.setCellValueFactory(new PropertyValueFactory<>("name"));
        tableColumnMovie.setCellValueFactory(new PropertyValueFactory<>("movieName")); 
        tableColumnMail.setCellValueFactory(new PropertyValueFactory<>("mail"));
    
        loadUserList();
            
        
    }
    
    private ObservableList<User> userList;
    
    public void setMovieList(ObservableList<User> userList) {
        this.userList = userList;
        tableViewCustomers.setItems(userList);
    }
    
    private void loadUserList() {
        try {
            Connection connection = SqlConnection.getConnection();
            userList = FXCollections.observableArrayList();
            String query = "SELECT * FROM cinema.user";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                String seatnumber = resultSet.getString("seatnumber");
                String name = resultSet.getString("name");
                String movie = resultSet.getString("moviename");
                String mail = resultSet.getString("mail");
                userList.add(new User(seatnumber, name, movie, mail));
            }
            statement.close();
            tableViewCustomers.setItems(userList);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
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

