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
        //Title of window
        stage.setTitle("Amazon Improved Search");

        //Next buttons for respective screens
        Button summaryScreenButton = new Button("Summary Dashboard");
        summaryScreenButton.setStyle("-fx-background-color: #9FE2BF ");
        Button searchScreenButton = new Button("Search");
        searchScreenButton.setStyle("-fx-background-color: #9FE2BF ");

        
        //Create screens obects
        Menu mainMenuScreen = new Menu();
        VBox mainMenuScreen1 = mainMenuScreen.implementScreen();

        ProductPage productScreen = new ProductPage();
        GridPane productScreen1 = productScreen.implementScreen();
        System.out.println(productScreen.getProducts().get(0).name);

        SummaryPage summaryPageScreen = new SummaryPage();
        GridPane summaryPageScreen1 = summaryPageScreen.implementScreen();


        //Creating scene objects
        Scene summaryScreenScene = new Scene(summaryPageScreen1,640, 480);

        

        
        //Next buttons event handlers
        summaryScreenButton.setOnAction(e -> {   
            stage.setScene(summaryScreenScene);
        }); 
        searchScreenButton.setOnAction(e -> {
            scene = new Scene(productScreen1, 640, 480);
            stage.setScene(scene);

        }); 

        mainMenuScreen1.getChildren().addAll(searchScreenButton, summaryScreenButton);
        scene = new Scene(mainMenuScreen1, 640, 480);
        stage.setScene(scene);
        stage.show();
        
        
        
    }
    public static void main(String[] args) {
        launch();
    }

}