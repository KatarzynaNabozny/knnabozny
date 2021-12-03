package com.kodilla.good.patterns.challenges;

public class Database implements OrderRepository {
    @Override
    public void createOrder(Product orderProduct, User seller, User buyer) {
        System.out.println("Order is saved into database: " + orderProduct.getNameOfProduct());
    }
}
