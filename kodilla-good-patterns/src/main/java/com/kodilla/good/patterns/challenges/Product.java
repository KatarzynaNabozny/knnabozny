package com.kodilla.good.patterns.challenges;

public class Product {
    private String nameOfProduct;

    public Product(String nameOfProduct) {
        this.nameOfProduct = nameOfProduct;
    }

    public String getNameOfProduct() {
        return nameOfProduct;
    }

    public void setNameOfProduct(String name) {
        this.nameOfProduct = name;
    }
}
