package sample;

import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DialogPane;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.awt.event.*;

public class Main extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {
        Controller controller = new Controller();
        Parent root = FXMLLoader.load(getClass().getResource("/StackPaneWindow.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Kalkulator");
        primaryStage.show();


    }

    public static void main(String[] args) {
        launch(args);
    }


}
