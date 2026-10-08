package com.kafka.demo.Notification.service;

import com.kafka.demo.Notification.entity.Notification;
import com.kafka.demo.Notification.entity.NotificationEvent;
import com.kafka.demo.Notification.kafka.NotificationKafkaProducer;
import com.kafka.demo.Notification.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    @Autowired
    NotificationRepository notificationRepository;

    @Autowired
    NotificationKafkaProducer kafkaProducer;


    public void sendNotification(
            Integer orderId,
            Integer paymentId) {

        Notification notification =
                new Notification();

        notification.setOrderId(orderId);

        notification.setPaymentId(paymentId);

        notification.setMessage("Payment successful for order " + orderId);

        notification.setStatus("SENT");

        Notification saved =
                notificationRepository.save(notification);

        NotificationEvent event =
                new NotificationEvent(
                        saved.getOrderId(),
                        saved.getPaymentId(),
                        saved.getMessage(),
                        saved.getStatus()
                );

        kafkaProducer.send(event);
    }
}