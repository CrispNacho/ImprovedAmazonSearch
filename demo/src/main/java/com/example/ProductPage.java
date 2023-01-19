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
import javafx.scene.layout.VBox;


public class ProductPage {
    public ArrayList<Product> products = new ArrayList<Product>();
    private ArrayList<Product> selectedProducts = new ArrayList<Product>();
    private VBox vbox = new VBox();  
    public GridPane titleGrid = new GridPane();
    public GridPane grid = new GridPane();
    private TextField textField = new TextField();
    private Text title = new Text();
    private Button searchButton= new Button("search");
    public ScrollPane scrollPane = new ScrollPane();

    private void addProductButtons(){
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
    public void removeSelectedProduct(Product product){
        selectedProducts.remove(product);
    }



    private void addProductsToScreen(ArrayList<Product> products){
        for(int i = 1; i < products.size(); i+=2){
            
            grid.addRow(i, products.get(i - 1).text, products.get(i - 1).button, products.get(i).text, products.get(i).button);
     
            
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
        titleGrid.addRow(0, title, textField, searchButton);

        scrollPane.setVbarPolicy(ScrollBarPolicy.AS_NEEDED);
        scrollPane.setHbarPolicy(ScrollBarPolicy.AS_NEEDED);
        vbox.getChildren().addAll(titleGrid, grid);
        scrollPane.setContent(vbox);

        searchButton.setOnAction(e -> {
            String text = textField.getText();
            grid.getChildren().clear();
            products.clear();

            WebScraper scraper = new WebScraper();

            try {
                scraper.scrape(text, products);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            System.out.println(products);
            addProductButtons();
            addProductsToScreen(products);
        }); 
        
    }
    


    
}
