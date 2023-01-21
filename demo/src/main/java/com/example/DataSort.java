package com.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class DataSort {
    /**
     * Sorts the products by price in ascending order.
     * @param products the list of product objects.
     */
    public void sortByPrice(ArrayList<Product> products) {
        Collections.sort(products, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                // TODO Auto-generated method stub
                return Double.compare(o1.getCost(), o2.getCost());
            }
        });
    }
    
    /**
     * Sorts the products by rating in ascending order.
     * @param products the list of product objects.
     */
    public void sortByRating(ArrayList<Product> products) {
        Collections.sort(products, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                // TODO Auto-generated method stub
                return Double.compare(o1.getRating(), o2.getRating());
            }
            
        });
    }

    /**
     * Sorts the products by discount in ascending order.
     * @param products the list of product objects.
     */
    public void sortByDiscount(ArrayList<Product> products) {
        Collections.sort(products, new Comparator<Product>() {

            @Override
            public int compare(Product o1, Product o2) {
                // TODO Auto-generated method stub
                return Double.compare(o1.getDiscount(), o2.getDiscount());
            }
        });
    }

    /**
     * Filters an arraylist of product objects by its price. Returns an arraylist that contains
     * only the products that fits within the specified price range.
     * @param products the arraylist of product objects
     * @param minval the minimum price a product can have
     * @param maxval the maximum price a product can have
     * @return the arraylist of the product objects that fit within price range
     */
    public ArrayList<Product> filterPrice(ArrayList<Product> products, double minval, double maxval) {
        ArrayList<Product> priceRangedProducts = new ArrayList<Product>();
        
        for(int i = 0; i < products.size(); i++){
            if(products.get(i).getCost() >= minval && products.get(i).getCost() <= maxval){
                priceRangedProducts.add(products.get(i));
            }
        }

        return priceRangedProducts;
    }

    /**
     * Filters an arraylist of product objects by its price. Returns an arraylist that contains
     * only the products that cost more than the minimum specified value
     * @param products the arraylist of product objects
     * @param minval the minimum price a product can have
     * @return the arraylist of the product objects that has a price greater than the minimum value.
     */
    public ArrayList<Product> filterPrice(ArrayList<Product> products, double minval) {
        ArrayList<Product> priceRangedProducts = new ArrayList<Product>();
        
        for(int i = 0; i < products.size(); i++){
            if(products.get(i).getCost() >= minval){
                priceRangedProducts.add(products.get(i));
            }
        }

        return priceRangedProducts;
    }
}
