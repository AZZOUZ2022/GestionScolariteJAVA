package ma.enset.GestionScolarite.presentations;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class ApplicationLogin extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    private double x=0;
    private double y=0;

    @Override
    public void start(Stage primaryStage) throws Exception {
        AnchorPane root= FXMLLoader.load(getClass().getResource("LoginView.fxml"));

        root.setOnMousePressed((MouseEvent event)->{

            x= event.getSceneX();
            y= event.getSceneX();

        });

        root.setOnMouseDragged((MouseEvent event)->{

            primaryStage.setX(event.getScreenX() - x);
            primaryStage.setY(event.getScreenX() - y);

        });

        Scene scene=new Scene(root);

        primaryStage.initStyle(StageStyle.TRANSPARENT);

        primaryStage.setScene(scene);
        primaryStage.show();
    }


}
