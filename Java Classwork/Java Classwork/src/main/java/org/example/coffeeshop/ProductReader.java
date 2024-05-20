package org.example.coffeeshop;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class ProductReader {

    public List<Product> readProducts() {
        List<Product> products = new ArrayList<>();

        try {
            File file = new File("products.csv");
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String header = bufferReader.readLine();
            String product = bufferReader.readLine();

            System.out.println(header);
            System.out.println(product);

        } catch ( Exception e ) {
            e.printStackTrace();
        }
        return products;

    }

    private Product parseProduct(String line) {
        // 0            ,1   ,2, 3
        // chai latte, 2.99, 10, true
        Product result = new Product();


        String[] column = line.split(regex: ",");
        result.setName(column[0]);
        result.setPrice(Double.parseDouble(column[1]));
        Object setQuantityAvailable = result.setQuantityAvailable1;

    }
    public static void main(String[] args) {
        ProductReader pr = new ProductReader();
        pr.readProducts();
    }

}

