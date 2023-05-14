package ma.enset.GestionScolarite.presentations;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class ApplicationGFilière extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        BorderPane root= FXMLLoader.load(getClass().getResource("FiliereView.fxml"));
        Scene scene=new Scene(root,800,600);
        scene.getStylesheets().add(getClass().getResource("css/style.css").toString());
        primaryStage.setTitle("Filiere");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
