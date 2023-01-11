package com.example;
import javafx.scene.layout.GridPane;
import java.util.ArrayList;
import com.example.Product;

public class ProductPage {
    public GridPane implementScreen(){
        GridPane screen = new GridPane();

        ArrayList<Product> products = new ArrayList<Product>();
        
        Product product = new Product("text", 69.69, 6.9, 69);
        products.add(product);

        System.out.println(products.get(0).cost);

        return screen;
    }


    
}
