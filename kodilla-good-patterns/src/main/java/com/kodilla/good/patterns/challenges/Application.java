package com.kodilla.good.patterns.challenges;

public class Application {
    public static void main(String[] args) {
        User buyer = new User("John", "Wekl", "jowe@wp.pl");
        User seller = new User("Ignacy", "Skalski", "iks@wp.pl");
        Product orderProduct = new Product("Pantofle");
        OrderRequest orderRequest = new OrderRequest(orderProduct, seller, buyer);
        InformationService informationService = new MobilePhone();
        OrderService orderService = new OrderService();
        OrderRepository orderRepository = new Database();

        ProductOrderService productOrderService =
                new ProductOrderService(informationService, orderService, orderRepository);
        OrderDto orderDto = productOrderService.process(orderRequest);
        if (orderDto.isOrdered()) {
            System.out.println("Order is realised: " + orderDto.getOrderProduct().getNameOfProduct());
        }

    }
}

