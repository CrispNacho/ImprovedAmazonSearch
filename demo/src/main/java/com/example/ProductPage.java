package com.example;
import javafx.scene.layout.GridPane;
import java.util.ArrayList;
import com.example.Product;
import javafx.scene.text.Text;

public class ProductPage {
    public ArrayList<Product> products = new ArrayList<Product>();
    public GridPane implementScreen(){
        GridPane screen = new GridPane();
        Text title = new Text();
        title.setText("Product Page");
        screen.addRow(0, title);
        
        
        Product product = new Product("text", 69.69, 6.9, 69);
        products.add(product);
        //System.out.println(products.get(0).cost);
        return screen;
    }
    public ArrayList<Product> getProducts(){
        return products;
    }


    
}
