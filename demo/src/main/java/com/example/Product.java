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
    public Button button = new Button("add");

    public Product(String name, double cost, double rating, double discount) {
        this.name = name;
        this.cost = cost;
        this.rating = rating;
        this.discount = discount;
        this.text.setText(name + " " + cost + " " + rating + " " + discount);
    }
}
