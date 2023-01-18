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
        
        


        WebScraper scraper = new WebScraper();
        scraper.scraper();

        //Title of window
        stage.setTitle("Amazon Improved Search");

        //Next buttons for respective screens

        //Main Screen Next Buttons
        Button summaryScreenButton = new Button("Summary Dashboard");
        summaryScreenButton.setStyle("-fx-background-color: #9FE2BF ");
        Button searchScreenButton = new Button("Search");
        searchScreenButton.setStyle("-fx-background-color: #9FE2BF ");

        //Prodcut Screen Next Buttons
        Button summaryScreenButton1 = new Button("Summary Dashboard");
        summaryScreenButton1.setStyle("-fx-background-color: #9FE2BF ");

        //Summary Screen Next Buttons
        Button searchScreenButton1= new Button("Search");
        searchScreenButton1.setStyle("-fx-background-color: #9FE2BF ");


        
        //Create screens obects
        Menu menuScreen = new Menu();
        menuScreen.grid.getChildren().addAll(searchScreenButton, summaryScreenButton);

        ProductPage productScreen = new ProductPage();
        productScreen.grid.addRow(0, summaryScreenButton1);


        SummaryPage summaryScreen = new SummaryPage();
        summaryScreen.grid.addRow(0, searchScreenButton1);

        

        //Creating scene objects
        Scene summaryScreenScene = new Scene(summaryScreen.scrollPane,640, 480);
        Scene productScreenScene = new Scene(productScreen.scrollPane, 640, 480);
        Scene menuScreenScene = new Scene(menuScreen.grid, 640, 480);
        
        
        //Next buttons event handlers

        //Main Screen buttons
        summaryScreenButton.setOnAction(e -> {   
            stage.setScene(summaryScreenScene);
        }); 

        searchScreenButton.setOnAction(e -> { 
            stage.setScene(productScreenScene);

        }); 

        //Product Screen Buttons
        summaryScreenButton1.setOnAction(e -> {   
            System.out.println("changed screens");
            summaryScreen.addProductsToScreen(productScreen.getSelectedProducts());
            stage.setScene(summaryScreenScene);

        }); 
        //Summary Screen Buttons
        searchScreenButton1.setOnAction(e -> {   
            stage.setScene(productScreenScene);
        }); 

        //Sets the default page to be the menu
        stage.setScene(menuScreenScene);
        stage.show();
        
        
        
    }
    public static void main(String[] args) throws IOException {
        launch();
    }

}