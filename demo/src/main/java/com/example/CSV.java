package com.example;

import java.io.FileWriter;  
import java.io.IOException; 
import java.io.File; 
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class CSV {
    private String fileName = "productData.csv";
    private String title = "Name,Price,Discount,Rating,Link";

    /**
     * Exports all products and their properties from an arraylist.
     * Data is imported into a CSV file with headings. 
     * @param productsList the arraylist with all the product objects to be exported
     */
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

            writer.write(title + "\n");

            for (Product product: productsList) {
                String text = product.name + "," + product.getCost() + "," + product.getDiscount() + "," + product.getRating() + "," + product.link + "\n";
                writer.write(text);
            }
            
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Reads the saved product CSV and import all the data into
     * product objects and saved into a list.
     * @param product the arraylist where the product should be imported into.
     */
    public void importFromCSV(ArrayList<Product> product) {
        BufferedReader br = null;
       	try{		
           	br = new BufferedReader(new FileReader(fileName));		

           	//One way of reading the file
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
    
    /**
     * Read and parse through a line of CSV and convert it into a product object.
     * Returns if the line is the heading.
     * @param line the string of the certain line of CSV you are reading
     * @param products the arraylist that will be populated with product objects.
     */
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
