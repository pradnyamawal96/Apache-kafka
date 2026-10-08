package com.demo.Order.service;

import com.demo.Order.entity.OrderEntity;
import com.demo.Order.entity.OrderEvent;
import com.demo.Order.kafka.OrderKafkaProducer;
import com.demo.Order.repository.OrderRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderKafkaProducer producer;

    public OrderService(OrderRepository orderRepository,
                        OrderKafkaProducer producer) {
        this.orderRepository = orderRepository;
        this.producer = producer;
    }

    @Transactional
    public OrderEntity createOrder(OrderEntity order) {
        order.setStatus("CREATED");
        OrderEntity savedOrder = orderRepository.save(order);

        OrderEvent orderEvent = new OrderEvent(savedOrder.getOrderId(),
                savedOrder.getCustomerId(),
                savedOrder.getAmount(),
                savedOrder.getStatus());

        producer.publishOrder(orderEvent);

        return savedOrder;
    }
}

