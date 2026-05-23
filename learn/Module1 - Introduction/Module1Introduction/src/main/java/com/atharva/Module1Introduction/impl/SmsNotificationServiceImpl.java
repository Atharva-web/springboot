package com.atharva.Module1Introduction.impl;

import com.atharva.Module1Introduction.NotificationService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class SmsNotificationServiceImpl implements NotificationService {
    @Override
    public void send(String message) {
        System.out.println("Sending " + message + " via sms");
    }
}
