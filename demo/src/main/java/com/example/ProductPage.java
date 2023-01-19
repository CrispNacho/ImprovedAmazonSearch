package com.example;
import javafx.scene.layout.GridPane;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import com.example.Product;
import javafx.scene.text.Text;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.layout.VBox;
import javafx.scene.control.ComboBox;


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
    private TextField minPriceInput = new TextField("min price");
    private TextField maxPriceInput = new TextField("max price");
    private ComboBox dropdownFilter = new ComboBox();
    private Button applyFiltersButton = new Button("Apply");
   

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

        maxPriceInput.setMaxWidth(110);
        minPriceInput.setMaxWidth(110);
        dropdownFilter.getItems().add("Price");
        dropdownFilter.getItems().add("Rating");
        dropdownFilter.getItems().add("Discount");
    

        titleGrid.addRow(0, title, textField, searchButton);
        titleGrid.addRow(1, minPriceInput, maxPriceInput, dropdownFilter, applyFiltersButton);

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

        applyFiltersButton.setOnAction(e ->  {
            applyFilters();
            
        });
        
    }


    private Boolean isDouble(String text) {
        try {
            Double.parseDouble(text);
            return true;
        }
    catch (NumberFormatException er){
      return false;
    }
      }
    private void applyFilters(){
        grid.getChildren().clear();
        if(dropdownFilter.getValue() != null){
            String dropdownValue = dropdownFilter.getValue().toString();
            
            
            if(dropdownValue == "Price"){
                Collections.sort(products, new Comparator<Product>() {

                    @Override
                    public int compare(Product o1, Product o2) {
                        // TODO Auto-generated method stub
                        return Double.compare(o1.getCost(), o2.getCost());
                    }
                    
                });

            }
            
            else if(dropdownValue == "Rating"){
                System.out.println("sorting by rating");
                Collections.sort(products, new Comparator<Product>() {

                    @Override
                    public int compare(Product o1, Product o2) {
                        // TODO Auto-generated method stub
                        return Double.compare(o2.getRating(), o1.getRating());
                    }
                    
                });
                //addProductsToScreen(products);
                
            }
            else if (dropdownValue == "Discount"){
                Collections.sort(products, new Comparator<Product>() {

                    @Override
                    public int compare(Product o1, Product o2) {
                        // TODO Auto-generated method stub
                        return Double.compare(o2.getDiscount(), o1.getDiscount());
                    }
                    
                });
                //addProductsToScreen(products);
    

            }
        }
        String minstr = minPriceInput.getText().toLowerCase();
        String maxstr = maxPriceInput.getText().toLowerCase();
  
        if(isDouble(maxstr) && isDouble(minstr)){
        double minval = Double.parseDouble(minstr); 
        double maxval = Double.parseDouble(maxstr);
            if(maxval>minval){
                ArrayList<Product> priceRangedProducts = new ArrayList<Product>();
                for(int i = 0; i < products.size(); i++){
                    if(products.get(i).getCost() >= minval && products.get(i).getCost() <= maxval){
                        System.out.println(products.get(i).getCost());
                        priceRangedProducts.add(products.get(i));
                    }
                }
                System.out.println("sorting by price");
                System.out.println("max = " + maxval + " min = " +minval);
                addProductsToScreen(priceRangedProducts);
            }
            else{
                addProductsToScreen(products);
            }
        }
        else{
            addProductsToScreen(products);
        }

    }
    


    
}
