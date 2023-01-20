package com.example;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import java.util.ArrayList;
public class Product {
    public String name;
    private double cost;
    private double rating;
    private double discount;
    public int width = 250;
    public int height = 100;

    public String link;
    public TextArea text = new TextArea();
    public TextArea summaryText = new TextArea();
    public Button button = new Button("add");
    public Button delButton = new Button("del");
    public boolean displayedOnSummary = false;
    public int coloumn;
    public int row;
    public int summaryColoumn;
    public int summaryRow;

    public Product(String name, double cost, double rating, double discount, String link) {
        this.name = name;
        this.cost = cost;
        this.rating = rating;
        this.link = link;
        this.discount = discount;
        this.text.setPrefHeight(height);
        this.text.setPrefWidth(width);
        this.text.setEditable(false);
        this.text.setText(name + "\n$" + cost + " | " + rating + " out of 5.0 stars | " + discount + "% off");
        this.text.setWrapText(true);
        this.summaryText.setPrefHeight(height);
        this.summaryText.setPrefWidth(width);
        this.summaryText.setEditable(false);
        this.summaryText.setText("$" + cost + " | " + rating + " out of 5.0 stars | " + discount + "% off\n" + name + "\nlink: " + getLink());
        this.summaryText.setWrapText(true);
    }
    public double getDiscount(){
        return this.discount;
    }
    public double getRating(){
        return this.rating;
    }
    public double getCost(){
        return this.cost;
    }
    public String getLink() {
        return "www.amazon.ca" + this.link;
    }
}
