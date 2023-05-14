package ma.enset.GestionScolarite.presentations;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HomeController implements Initializable {
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
    @FXML
    void ETU(ActionEvent event) {
        Stage primaryStage= new Stage();
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("GestionEtudiants.fxml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    @FXML
    void abs(ActionEvent event) {
        Stage primaryStage= new Stage();
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("GestionAbsences.fxml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @FXML
    void fil(ActionEvent event) {
        Stage primaryStage= new Stage();
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("GestionFilieres.fxml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @FXML
    void not(ActionEvent event) {
        Stage primaryStage= new Stage();
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("GestionNotes.fxml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
