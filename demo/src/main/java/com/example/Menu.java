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
    public VBox grid = new VBox(20);
    private Label label1 = new Label("Welcome");

  
    public Menu(){
        label1.setStyle("-fx-font-size: 2em; ");
        grid.setAlignment(Pos.CENTER);
        grid.getChildren().addAll(label1);
    }
}
