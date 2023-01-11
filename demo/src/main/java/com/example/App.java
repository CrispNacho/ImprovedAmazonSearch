package com.example;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
import javafx.scene.control.ScrollBar;  
import java.io.IOException;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Button;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    ScrollPane otherPane = new ScrollPane();
    @Override
    public void start(Stage stage) throws IOException {
        Button nextScreenBtn = new Button("Next Screen Button");
        nextScreenBtn.setText("Next");

        stage.setTitle("Amazon Improved Search");
        Menu mainMenuScreen = new Menu();
        GridPane mainMenuScreen1 = mainMenuScreen.implementScreen();
        scene = new Scene(mainMenuScreen1, 640, 480);
        mainMenuScreen1.addRow(0, nextScreenBtn);
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        launch();
    }

}