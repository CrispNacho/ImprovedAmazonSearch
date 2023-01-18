package com.example;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import java.util.ArrayList;
public class Product {
    public String name;
    private double cost;
    private double rating;
    private double discount;
    public Label text = new Label();
    public Label summaryText = new Label();
    public Button button = new Button("add");
    public Button delButton = new Button("del");
    public boolean displayedOnSummary = false;
    public int coloumn;
    public int row;

    public Product(String name, double cost, double rating, double discount) {
        this.name = name;
        this.cost = cost;
        this.rating = rating;
        this.discount = discount;
        this.text.setText(name + " " + cost + " " + rating + " " + discount);
        this.summaryText.setText(name + " " + cost + " " + rating + " " + discount);
    }

}
