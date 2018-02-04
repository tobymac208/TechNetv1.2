package com.groupproject.nik.Model;

public class Product {
    private String name;
    private int productNumber;
    private int count;

    public Product(String name, int partNumber, int count){
        this.name = name;
        this.productNumber = partNumber;
        this.count = count;
    }

    // name
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    // part number
    public int getProductNumber() {return productNumber;}
    public void setProductNumber(int productNumber) {this.productNumber = productNumber;}

    // count
    public int getCount() {return count;}
    public void setCount(int count) {this.count = count;}
}
