package com.example;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;


public class SummaryPage {
    public GridPane implementScreen(){
        GridPane screen = new GridPane();
        Text title = new Text();
        title.setText("Summary Page");
        screen.addRow(0, title);
        
        
        return screen;
    }


    
}