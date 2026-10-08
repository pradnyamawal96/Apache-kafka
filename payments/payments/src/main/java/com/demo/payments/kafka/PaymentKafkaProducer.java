package com.demo.payments.kafka;

import com.demo.payments.entity.PaymentEvent;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class PaymentKafkaProducer {
    private final KafkaTemplate<Integer, PaymentEvent> kafkaTemplate;

    public PaymentKafkaProducer(
            KafkaTemplate<Integer, PaymentEvent> kafkaTemplate) {

        this.kafkaTemplate = kafkaTemplate;
    }

    public void send(PaymentEvent event) {

        kafkaTemplate.send(
                "payments",
                event.getOrderId(),
                event
        );
    }

}
