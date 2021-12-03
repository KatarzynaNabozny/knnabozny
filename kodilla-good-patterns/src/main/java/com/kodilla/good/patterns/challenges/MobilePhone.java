package com.kodilla.good.patterns.challenges;

public class MobilePhone implements InformationService {
    @Override
    public void inform(Product orderProduct, User buyer) {

        System.out.println("Send a message to: " + buyer.getName() + ". " + "You bought: " + orderProduct.getNameOfProduct());
    }
}
