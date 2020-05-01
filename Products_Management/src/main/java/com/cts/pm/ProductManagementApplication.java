package com.cts.pm;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
public class ProductManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductManagementApplication.class, args);
	}
	@Bean
	Docket configureSwagger() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.paths(PathSelectors.ant("/product/**"))
				.build()
				
				.apiInfo(new ApiInfo("product API Documentation",
						"A Sample API for produucts",
						"1.0.0",
						"Shopping is Fun",
						new Contact("Bala", "www.balacorporation.com", "baladurga@gmail.com"), 
						"Standard API License",
						"www.bala.com",
						Collections.emptyList()));
				
				
	}
}