package com.kafka.demo.Notification.kafka;

import com.kafka.demo.Notification.dao.PaymentEvent;
import com.kafka.demo.Notification.service.NotificationService;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class PaymentKafkaConsumer {

    @Autowired
    NotificationService notificationService;

      @KafkaListener(
            topics = "payments",
            groupId = "notification-service",
            concurrency = "3"
    )
    public void consume(
            ConsumerRecord<Integer, PaymentEvent> record) {

        System.out.println ("======================================");

        System.out.println("NOTIFICATION SERVICE");

        System.out.println("Consumer Thread : " + Thread.currentThread().getName());

        System.out.println("Partition       : " + record.partition());

        System.out.println("Offset          : " + record.offset());

        System.out.println("Order ID        : " + record.value().getOrderId());

        System.out.println("======================================");

        PaymentEvent event = record.value();
          System.out.println("===========Notification Service - Payment event================");
          System.out.println("OrderId : "+ event.getOrderId());
          System.out.println("Payment Id : "+ event.getPaymentId());
          System.out.println("Amount : "+ event.getAmount());
          System.out.println("Status : "+ event.getStatus());


          notificationService.sendNotification(
                event.getOrderId(),
                event.getPaymentId()
        );
    }
}