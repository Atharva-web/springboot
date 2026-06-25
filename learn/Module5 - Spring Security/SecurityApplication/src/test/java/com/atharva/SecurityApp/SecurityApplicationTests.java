package com.atharva.SecurityApp;

import com.atharva.SecurityApp.entities.UserEntity;
import com.atharva.SecurityApp.services.JwtService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SecurityApplicationTests {

	@Autowired
	private JwtService jwtService;

	@Test
	void contextLoads() {

//		signup
		UserEntity userEntity = new UserEntity(5L, "atharva@gmail.com", "atharva123", "atharva");

		String jwt = jwtService.generateToken(userEntity);
		System.out.println(jwt);


		Long userId = jwtService.getUserIdFromJwt(jwt);
		System.out.println(userId);


	}

}
