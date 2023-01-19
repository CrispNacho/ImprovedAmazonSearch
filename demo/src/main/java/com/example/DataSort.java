package com.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class DataSort {
    public void sortByPrice(ArrayList<Product> products) {
        Collections.sort(products, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                // TODO Auto-generated method stub
                return Double.compare(o1.getCost(), o2.getCost());
            }
        });
    }
    
    public void sortByRating(ArrayList<Product> products) {
        Collections.sort(products, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                // TODO Auto-generated method stub
                return Double.compare(o1.getRating(), o2.getRating());
            }
            
        });
    }

    public void sortByDiscount(ArrayList<Product> products) {
        Collections.sort(products, new Comparator<Product>() {

            @Override
            public int compare(Product o1, Product o2) {
                // TODO Auto-generated method stub
                return Double.compare(o1.getDiscount(), o2.getDiscount());
            }
        });
    }

    public ArrayList<Product> filterPrice(ArrayList<Product> products, double minval, double maxval) {
        ArrayList<Product> priceRangedProducts = new ArrayList<Product>();
        
        for(int i = 0; i < products.size(); i++){
            if(products.get(i).getCost() >= minval && products.get(i).getCost() <= maxval){
                priceRangedProducts.add(products.get(i));
            }
        }

        return priceRangedProducts;
    }
}
