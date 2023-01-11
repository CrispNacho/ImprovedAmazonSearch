package com.example;
//import javafx.scene.layout.GridPane;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.geometry.Pos;

public class Menu {
    
    Scene scene1, scene2, scene3;;
    
    public GridPane implementScreen(){
        VBox layout1 = new VBox(20);
        
        primaryStage.setTitle("Improved Amazon Search");
        
          //Scene 1
          Label label1 = new Label("Welcome");
          label1.setStyle("-fx-font-size: 2em; ");
          Button button1 = new Button("Summary Dashboard");
          button1.setStyle("-fx-background-color: #9FE2BF ");
          Button button2 = new Button("Search");
          button2.setStyle("-fx-background-color: #9FE2BF ");

          //Proceeding to the next scene rename scene2/3 to whatever it's called 
          button1.setOnAction(e -> primaryStage.setScene(scene2)); 
          button2.setOnAction(e -> primaryStage.setScene(scene3)); 

          layout1.setAlignment(Pos.CENTER);
          layout1.getChildren().addAll(label1, button1, button2);

          scene1 = new Scene(layout1, 300, 500);
        
          primaryStage.setScene(scene1);
          primaryStage.show();
        
       //return layout1;
    }
}
