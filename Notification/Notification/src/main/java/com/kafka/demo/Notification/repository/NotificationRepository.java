package com.kafka.demo.Notification.repository;

import com.kafka.demo.Notification.entity.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationRepository
        extends JpaRepository<Notification, Integer> {
}
