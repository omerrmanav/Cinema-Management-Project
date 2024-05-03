package javaapplication1.controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import javaapplication1.Alerts;
import javaapplication1.Movie;
import javaapplication1.SqlConnection;
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

import java.sql.PreparedStatement;

public class MoviesController {

    @FXML
    private Button buttonAdd;

    @FXML
    private Button buttonCustomers;

    @FXML
    private Button buttonDashboard;

    @FXML
    private Button buttonDelete;

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
    private TableColumn<Movie, LocalDate> tableColumnDate;

    @FXML
    private TableColumn<Movie, Integer> tableColumnDuration;

    @FXML
    private TableColumn<Movie, String> tableColumnGenre;

    @FXML
    private TableColumn<Movie, Integer> tableColumnId;

    @FXML
    private TableColumn<Movie, String> tableColumnTitle;

    @FXML
    private TableView<Movie> tableViewAddMovies;
    
    public void initialize() {
        tableColumnId.setCellValueFactory(new PropertyValueFactory<>("id"));
        tableColumnTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        tableColumnGenre.setCellValueFactory(new PropertyValueFactory<>("genre"));
        tableColumnDuration.setCellValueFactory(new PropertyValueFactory<>("duration"));
        tableColumnDate.setCellValueFactory(new PropertyValueFactory<>("date"));
    
        loadMovieList();
            
        
    }
    
    private ObservableList<Movie> movieList;
    
    public void setMovieList(ObservableList<Movie> movieList) {
        this.movieList = movieList;
        tableViewAddMovies.setItems(movieList);
    }
    
    private void loadMovieList() {
        try {
            Connection connection = SqlConnection.getConnection();
            movieList = FXCollections.observableArrayList();
            String query = "SELECT * FROM movies";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                Integer id = resultSet.getInt("idmovies");
                String title = resultSet.getString("title");
                String genre = resultSet.getString("genre");
                int duration = resultSet.getInt("duration");
                LocalDate date = resultSet.getDate("date").toLocalDate();
                movieList.add(new Movie(id,title, genre, duration, date));
            }
            statement.close();
            tableViewAddMovies.setItems(movieList);
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
    void buttonDeleteClicked(ActionEvent event) {
        // Seçili satırı al
        Movie selectedMovie = tableViewAddMovies.getSelectionModel().getSelectedItem();

        if (selectedMovie == null) {
            Alerts.selectRowToDelete();
            return;
        }

        try {
            
            Connection connection = SqlConnection.getConnection();
            int movieId = selectedMovie.getId();
            String query = "DELETE FROM movies WHERE idmovies = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, movieId);
            int rowsDeleted = statement.executeUpdate();

            
            if (rowsDeleted > 0) {
                Alerts.successDeleteMovie();
                loadMovieList();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
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

