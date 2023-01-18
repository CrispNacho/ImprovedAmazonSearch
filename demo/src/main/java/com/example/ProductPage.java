package com.example;
import javafx.scene.layout.GridPane;

import java.io.IOException;
import java.util.ArrayList;
import com.example.Product;
import javafx.scene.text.Text;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;


public class ProductPage {
    public ArrayList<Product> products = new ArrayList<Product>();
    private ArrayList<Product> selectedProducts = new ArrayList<Product>();
    public GridPane grid = new GridPane();
    private TextField textField = new TextField();
    private Text title = new Text();
    private Button searchButton= new Button("search");
    public ScrollPane scrollPane = new ScrollPane();

    private void addProductsAndButton(){
        /* 
        for(int i = 0; i < 25; i ++){
            Product banana = new Product("banana", i, 4.1, 0);
            addProduct(banana);
        }
        */
        for(Product product: products){
            product.button.setOnAction(e -> {  
                //if the product is not already in the array then add it
            if(!selectedProducts.contains(product)){
                selectedProducts.add(product);
            }   
            
            System.out.println(selectedProducts);

            });
        } 

    }
    private void removeProduct(Product product){
        System.out.println("removing product with row " + product.row + " and coloumn" + product.coloumn);
        grid.getChildren().removeIf( node -> GridPane.getColumnIndex(node) == product.coloumn && GridPane.getRowIndex(node) == product.row);
        grid.getChildren().removeIf( node -> GridPane.getColumnIndex(node) == product.coloumn+1 && GridPane.getRowIndex(node) == product.row);
    }



    private void addProductsToScreen(ArrayList<Product> products){
        for(int i = 1; i < products.size(); i+=2){
            
            grid.addRow(i, products.get(i - 1).text, products.get(i - 1).button, products.get(i).text, products.get(i).button);
            products.get(i - 1).coloumn = 0;
            products.get(i - 1).row = i;
            products.get(i).coloumn = 2;
            products.get(i).row = i;

            
            
        }
    }

    public ArrayList<Product> getSelectedProducts(){
        return selectedProducts;
    }

    public void setSelectedProducts(ArrayList<Product> products){
        this.selectedProducts = products;

    }


    public ProductPage() throws IOException{
        title.setText("Product Page");
        searchButton.setStyle("-fx-background-color: #9FE2BF ");
        grid.addRow(0, title, textField, searchButton);

        scrollPane.setVbarPolicy(ScrollBarPolicy.AS_NEEDED);
        scrollPane.setHbarPolicy(ScrollBarPolicy.AS_NEEDED);
        scrollPane.setContent(grid);

        searchButton.setOnAction(e -> {
            String text = textField.getText();
           
            for(Product product: products){
                products.remove(product);
                removeProduct(product);
            }

            WebScraper scraper = new WebScraper();

            try {
                scraper.scrape(text, products);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            System.out.println(products);
            addProductsAndButton();
            addProductsToScreen(products);
        }); 
        
    }
    


    
}
