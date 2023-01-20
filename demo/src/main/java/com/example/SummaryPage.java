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
import javafx.scene.Node;
import java.util.Collections;
import javafx.scene.control.TextField;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Button;

public class SummaryPage {
    public GridPane titleGrid = new GridPane();
    public GridPane grid = new GridPane();
    public VBox layout1 = new VBox(20);
    public ScrollPane scrollPane = new ScrollPane();
    private TextArea items = new TextArea();
    private CSV csv = new CSV();
    private ComboBox dropdownFilter = new ComboBox();
    private Button applyFiltersButton = new Button("Apply");
    private ArrayList<Product> products = new ArrayList<Product>();

    public SummaryPage(){
        Label title = new Label("Summary Dashboard");
        title.setStyle("-fx-font-size: 2em; ");
        scrollPane.setVbarPolicy(ScrollBarPolicy.AS_NEEDED);
        scrollPane.setHbarPolicy(ScrollBarPolicy.AS_NEEDED);
        titleGrid.addRow(0, title);
        titleGrid.addRow(1, dropdownFilter, applyFiltersButton);
        layout1.getChildren().addAll(titleGrid, grid);

        dropdownFilter.getItems().add("Price (Asc)");
        dropdownFilter.getItems().add("Rating (Asc)");
        dropdownFilter.getItems().add("Discount (Asc)");
        dropdownFilter.getItems().add("Price (Dsc)");
        dropdownFilter.getItems().add("Rating (Dsc)");
        dropdownFilter.getItems().add("Discount (Dsc)");

        dropdownFilter.getSelectionModel().selectFirst();

        scrollPane.setContent(layout1);   
        applyFiltersButton.setOnAction(e ->  {
            applyFilters(products);
        });
    }
    
    public void addProductsToScreen(ArrayList<Product> products){
        grid.getChildren().clear();
        int row = 0;
        for(int i =0; i < products.size(); i++){
            String productString = calculateComparisonToAverage(products, products.get(i)) + "% of average price!\n" + products.get(i).summaryText.getText();
            TextArea productText = new TextArea();
            productText.setPrefHeight(products.get(i).height);
            productText.setPrefWidth(products.get(i).width);
            productText.setEditable(false);
            productText.setWrapText(true);
            productText.setText(productString);
            grid.addRow(row, productText, products.get(i).delButton);
            products.get(i).summaryColoumn = i % 2;
            products.get(i).summaryRow = row;
            if(i % 2 == 1){
                row+=1;
            }
        }
    }
    public void addProductButtons(ArrayList<Product> products){
        for(Product product: products){
            product.delButton.setOnAction(e -> {  
                products.remove(product);
                addProductsToScreen(products);
                csv.exportToCSV(products);
            });
        } 

    }
    public void setProducts(ArrayList<Product> products){
        this.products = products;
    }

    private void applyFilters(ArrayList<Product> products){
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
        addProductsToScreen(products);
       

    }

    public double calculateComparisonToAverage(ArrayList<Product> productsList, Product product) {
        double total = 0;
        
        for (Product item: productsList) {
            total += item.getCost();
        }

        double average = total / productsList.size();

        System.out.println(average);

        double percent = product.getCost() / average * 100; 

        return Math.round(percent);
    }
}