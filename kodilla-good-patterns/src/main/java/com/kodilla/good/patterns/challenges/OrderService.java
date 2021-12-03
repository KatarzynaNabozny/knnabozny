package com.kodilla.good.patterns.challenges;

public class OrderService {
    public boolean order(final Product product, final User buyer, final User seller) {
        System.out.println("Sold " + product.getNameOfProduct() + " " + "for: " + buyer.getName() + " " + buyer.getSurname() +
                " " + buyer.getMail() + "; " + "Sold from: " + seller.getName() + " " + seller.getSurname()
                + "  " + seller.getMail() + "; ");
        return true;
    }
}
