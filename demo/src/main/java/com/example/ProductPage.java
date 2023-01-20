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
import javafx.scene.control.Label;


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
    private TextField minPriceInput = new TextField();
    private TextField maxPriceInput = new TextField();
    private Label maxPriceLabel = new Label();
    private Label minPriceLabel = new Label();
    private Label enterTextErrorLabel = new Label();
    private ComboBox dropdownFilter = new ComboBox();
    private Button applyFiltersButton = new Button("Apply");
    private CSV csv = new CSV();

    private void addProductButtons(){
        for(Product product: products){
            product.button.setOnAction(e -> {  
                //if the product is not already in the array then add it
            if(!selectedProducts.contains(product)){
                selectedProducts.add(product);
                csv.exportToCSV(selectedProducts);
            }   
            });
        } 
    }
    public void clearProductScreen(){
        grid.getChildren().clear();
        minPriceInput.setText(null);
        maxPriceInput.setText(null);
        dropdownFilter.valueProperty().set(null);
        textField.setText(null);

    }

    private void addProductsToScreen(ArrayList<Product> products){
        grid.getChildren().clear();
        int row = 0;
        for(int i =0; i < products.size(); i++){
            grid.addRow(row, products.get(i).text, products.get(i).button);
            products.get(i).coloumn = i % 2;
            products.get(i).row = row;
            if(i % 2 == 1){
                row+=1;
            }
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
        minPriceLabel.setText("Minimum Price");
        maxPriceLabel.setText("Maximum Price");

        maxPriceInput.setMaxWidth(110);
        minPriceInput.setMaxWidth(110);

        dropdownFilter.getItems().add("Price (Asc)");
        dropdownFilter.getItems().add("Rating (Asc)");
        dropdownFilter.getItems().add("Discount (Asc)");
        dropdownFilter.getItems().add("Price (Dsc)");
        dropdownFilter.getItems().add("Rating (Dsc)");
        dropdownFilter.getItems().add("Discount (Dsc)");

        titleGrid.addRow(0, title, textField, searchButton);
        titleGrid.addRow(1, minPriceLabel, maxPriceLabel);
        titleGrid.addRow(2, minPriceInput, maxPriceInput, dropdownFilter, applyFiltersButton);
        titleGrid.addRow(3, enterTextErrorLabel);

        scrollPane.setVbarPolicy(ScrollBarPolicy.AS_NEEDED);
        scrollPane.setHbarPolicy(ScrollBarPolicy.AS_NEEDED);
        vbox.getChildren().addAll(titleGrid, grid);
        scrollPane.setContent(vbox);

        searchButton.setOnAction(e -> {
            String text = textField.getText();
            grid.getChildren().clear();
            products.clear();
            text = text.replaceAll("[^a-zA-Z0-9\\s]", "");
            System.out.println(text);
            if(text == ""){
                enterTextErrorLabel.setText("Please enter something to search");
            } 
            else {
                enterTextErrorLabel.setText("");
            }

            WebScraper scraper = new WebScraper();

            try {
                scraper.scrape(text, products);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
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

        DataSort sorter = new DataSort();

        if(dropdownFilter.getValue() != null){
            String dropdownValue = dropdownFilter.getValue().toString();
            
            if(dropdownValue == "Price (Asc)"){
                sorter.sortByPrice(products);
            }
            else if(dropdownValue == "Rating (Asc)"){
                sorter.sortByRating(products);
            }
            else if (dropdownValue == "Discount (Asc)"){
                sorter.sortByDiscount(products);
            }
            else if(dropdownValue == "Price (Dsc)"){
                sorter.sortByPrice(products);
                Collections.reverse(products);
            }
            else if(dropdownValue == "Rating (Dsc)"){
                sorter.sortByRating(products);
                Collections.reverse(products);
            }
            else if (dropdownValue == "Discount (Dsc)"){
                sorter.sortByDiscount(products);
                Collections.reverse(products);
            }
        }
        String minstr = minPriceInput.getText().toLowerCase();
        String maxstr = maxPriceInput.getText().toLowerCase();
  
        if(isDouble(maxstr) && isDouble(minstr)){
        double minval = Double.parseDouble(minstr); 
        double maxval = Double.parseDouble(maxstr);
            if(maxval>minval){
                ArrayList<Product> priceRangedProducts = new ArrayList<Product>();
                priceRangedProducts = sorter.filterPrice(products, minval, maxval);
                
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
    
    public ArrayList<Product> updateSelectedArray() {
        return selectedProducts;
    }

    
}
