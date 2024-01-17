package com.example.rest_demo.service.ImplementedService;

import com.example.rest_demo.model.Category;
import com.example.rest_demo.model.product;
import com.example.rest_demo.repository.categoryRepository;
import com.example.rest_demo.repository.productRepository;
import com.example.rest_demo.service.productService;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

@Service
public class productServiceImp implements productService {

    private final productRepository productRepo;
    private final categoryRepository categoryRepo;
    private final EntityManager entityManager;


    public productServiceImp(productRepository product, categoryRepository categoryRepo, EntityManager entityManager) {
        this.productRepo = product;
        this.categoryRepo = categoryRepo;
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public product addProduct(product p) {
        // Fetch the Category object
        Category category = categoryRepo.findById(p.getCategorie().getId_categorie())
                .orElseThrow(() -> new NoSuchElementException("Category not found"));

        // Merge the Category to make it managed
        category = entityManager.merge(category);

        // Set the managed Category object to the Product
        p.setCategorie(category);
        return productRepo.save(p);
    }

    @Override
    public ResponseEntity<?> deleteProduct(int id){
        productRepo.deleteById(id);
        Map<String, String> response = new HashMap<>();
        response.put("message", "Product " + id + "removed successfully ");
        System.out.println("Product " +response + "removed successfully  ");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public product updateProduct (product p){
        return productRepo.save(p);
    }

    @Override
    public product getProductById(int id){

        return productRepo.findById(id).orElse(null);
    }

    @Override
    public List<product> getAllProducts(){
        return productRepo.findAll();
    }

}
