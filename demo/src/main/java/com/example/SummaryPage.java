package com.example;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import java.util.ArrayList;


public class SummaryPage {
    public GridPane grid = new GridPane();
    private Text title = new Text();

    public SummaryPage(){
        title.setText("Summary Page");
        grid.addRow(0, title);
    }
    public void addProductsToScreen(ArrayList<Product> products){
        String string = "";
        for(Product product: products){
            string += product.name;
        }
        title.setText(string);
    }



    
}