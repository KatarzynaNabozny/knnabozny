package com.kodilla.good.patterns.challenges.food2door;

public class HealthyShop implements FoodSupplier {
    @Override
    public boolean processOrder() {
        System.out.println("Processing order from HealthyShop");
        return true;
    }
}
