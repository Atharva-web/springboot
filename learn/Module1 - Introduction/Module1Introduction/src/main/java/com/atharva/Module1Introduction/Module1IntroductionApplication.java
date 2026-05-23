package com.atharva.Module1Introduction;

import com.atharva.Module1Introduction.impl.EmailNotificationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class Module1IntroductionApplication implements CommandLineRunner {

//	final private NotificationService notificationService;

	@Autowired
	final private Map<String, NotificationService> notificationServices = new HashMap<>();

//	public Module1IntroductionApplication(NotificationService notificationService) {
//		this.notificationService = notificationService;
//	}

	public static void main(String[] args) {
		SpringApplication.run(Module1IntroductionApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		for(var notificationService : notificationServices.entrySet()) {
			System.out.println(notificationService.getKey());
			notificationService.getValue().send("message");
		}
	}
}
