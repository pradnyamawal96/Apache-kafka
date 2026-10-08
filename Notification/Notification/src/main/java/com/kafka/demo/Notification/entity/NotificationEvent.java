package com.kafka.demo.Notification.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NotificationEvent {
    private Integer orderId;

    private Integer paymentId;

    private String message;

    private String status;
}
