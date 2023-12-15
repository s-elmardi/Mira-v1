package com.sogeti.mirav1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class MiraV1Application {

	public static void main(String[] args) {
		SpringApplication.run(MiraV1Application.class, args);
	}

}
