package com.example;

import java.io.IOException;  
import org.jsoup.Jsoup;  
import org.jsoup.nodes.Document; 
import org.jsoup.select.Elements;
import org.jsoup.nodes.Element;

import java.util.ArrayList;
import java.util.Scanner; 
import java.io.File;
import java.io.FileWriter;

public class WebScraper{
    public void scraper() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your product keyword: ");

        String keyword = scanner.nextLine();
        String userAgent = "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:53.0) Gecko/20100101 Firefox/53.0";
        //String url = "https://www.amazon.ca/s?k=" + keyword;
        String url = "https://www.javatpoint.com/jsoup-tutorial";

        Document document = Jsoup.connect(url).userAgent(userAgent).timeout(5000).get();  
    
        System.out.println(document.title());
    }
}