package com.groupproject.nik.Model;

public class Product {
    private String name;
    private int productNumber;
    private int count;
    private double price;

    public Product(String name, int partNumber, int count, double price){
        this.name = name;
        this.productNumber = partNumber;
        this.count = count;
        this.price = price;
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

    // price
    public double getPrice() {return price;}
    public void setPrice(double price) {this.price = price;}
}
