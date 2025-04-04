package main.java.lab5;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Product products;
        //while != null
        File file = new File("C:\\Users\\sebas\\IdeaProjects\\OOP_2\\src\\main\\java\\lab5\\Test.txt");
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                products=ArangeDataForProdunct.parseDataToProduct(line);
                System.out.println(products.toString());
            }
        } catch (NullPointerException | InvalidProductPrice | InvalidProductDataFormat e) {
            System.err.println(e.getMessage());

        } catch (IOException e) {
            System.err.println(e.getMessage());

        } finally {
            System.out.println("Program terminated.");
        }

    }
}
