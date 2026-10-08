package com.demo.Order.kafka;

import com.demo.Order.entity.OrderEntity;
import com.demo.Order.entity.OrderEvent;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class OrderKafkaProducer {

    private final KafkaTemplate<Integer, OrderEvent> kafkaTemplate;

    public OrderKafkaProducer(KafkaTemplate<Integer, OrderEvent> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void publishOrder(OrderEvent orderEvent) {

        kafkaTemplate.send(
                "orders",
                orderEvent.getOrderId(),
                orderEvent
        );
    }

    public void sendPayment(OrderEvent savedOrder) {

        kafkaTemplate.send(
                "payments",
                savedOrder.getOrderId(),
                savedOrder
        );
    }
}

