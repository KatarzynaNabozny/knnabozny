package com.kodilla.good.patterns.challenges.food2door;

public class ExtraFoodShop implements FoodSupplier {
    @Override
    public boolean processOrder() {
        System.out.println("Processing order from ExtraFoodShop");
        return true;
    }
}
