package com.demo.payments.kafka;

import com.demo.payments.dao.Orders;
import com.demo.payments.service.PaymentService;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class OrderKafkaConsumer {
    @Autowired
    PaymentService paymentService;

    @KafkaListener(
            topics = "orders",
            groupId = "payment-service",
            concurrency = "3"
    )
    public void consume(ConsumerRecord<Integer, Orders> record) {

        System.out.println("======================================");

        System.out.println("PAYMENT SERVICE");

        System.out.println("Consumer Thread : " + Thread.currentThread().getName());

        System.out.println("Partition       : " + record.partition());
        System.out.println("Offset          : " + record.offset());

        System.out.println("Order ID        : " + record.value().getOrderId());

        System.out.println("======================================");

        Orders event = record.value();
        System.out.println("===========Payment Service - Order event================");
        System.out.println("OrderId : "+ event.getOrderId());
        System.out.println("Amount : "+ event.getAmount());
        System.out.println("Status : "+ event.getStatus());
        System.out.println("======================================");

        paymentService.processPayment(
                event.getOrderId(),
                event.getAmount()
        );
    }

}
