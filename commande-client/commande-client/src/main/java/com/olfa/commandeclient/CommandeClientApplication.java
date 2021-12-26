package com.olfa.commandeclient;

import com.olfa.commandeclient.swagger.SwaggerConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Import;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableFeignClients
//@EnableSwagger2
//@Import(SwaggerConfiguration.class)
@SpringBootApplication

public class CommandeClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(CommandeClientApplication.class, args);
	}

}
