package com.example;

import java.io.FileWriter;  
import java.io.IOException; 
import java.io.File; 
import java.io.IOException; 
import java.util.ArrayList;

public class CSV {
    private String fileName = "productData.txt";

    public void exportToCSV(ArrayList<Product> productsList) {
        try {
            File file = new File(fileName);
        if (file.createNewFile()) {
            System.out.println("File created: " + file.getName());
        }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            FileWriter writer = new FileWriter(fileName);
            writer.write("Name,Price,Discount,Rating,Link\n");

            for (Product product: productsList) {
                String text = product.name + "," + product.getCost() + "," + product.getDiscount() + "," + product.getRating() + "," + product.link + "\n";
                writer.write(text);
            }
            
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void importFromCSV() {

    }
}
