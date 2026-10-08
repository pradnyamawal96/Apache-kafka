package com.demo.payments.service;

import com.demo.payments.entity.Payment;
import com.demo.payments.entity.PaymentEvent;
import com.demo.payments.kafka.PaymentKafkaProducer;
import com.demo.payments.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    @Autowired
    PaymentRepository paymentRepository;
    @Autowired
    PaymentKafkaProducer kafkaProducer;


    public void processPayment(
            Integer orderId,
            Double amount) {

        Payment payment = new Payment();

        payment.setOrderId(orderId);

        payment.setAmount(amount);

        payment.setStatus("SUCCESS");

        Payment saved = paymentRepository.save(payment);

        PaymentEvent event = new PaymentEvent(
                saved.getId(),
                saved.getOrderId(),
                saved.getAmount(),
                saved.getStatus()
        );

        kafkaProducer.send(event);
    }
}
