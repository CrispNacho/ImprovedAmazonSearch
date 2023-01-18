package com.example;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import java.util.ArrayList;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.control.ScrollPane;
import javafx.event.ActionEvent;
import javafx.scene.layout.VBox;
import javafx.geometry.Pos;
import javafx.scene.control.TextArea;


public class SummaryPage {
    public ArrayList<Product> selectedProductsAddedToPage = new ArrayList<Product>();
    public GridPane grid = new GridPane();
    public VBox layout1 = new VBox(20);
    public ScrollPane scrollPane = new ScrollPane();
    private TextArea items = new TextArea();
    

    public SummaryPage(){
        Label title = new Label("Summary Dashboard");
        title.setStyle("-fx-font-size: 2em; ");
        scrollPane.setVbarPolicy(ScrollBarPolicy.AS_NEEDED);
        scrollPane.setHbarPolicy(ScrollBarPolicy.AS_NEEDED);
        grid.addRow(0, title);
        //layout1.getChildren().addAll(title);

        scrollPane.setContent(grid);

        
        

    }


    public void addProductsToScreen(ArrayList<Product> products){
        
        System.out.println("adding products to screen");
        for(int i = 0; i < products.size(); i++){

            if(products.get(i).displayedOnSummary == false){

            grid.addRow(i + 1, products.get(i).summaryText, products.get(i).delButton);
            products.get(i).displayedOnSummary = true;
            }

        }
        
    }
    
    
    //add method which sets the delete button on action event




    
}