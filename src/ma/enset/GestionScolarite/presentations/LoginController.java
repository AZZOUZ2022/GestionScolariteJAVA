package ma.enset.GestionScolarite.presentations;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import ma.enset.GestionScolarite.dao.ConnectionDB;

import javax.swing.*;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    @FXML
    private ImageView myscol;

    @FXML
    private TextField username;

    @FXML
    private PasswordField password;

    @FXML
    private Button log;

    private ResultSet result;

    public void login(ActionEvent event) throws SQLException {

        try{
            Connection connect= ConnectionDB.getConnection();
            PreparedStatement statement=connect.prepareStatement("SELECT * FROM ADMIN WHERE USERNAME=? and PASSWORD=?");
            statement.setString(1,username.getText());
            statement.setString(2,password.getText());
            result=statement.executeQuery();

            if(result.next()){
                log.getScene().getWindow().hide();
                BorderPane rooot= FXMLLoader.load(getClass().getResource("Home.fxml"));

                Scene scene=new Scene(rooot,800,600);
                scene.getStylesheets().add(getClass().getResource("css/style.css").toString());
                Stage stage=new Stage();
                stage.setTitle("Filiere");
                stage.setScene(scene);
                stage.show();
            }else {
                JOptionPane.showMessageDialog(null, "Username or Password" , "('-')",JOptionPane.ERROR_MESSAGE);
            }

        }catch (Exception e ){
            e.printStackTrace();
        }
    }



    public void exit(){
        System.exit(0);
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
