package com.example;

import java.io.FileWriter;  
import java.io.IOException; 
import java.io.File; 
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class CSV {
    private String fileName = "productData.txt";
    private String title = "Name,Price,Discount,Rating,Link\n";

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

            for (Product product: productsList) {
                String text = product.name + "," + product.getCost() + "," + product.getDiscount() + "," + product.getRating() + "," + product.link + "\n";
                writer.write(text);
            }
            
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void importFromCSV(ArrayList<Product> product) {
        BufferedReader br = null;
       	try{		
           	br = new BufferedReader(new FileReader(fileName));		

           	//One way of reading the file
			System.out.println("Reading the file using readLine() method:");
			String contentLine = br.readLine();
			while (contentLine != null) {
                parseLine(contentLine, product);
				contentLine = br.readLine();
			}			
       	} 
		catch (IOException e){
	   		e.printStackTrace();
       	} 
       	finally{
	   		try {
	      		if (br != null){
					br.close();
				}
	   		} 
	   		catch (IOException e) {
				System.out.println("Error in closing the BufferedReader");
	   		}
		}
  	}
    
    public void parseLine(String line, ArrayList<Product> products) {
        if (line.equals(title)) {
            return;
        }
        String[] contentLine = line.split(",");
        String name = contentLine[0];
        double price = Double.parseDouble(contentLine[1]);
        double discount = Double.parseDouble(contentLine[2]);
        double rating = Double.parseDouble(contentLine[3]);
        String link = contentLine[4];

        Product product = new Product(name, price, rating, discount, link);

        for (Product item: products) {
            if (item.name.equals(product.name) && item.getCost() == product.getCost()) {
                return;
            }
        }
        products.add(product);
    }
}
