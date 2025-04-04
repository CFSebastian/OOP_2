package main.java.lab5;

import java.util.ArrayList;

public class ArangeDataForProdunct {
    public static Product parseDataToProduct(String line) {
        double price = 0;
        String[] description = line.split(",");
        if (description.length > 3) {
            throw new InvalidProductDataFormat("Invalid product data format");
        }
        try {
            price = Double.parseDouble(description[2]);
        }catch (ArrayIndexOutOfBoundsException e) {
            throw new InvalidProductDataFormat("Invalid product data format for price");
        }

        if (price < 0) {
            throw new InvalidProductPrice("Invalid product price");
        }

        return new Product(description[0], description[1], price);
    }
}
