package com.demo.Order.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderEvent {
    private Integer orderId;

    private String customerId;

    private Double amount;

    private String status;
}
