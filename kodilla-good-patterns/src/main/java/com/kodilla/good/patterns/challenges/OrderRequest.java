package com.kodilla.good.patterns.challenges;

public class OrderRequest {

    private Product orderProduct;
    private User seller;
    private User buyer;

    public OrderRequest(Product orderProduct, User seller, User buyer) {
        this.orderProduct = orderProduct;
        this.seller = seller;
        this.buyer = buyer;
    }

    public Product getOrderProduct() {
        return orderProduct;
    }

    public void setOrderProduct(Product orderProduct) {
        this.orderProduct = orderProduct;
    }

    public User getSeller() {
        return seller;
    }

    public void setSeller(User seller) {
        this.seller = seller;
    }

    public User getBuyer() {
        return buyer;
    }

    public void setBuyer(User buyer) {
        this.buyer = buyer;
    }
}





