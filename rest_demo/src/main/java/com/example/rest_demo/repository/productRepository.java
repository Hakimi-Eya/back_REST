package com.example.rest_demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.rest_demo.model.product;

@Repository
public interface productRepository extends JpaRepository<product, Integer> {

   // product findByName(String name);

}
