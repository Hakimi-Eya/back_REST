package com.example.rest_demo.controller;



import com.example.rest_demo.model.product;
import com.example.rest_demo.service.productService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.List;
@EnableWebMvc
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class productController {

    private final productService productService;



    public productController( productService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public List<product> getProducts(){
        return productService.getAllProducts();
    }

    @PostMapping("/addProduct")
    public @ResponseBody product addProduct( @RequestBody  product p){

        System.out.println(p);


        return productService.addProduct(p);
    }

    @DeleteMapping("/product/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable int id){
       return  productService.deleteProduct(id);
    }

    @PatchMapping("/updateProduct")
    public @ResponseBody product updateProduct(@RequestBody product p){
        return productService.updateProduct(p);
    }

    @GetMapping("/product/{id}")

    public product getProductById(@PathVariable int id){
        return productService.getProductById(id);
    }

}
