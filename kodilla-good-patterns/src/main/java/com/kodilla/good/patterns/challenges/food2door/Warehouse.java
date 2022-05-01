package com.kodilla.good.patterns.challenges.food2door;

public class Warehouse {
    private void fetchInfo() {
        System.out.println("Fetching information from supplier");
    }

    public boolean process(String foodSupplier) {
        fetchInfo();
        switch (foodSupplier) {
            case "ExtraFoodShop":
                return new ExtraFoodShop().processOrder();
            case "HealthyShop":
                return new HealthyShop().processOrder();
            case "GlutenFreeShop":
                return new GlutenFreeShop().processOrder();
            default:
                System.out.println("Processing order from " + foodSupplier + " is not yet implemented");
                return false;
        }
    }
}