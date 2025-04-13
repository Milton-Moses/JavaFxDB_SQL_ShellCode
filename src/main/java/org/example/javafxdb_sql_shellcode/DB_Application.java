package org.example.javafxdb_sql_shellcode;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.animation.FadeTransition;
import javafx.util.Duration;
import org.example.javafxdb_sql_shellcode.db.ConnDbOps;


public class DB_Application extends Application {

    private static ConnDbOps cdbop;

    public static void main(String[] args) {

        Application.launch(DB_Application.class, args);
        cdbop = new ConnDbOps();
    }


    private Stage primaryStage;

    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setResizable(false);
        showScene1();
    }

    private void showScene1() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("splash_screen.fxml"));
            Scene scene = new Scene(root, 850, 560);
            scene.getStylesheets().add(getClass().getResource("styling/style.css").toExternalForm());
            primaryStage.setScene(scene);
            primaryStage.show();
            changeScene();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    FadeTransition fadeIn;
    public void changeScene() {
        try {
            Parent newRoot = FXMLLoader.load(getClass().getResource("db_interface_gui.fxml"));

            Scene currentScene = primaryStage.getScene();
            Parent currentRoot = currentScene.getRoot();
            //currentScene.getStylesheets().add(getClass().getResource("styling/style.css").toExternalForm());
            FadeTransition fadeOut = new FadeTransition(Duration.seconds(2), currentRoot);
            fadeOut.setFromValue(1);
            fadeOut.setToValue(0);
            fadeOut.setOnFinished(e -> {
                newRoot.setOpacity(0);
                Scene newScene = new Scene(newRoot,850, 560);
                primaryStage.setScene(newScene);
                fadeIn.play();
            });
            fadeOut.play();
            fadeIn = new FadeTransition(Duration.seconds(2), newRoot);
            fadeIn.setFromValue(0);
            fadeIn.setToValue(1);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}