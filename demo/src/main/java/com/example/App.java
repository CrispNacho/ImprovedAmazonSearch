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
import javafx.scene.layout.VBox;

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

        Button summaryScreenButton = new Button("Summary Dashboard");
        summaryScreenButton.setStyle("-fx-background-color: #9FE2BF ");
        Button searchScreenButton = new Button("Search");
        searchScreenButton.setStyle("-fx-background-color: #9FE2BF ");

        stage.setTitle("Amazon Improved Search");
        Menu mainMenuScreen = new Menu();
        VBox mainMenuScreen1 = mainMenuScreen.implementScreen();

        //summaryScreenButton.setOnAction(e -> stage.setScene(scene2)); 
        //searchScreenButton.setOnAction(e -> stage.setScene(scene3)); 

        mainMenuScreen1.getChildren().addAll(searchScreenButton, summaryScreenButton);
        scene = new Scene(mainMenuScreen1, 640, 480);
        stage.setScene(scene);
        stage.show();
        
        
    }
    public static void main(String[] args) {
        launch();
    }

}