package com.restdemo.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.restdemo.demo.dao.ProductRepository;
import com.restdemo.demo.services.ProductService;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner initializeDatabase(ProductService productService) {
		return args -> productService.initializeDatabase();

	}

}
