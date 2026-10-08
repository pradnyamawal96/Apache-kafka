package com.kafka.demo.Notification.dao;

import lombok.Data;

@Data
public class Orders {
    private Integer orderId;
    private String orderName;
    private String address;
    private double amount;
}
