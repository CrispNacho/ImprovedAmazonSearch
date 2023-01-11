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
    
    public VBox implementScreen(){
        VBox layout1 = new VBox(20);
        
          //Scene 1
        Label label1 = new Label("Welcome");
        label1.setStyle("-fx-font-size: 2em; ");
        layout1.setAlignment(Pos.CENTER);
        layout1.getChildren().addAll(label1);


        
        return layout1;
    }
}
