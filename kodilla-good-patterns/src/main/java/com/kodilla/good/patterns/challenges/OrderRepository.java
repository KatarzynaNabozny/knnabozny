package com.kodilla.good.patterns.challenges;

public interface OrderRepository {
    void createOrder(Product orderProduct, User seller, User buyer);
}
