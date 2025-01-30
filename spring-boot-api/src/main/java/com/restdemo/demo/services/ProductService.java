package com.restdemo.demo.services;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.restdemo.demo.dao.ProductRepository;
import com.restdemo.demo.entities.Product;

import jakarta.transaction.Transactional;

// 3 layer architecture
// - Presentation Layer - (controllers and views)
// - Service layer (business logic and transaction boundaries)
// - Data Access and Persistence Layer  (data access objects and repositories)

@Service
@Transactional
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;

    }

    public void initializeDatabase() {
        if (productRepository.count() == 0) {
            productRepository.saveAll(
                    List.of(
                            new Product("Product 1", new BigDecimal("100")),
                            new Product("Product 2", new BigDecimal("200")),
                            new Product("Product 3", new BigDecimal("300")),
                            new Product("Product 4", new BigDecimal("400")),
                            new Product("Product 5", new BigDecimal("500"))))
                    .forEach(System.out::println);
        }
    }

    public List<Product> findAllProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> findProductById(Long id) {
        return productRepository.findById(id);
    }

    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    

    public void deleteProductById(Long id) {
        productRepository.deleteById(id);
    }


}
