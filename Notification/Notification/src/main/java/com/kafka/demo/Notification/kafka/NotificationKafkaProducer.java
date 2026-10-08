package com.kafka.demo.Notification.kafka;

import com.kafka.demo.Notification.entity.NotificationEvent;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class NotificationKafkaProducer {

    private final KafkaTemplate<Integer, NotificationEvent>
            kafkaTemplate;

    public NotificationKafkaProducer(
            KafkaTemplate<Integer, NotificationEvent> kafkaTemplate) {

        this.kafkaTemplate = kafkaTemplate;
    }

    public void send(NotificationEvent event) {

        kafkaTemplate.send(
                "notifications",
                event.getOrderId(),
                event
        );
    }
}