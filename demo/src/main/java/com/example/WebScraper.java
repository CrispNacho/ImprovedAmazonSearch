package com.example;

import java.io.IOException;  
import org.jsoup.Jsoup;  
import org.jsoup.nodes.Document; 
import org.jsoup.select.Elements;
import org.jsoup.nodes.Element;

import java.util.ArrayList;
import java.lang.Math;

public class WebScraper{
    private String query = "#search > div.s-desktop-width-max.s-desktop-content.s-wide-grid-style-t1.s-opposite-dir.s-wide-grid-style.sg-row > div.sg-col-20-of-24.s-matching-dir.sg-col-16-of-20.sg-col.sg-col-8-of-12.sg-col-12-of-16 > div > span.rush-component.s-latency-cf-section > div.s-main-slot.s-result-list.s-search-results.sg-row";
    private String productQuery = "div > div > div > div > div.a-section.a-spacing-small.puis-padding-left-small.puis-padding-right-small > ";
    private String nameQuery = "div.a-section.a-spacing-none.a-spacing-top-small.s-title-instructions-style > h2";
    private String ratingQuery = "div:nth-child(2) > div.a-row.a-size-small > span:nth-child(1)";
    private String priceQuery = "div.a-section.a-spacing-none.a-spacing-top-small.s-price-instructions-style > div.a-row.a-size-base.a-color-base > a > span:nth-child(1) > span.a-offscreen";
    private String discountQuery = "div.a-section.a-spacing-none.a-spacing-top-small.s-price-instructions-style > div > a > span.a-price.a-text-price > span.a-offscreen";
    private String linkQuery = "div > div > div > div > div.s-product-image-container.aok-relative.s-image-overlay-grey.s-text-center.s-padding-left-small.s-padding-right-small.puis-spacing-small.s-height-equalized > span > a";

    /**
     * Scrapes a specified Amazon page based on a keyword and fills a list with all the products
     * on the amazon page with their properties
     * @param keyword the keyword used to search products in Amazon.
     * @param productList the list that is to be filled with all product objects.
     * @throws IOException
     */
    public void scrapeAmazon(String keyword, ArrayList<Product> productList) throws IOException {
        String userAgent = "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:53.0) Gecko/20100101 Firefox/53.0";
        String url = "https://www.amazon.ca/s?k=" + keyword;

        Document document = Jsoup.connect(url).userAgent(userAgent).timeout(5000).get();    
        
        // Select the body of the amazon page containing all the products.
        Elements body = document.select(query);

        // Get the body element
        for (Element sections: body) {
            // Loop through all the products (children) of the body element
            for (Element product : sections.children()) {
                String name = "";
                String link = "";
                double discount = 0;
                double price = 0;
                double rating = 0;

                // Find the name of the product
                for (Element el: product.select(productQuery + nameQuery)) {
                  name = el.text().replace(",", ".");
                }
                // Find the rating of the product
                for (Element el: product.select(productQuery + ratingQuery)) {
                  rating = Double.parseDouble(el.text().substring(0, 3));
                }
                // Find the price of the product
                for (Element el: product.select(productQuery + priceQuery)) {
                  price = Double.parseDouble(el.text().substring(1).replaceAll(",",""));
                }
                // Find and calculate the discount percentage of a product
                for (Element el: product.select(productQuery + discountQuery)) {
                  double originalPrice = Double.parseDouble(el.text().substring(1).replaceAll(",",""));
                  discount = (originalPrice - price) / originalPrice * 100;
                  discount = Math.round(discount);
                }

                // Find the redirect link of the product
                for (Element el: product.select(linkQuery)) {
                  link = el.attr("href");
                }

                // Create a new product entry and input in arraylist if it isn't an empty element
                Product productEntry = new Product(name, price, rating, discount, link);
                if (price != 0) {
                    productList.add(productEntry);
                }
            }
        }
    }
/*
                                ___
      _                     ,,  // \\
   __/.)  (WOW)    (WOW)   (_,\/ \_/ \
_/___\/                      \ \_/_\_/>
  U U                        /_/  /_/
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
*/
}