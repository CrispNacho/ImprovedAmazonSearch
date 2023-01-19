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


public class SummaryPage {
    public GridPane titleGrid = new GridPane();
    public GridPane grid = new GridPane();
    public VBox layout1 = new VBox(20);
    public ScrollPane scrollPane = new ScrollPane();
    private TextArea items = new TextArea();

    public SummaryPage(){
        Label title = new Label("Summary Dashboard");
        title.setStyle("-fx-font-size: 2em; ");
        scrollPane.setVbarPolicy(ScrollBarPolicy.AS_NEEDED);
        scrollPane.setHbarPolicy(ScrollBarPolicy.AS_NEEDED);
        titleGrid.addRow(0, title);
        layout1.getChildren().addAll(titleGrid, grid);

        scrollPane.setContent(layout1);

        
        

    }
    


    public void addProductsToScreen(ArrayList<Product> products){
        grid.getChildren().clear();
        int row = 0;
        for(int i =0; i < products.size(); i++){
            grid.addRow(row, products.get(i).summaryText, products.get(i).delButton);
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
            });
        } 

    }





    private int getRowCount(GridPane pane) {
        int numRows = pane.getRowConstraints().size();
        for (int i = 0; i < pane.getChildren().size(); i++) {
            Node child = pane.getChildren().get(i);
            if (child.isManaged()) {
                Integer rowIndex = GridPane.getRowIndex(child);
                if(rowIndex != null){
                    numRows = Math.max(numRows,rowIndex+1);
                }
            }
        }
        return numRows;
    }
    
    
    //add method which sets the delete button on action event




    
}