package com.groupproject.nik.Model;

import java.util.ArrayList;

public class ProductsList {
    ArrayList<Product> productsList;

    // No-args constructor
    public ProductsList(){
        productsList = new ArrayList<>();
    }

    // getter
    public ArrayList<Product> getProductsList() {return productsList;}

    /** Adds a new Product to the list */
    public void addPart(String name, int productNumber, int count){
        if(productsList.isEmpty() || findByNumber(productNumber) == null ){ // no object found with same id, or the list is empty
            productsList.add(new Product(name, productNumber, count)); // add a new product
        }
    }

    private Product findByNumber(int productNumber){
        if(productsList.isEmpty())
            return null; // nothing in list
        for(Product product : productsList){
            if(product.getProductNumber() == productNumber)
                return product;
        }
        return null; // no objects found with the same number
    }
}
