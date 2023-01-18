package com.example;
import javafx.scene.layout.GridPane;
import java.util.ArrayList;
import com.example.Product;
import javafx.scene.text.Text;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;


public class ProductPage {
    public ArrayList<Product> products = new ArrayList<Product>();
    public ArrayList<Product> selectedProducts = new ArrayList<Product>();
    public GridPane grid = new GridPane();
    private TextField textField = new TextField();
    private Text title = new Text();
    private Button searchButton= new Button("search");
    public ScrollPane scrollPane = new ScrollPane();
    



    public ArrayList<Product> getProducts(){
        return products;
    }

    public void addProduct(Product product){
        products.add(product);

    }

    private void addProducts(){
        Product apple = new Product("bible then hang luigi", 2.00, 4.1, 0);
        Product legocity = new Product("Lego City", 59.99, 4.4, 5);
        addProduct(legocity);

        for(int i = 0; i < 25; i ++){
            Product banana = new Product("banana", i, 4.1, 0);
            addProduct(banana);
        }

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
    public void addProductsToScreen(ArrayList<Product> products){
        String string = "";
        int count = 1;
        for(int i = 0; i < products.size(); i++){
            

           
            grid.addRow(i, products.get(i).text, products.get(i).button, products.get(i + 1).text, products.get(i + 1).button);
            
            
            i++;
        }
    }
    public ProductPage(){
        title.setText("Product Page");
        searchButton.setStyle("-fx-background-color: #9FE2BF ");
        grid.addRow(0, title, textField, searchButton);

        scrollPane.setVbarPolicy(ScrollBarPolicy.AS_NEEDED);
        scrollPane.setHbarPolicy(ScrollBarPolicy.AS_NEEDED);
        scrollPane.setContent(grid);

        searchButton.setOnAction(e -> {
            String text = textField.getText();
            addProducts();
            addProductsToScreen(products);
        }); 
        
    }


    
}
