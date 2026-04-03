package com.misis.archapp.user.controller;

import com.misis.archapp.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class UserRestApiController {

    private final UserService userService;

    @Autowired
    public UserRestApiController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/rabbit")
    public String testRabbit() {
        userService.testSendEvent();
        return "✅ Test event sent to RabbitMQ! Check notification-service logs.";
    }
}