package com.example.rest_demo.service;


import org.springframework.context.annotation.Primary;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.rest_demo.model.product;

import java.util.List;


@Service
@Primary
public interface productService {

    // add product

    product addProduct(product p);

    // delete product

    ResponseEntity<?> deleteProduct(int id);

    // update product

    product updateProduct(product p);

    // get product by id

    product getProductById(int id);

    // get all products

    List<product> getAllProducts();

}