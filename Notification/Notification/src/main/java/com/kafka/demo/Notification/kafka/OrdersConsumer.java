/*
package com.kafka.demo.Notification.kafka;

import com.kafka.demo.Notification.dao.Orders;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class OrdersConsumer {

    @KafkaListener( topics = "orders",
            groupId = "order-group")
    public void ordersConsumer(Orders order) {

        System.out.println("========== ORDER RECEIVED ==========");

        System.out.println("Order ID      : " + order.getOrderId());
        System.out.println("Order Name    : " + order.getOrderName());
        System.out.println("Address       : " + order.getAddress());
        System.out.println("Amount        : " + order.getAmount());

        System.out.println("====================================");
    }
}
*/
