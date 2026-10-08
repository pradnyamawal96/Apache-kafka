package com.demo.payments.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentEvent {
    private Integer paymentId;

    private Integer orderId;

    private Double amount;

    private String status;
}
