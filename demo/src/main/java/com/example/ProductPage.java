package com.example;
import javafx.scene.layout.GridPane;
import java.util.ArrayList;
import com.example.Product;
import javafx.scene.text.Text;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class ProductPage {
    public ArrayList<Product> products = new ArrayList<Product>();
    public GridPane grid = new GridPane();
    private TextField textField = new TextField();
    private Text title = new Text();
    private Button searchButton= new Button("search");



    public ArrayList<Product> getProducts(){
        return products;
    }

    private void addProduct(Product product){
        products.add(product);
    }
    public ProductPage(){
        title.setText("Product Page");
        searchButton.setStyle("-fx-background-color: #9FE2BF ");
        grid.addRow(0, title, textField, searchButton);
        
        
        searchButton.setOnAction(e -> {
            String text = textField.getText();
            //Products will be added to the arrayList of products and 
            // also will show up on the screen here

            /* 
            Product product = new Product(text, 0, 0, 0);
            addProduct(product);
            */
        }); 
    }


    
}
