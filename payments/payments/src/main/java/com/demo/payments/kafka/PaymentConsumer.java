/*
package com.demo.payments.kafka;

import com.demo.payments.dao.Orders;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class PaymentConsumer {

    @KafkaListener(topics = "payments", groupId = "payment-group")
    public void consumePayment(Orders orders){
        System.out.println("===============================");
        System.out.println("OrderId :  "+ orders.getOrderId());
        System.out.println("Amount  :  "+orders.getAmount());
        System.out.println("Status  :  "+"Success");
        System.out.println("===============================");
    }
}
*/
