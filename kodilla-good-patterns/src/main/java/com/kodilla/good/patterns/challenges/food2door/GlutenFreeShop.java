package com.kodilla.good.patterns.challenges.food2door;

public class GlutenFreeShop implements FoodSupplier {
    @Override
    public boolean processOrder() {
        System.out.println("Processing order from GlutenFreeShop");
        return true;
    }
}
