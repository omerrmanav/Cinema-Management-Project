package javaapplication1;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class Alerts {
    public static void successAddMovie() {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Add Movies Page");
        alert.setHeaderText("Succesfull");
        alert.setContentText("Movie succesfully saved to database..");
        alert.showAndWait();
    }
    
    public static void failAddMovie() {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Add Movies Page");
        alert.setHeaderText("Failed");
        alert.setContentText("Movie cannot saved!");
        alert.showAndWait();
    }
    
    public static void selectRowToDelete() {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Movies Page");
        alert.setHeaderText("Row Error");
        alert.setContentText("You didn't select any rows.");
        alert.showAndWait();
    }
    
    public static void successDeleteMovie(){
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Movies Page");
        alert.setHeaderText("Success");
        alert.setContentText("Movie deleted succesfully from database.");
        alert.showAndWait();
    }
    
    public static void warning() {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Edit Movies Page");
        alert.setHeaderText("Failed");
        alert.setContentText("Please select a movie to update !");
        alert.showAndWait();
    }
    
    public static void successUpdate(){
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Edit Movies Page");
        alert.setHeaderText("Success");
        alert.setContentText("Movie updated succesfully.");
        alert.showAndWait();
    }
    
     public static void succesAddingAdmin() {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Sign Up Page");
        alert.setHeaderText("Succesfull");
        alert.setContentText("Admin informations succesfully saved to database..");
        alert.showAndWait();
    }
     
     public static void errorLogin() {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Login Page");
        alert.setHeaderText("Failed");
        alert.setContentText("Username or password is missing");
        alert.showAndWait();
    }
     
     public static void errorEmptyLogin() {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Login Page");
        alert.setHeaderText("Failed");
        alert.setContentText("Username or password is empty");
        alert.showAndWait();
    }
     
     public static void successUser() {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("User Page");
        alert.setHeaderText("Succesfull");
        alert.setContentText("Order Succes");
        alert.showAndWait();
    }
     
     public static void errorUser() {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("User Page");
        alert.setHeaderText("Failed");
        alert.setContentText("Couldn't save to database..");
        alert.showAndWait();
    }
}
