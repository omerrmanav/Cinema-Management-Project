
package javaapplication1.controller;

/**
 *
 * @author omerrmanav
 */
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class FirstController {

    @FXML
    private Button buttonAdmin;

    @FXML
    private Button buttonUser;

    @FXML
    private ImageView imageViewMain;

    @FXML
    private Label labelWelcome;

    @FXML
    private AnchorPane main;

    @FXML
    void buttonAdminClicked(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/javaapplication1/fxml/login.fxml")); 
            Parent newRoot = loader.load();
            Scene currentScene = ((Node) event.getSource()).getScene();
            currentScene.setRoot(newRoot);
        } catch (Exception e) {
            e.printStackTrace();  
        }
    }

    @FXML
    void buttonUserClicked(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/javaapplication1/fxml/userpanel.fxml")); 
            Parent newRoot = loader.load();
            Scene currentScene = ((Node) event.getSource()).getScene();
            currentScene.setRoot(newRoot);
        } catch (Exception e) {
            e.printStackTrace();  
        }
    }

}

