package com.misis.archapp.notification.listener;

import com.misis.archapp.contract.dto.UserCreatedEvent;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class EventConsumerListener {

    @RabbitListener(queues = "user.events")
    public void handleUserEvent(UserCreatedEvent event) {
        System.out.println(" Получено событие из RabbitMQ: " + event);
        System.out.println(" Notification: user created " + event.email());
        System.out.println(" User name: " + event.name());
        System.out.println(" User ID: " + event.userId());
    }
}