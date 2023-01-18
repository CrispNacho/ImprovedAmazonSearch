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
    public ArrayList<Product> selectedProducts = new ArrayList<Product>();
    public GridPane grid = new GridPane();
    public VBox layout1 = new VBox(20);
    public ScrollPane scrollPane = new ScrollPane();
    private TextArea items = new TextArea();
    

    public SummaryPage(){
        Label title = new Label("Summary Dashboard");
        title.setStyle("-fx-font-size: 2em; ");
        scrollPane.setVbarPolicy(ScrollBarPolicy.AS_NEEDED);
        scrollPane.setHbarPolicy(ScrollBarPolicy.AS_NEEDED);

        layout1.getChildren().addAll(title);
        scrollPane.setContent(layout1);

        
        

    }
    public void addProductsToScreen(ArrayList<Product> products){
        String string = "";
        for(Product product: products){
            layout1.getChildren().addAll(product.text);
            layout1.getChildren().addAll(product.button);
        }
    }
    public void addToSelectedProducts(Product product){
        selectedProducts.add(product);
    }
    public String getSelectedProducts(){
        return selectedProducts.get(0).name;
    }



    
}