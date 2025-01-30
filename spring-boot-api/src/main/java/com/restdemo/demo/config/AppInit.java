package com.restdemo.demo.config;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.restdemo.demo.dao.ProductRepository;
import com.restdemo.demo.entities.Product;


@Component
public class AppInit implements CommandLineRunner {


    private final ProductRepository productRepository;

    public AppInit(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }   

    @Override
    public void run(String... args) throws Exception {
        // initializeDatabase();
        System.out.println("Hello World from CmdLineRunner");
    }
    
    public void initializeDatabase()  {
        System.out.println("Hello World");


        if(productRepository.count() == 0){
            productRepository.saveAll(
                List.of(
                    new Product("Product 1", new BigDecimal("100")),
                    new Product("Product 2", new BigDecimal("200")),
                    new Product("Product 3", new BigDecimal("300")),
                    new Product("Product 4", new BigDecimal("400")),
                    new Product("Product 5", new BigDecimal("500"))
                )
            ).forEach(System.out::println);
        }

    }
}
