package com.olfa.msproduit;

import com.olfa.msproduit.swagger.SwaggerConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Import;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableFeignClients
//@EnableSwagger2
//@Import(SwaggerConfiguration.class)
public class MsProduitApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsProduitApplication.class, args);
	}

}
