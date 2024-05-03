package javaapplication1.controller;

import javaapplication1.SqlConnection;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;
import java.sql.PreparedStatement;
import javaapplication1.Alerts;
import javaapplication1.Movie;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;



public class AddMoviesController {

    @FXML
    private Button buttonAdd;

    @FXML
    private Button buttonClear;

    @FXML
    private Button buttonCustomers;

    @FXML
    private Button buttonDashboard;

    @FXML
    private Button buttonEdit;

    @FXML
    private Button buttonInsert;

    @FXML
    private Button buttonMovies;

    @FXML
    private Button buttonSignOut;

    @FXML
    private ComboBox<String> comboBoxGenre;

    @FXML
    private DatePicker datePicker;

    @FXML
    private GridPane gridPaneAddMovies;

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
    private Label labelDate;

    @FXML
    private Label labelDuration;

    @FXML
    private Label labelGenre;

    @FXML
    private Label labelTitle;

    @FXML
    private Label labelWelcome;

    @FXML
    private AnchorPane leftSide;

    @FXML
    private AnchorPane mainPage;

    @FXML
    private Separator seperator;

    @FXML
    private TableColumn<Movie, String> tableColumnDate;

    @FXML
    private TableColumn<Movie, Integer> tableColumnDuration;

    @FXML
    private TableColumn<Movie, String> tableColumnGenre;

    @FXML
    private TableColumn<Movie, String> tableColumnTitle;

    @FXML
    private TableView<Movie> tableViewAddMovies;

    @FXML
    private TextField textFieldDuration;

    @FXML
    private TextField textFieldTitle;
    
    
    public void initialize() {

        comboBoxGenre.getItems().addAll(
            "Action",
            "Adventure",
            "Comedy",
            "Drama",
            "Fantasy",
            "Horror",
            "Mystery",
            "Romance",
            "Sci-Fi",
            "Thriller"
        );
        
        comboBoxGenre.setVisibleRowCount(5);
        
        tableColumnTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        tableColumnGenre.setCellValueFactory(new PropertyValueFactory<>("genre"));
        tableColumnDuration.setCellValueFactory(new PropertyValueFactory<>("duration"));
        tableColumnDate.setCellValueFactory(new PropertyValueFactory<>("date"));
    
        loadMovieList();
            
        
    }
    

    private void loadMovieList() {
        try {
            Connection connection = SqlConnection.getConnection();
            movieList = FXCollections.observableArrayList();
            String query = "SELECT * FROM movies";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                String title = resultSet.getString("title");
                String genre = resultSet.getString("genre");
                int duration = resultSet.getInt("duration");
                LocalDate date = resultSet.getDate("date").toLocalDate();
                movieList.add(new Movie(title, genre, duration, date));
            }
            statement.close();
            tableViewAddMovies.setItems(movieList);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    private ObservableList<Movie> movieList;
    
    public void setMovieList(ObservableList<Movie> movieList) {
        this.movieList = movieList;
        tableViewAddMovies.setItems(movieList);
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
    void buttonClearClicked(ActionEvent event) {
        textFieldTitle.clear();
        textFieldDuration.clear();
        datePicker.setValue(null);
        comboBoxGenre.getSelectionModel().clearSelection();
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
    void buttonInsertClicked(ActionEvent event) throws SQLException {
        // boşsa kaydetme
        if (textFieldTitle.getText().isEmpty() || comboBoxGenre.getValue().isEmpty() ||textFieldDuration.getText().isEmpty() || datePicker.getValue() == null) {
            Alerts.failAddMovie();
            return;
        }
        
        Connection connection = SqlConnection.getConnection();
        
        String title = textFieldTitle.getText();
        String genre = comboBoxGenre.getValue().toString();
        int duration = Integer.parseInt(textFieldDuration.getText());
        LocalDate date = datePicker.getValue();
        
        
        
        String query = "INSERT INTO movies (title, genre, duration, date) VALUES (?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, title);
        statement.setString(2, genre);
        statement.setInt(3, duration);
        statement.setDate(4, java.sql.Date.valueOf(date));
    
        
        int rowsInserted = statement.executeUpdate();
        
        if (rowsInserted > 0) {
            System.out.println("Film basariyla eklendi.");
            Alerts.successAddMovie();
            setMovieList(movieList);
            loadMovieList();
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

