package com.restdemo.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.restdemo.demo.entities.Product;


@Component
public interface ProductRepository extends JpaRepository<Product, Long> {


}
