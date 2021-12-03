package com.kodilla.good.patterns.challenges;

public class ProductOrderService {

    private InformationService informationService;
    private OrderService orderService;
    private OrderRepository orderRepository;

    public ProductOrderService(final InformationService informationService,
                               final OrderService orderService,
                               final OrderRepository orderRepository) {
        this.informationService = informationService;
        this.orderService = orderService;
        this.orderRepository = orderRepository;
    }

    public OrderDto process(final OrderRequest orderRequest) {
        boolean isOrdered = orderService.order(orderRequest.getOrderProduct(), orderRequest.getBuyer(),
                orderRequest.getSeller());
        if (isOrdered) {
            informationService.inform(orderRequest.getOrderProduct(), orderRequest.getBuyer());
            orderRepository.createOrder(orderRequest.getOrderProduct(), orderRequest.getSeller(),
                    orderRequest.getBuyer());
            return new OrderDto(orderRequest.getBuyer(),
                    orderRequest.getSeller(), orderRequest.getOrderProduct(), true);
        } else {
            return new OrderDto(orderRequest.getBuyer(),
                    orderRequest.getSeller(), orderRequest.getOrderProduct(), false);
        }
    }
}


