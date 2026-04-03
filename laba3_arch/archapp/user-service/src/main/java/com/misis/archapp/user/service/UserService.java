package com.misis.archapp.user.service;

import com.misis.archapp.contract.dto.UserCreatedEvent;
import com.misis.archapp.user.service.publisher.UserEventPublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {

    private final UserEventPublisher userEventPublisher;

    @Autowired
    public UserService(UserEventPublisher userEventPublisher) {
        this.userEventPublisher = userEventPublisher;
    }

    // Тестовый метод для отправки события в RabbitMQ
    public void testSendEvent() {
        UserCreatedEvent event = new UserCreatedEvent(
            UUID.randomUUID(), 
            "test@example.com", 
            "Test User"
        );
        userEventPublisher.publishUserEvent(event);
        System.out.println("✅ Test event sent to RabbitMQ!");
    }
}