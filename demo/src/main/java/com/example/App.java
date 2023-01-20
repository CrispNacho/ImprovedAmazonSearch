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
import java.util.ArrayList;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    ScrollPane otherPane = new ScrollPane();
    private CSV csv = new CSV();
    
    @Override
    public void start(Stage stage) throws IOException {
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
        Button exitToMenuButton = new Button("Exit");
        exitToMenuButton.setStyle("-fx-background-color: #9FE2BF ");

        
        //Create screens obects
        Menu menuScreen = new Menu();
        menuScreen.grid.getChildren().addAll(searchScreenButton, summaryScreenButton);

        ProductPage productScreen = new ProductPage();
        productScreen.titleGrid.addRow(0, summaryScreenButton1);


        SummaryPage summaryScreen = new SummaryPage();
        summaryScreen.titleGrid.addRow(0, searchScreenButton1, exitToMenuButton);

        

        //Creating scene objects
        Scene summaryScreenScene = new Scene(summaryScreen.scrollPane,640, 480);
        Scene productScreenScene = new Scene(productScreen.scrollPane, 640, 480);
        Scene menuScreenScene = new Scene(menuScreen.grid, 640, 480);
        
        
        //Next buttons event handlers

        //Main Screen buttons
        summaryScreenButton.setOnAction(e -> {   
            ArrayList<Product> products = new ArrayList<Product>();
            csv.importFromCSV(products);

            summaryScreen.addProductsToScreen(products);
            summaryScreen.addProductButtons(products);
            stage.setScene(summaryScreenScene);
        }); 

        searchScreenButton.setOnAction(e -> { 
            productScreen.getSelectedProducts().clear();
            csv.importFromCSV(productScreen.getSelectedProducts());
            stage.setScene(productScreenScene);

        }); 

        //Product Screen Buttons
        summaryScreenButton1.setOnAction(e -> {
            ArrayList<Product> products = new ArrayList<Product>();
            csv.importFromCSV(products);
            summaryScreen.setProducts(products);
            summaryScreen.addProductsToScreen(products);
            summaryScreen.addProductButtons(products);
            stage.setScene(summaryScreenScene);

        }); 
        //Summary Screen Buttons
        searchScreenButton1.setOnAction(e -> {
            productScreen.getSelectedProducts().clear();
            csv.importFromCSV(productScreen.getSelectedProducts());
            stage.setScene(productScreenScene);
        });
        exitToMenuButton.setOnAction(e -> { 
            productScreen.clearProductScreen();
            stage.setScene(menuScreenScene);
        });

        //Sets the default page to be the menu
        stage.setScene(menuScreenScene);
        stage.show();
        
        
        
    }
    public static void main(String[] args) throws IOException {
        launch();
    }

}