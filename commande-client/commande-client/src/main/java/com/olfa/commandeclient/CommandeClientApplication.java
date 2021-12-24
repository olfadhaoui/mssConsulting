package com.olfa.commandeclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class CommandeClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(CommandeClientApplication.class, args);
	}

}
