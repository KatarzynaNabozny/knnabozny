package com.kodilla.good.patterns.challenges;

public class OrderDto {
    private User buyer;
    private User seller;
    private boolean isOrdered;
    private Product orderProduct;

    public OrderDto(final User buyer, final User seller, final Product orderProduct, boolean isOrder) {
        this.buyer = buyer;
        this.seller = seller;
        this.orderProduct = orderProduct;
        this.isOrdered = isOrder;
    }

    public boolean isOrdered() {
        return isOrdered;
    }

    public User getBuyer() {
        return buyer;
    }

    public User getSeller() {
        return seller;
    }

    public Product getOrderProduct() {
        return orderProduct;
    }

}

