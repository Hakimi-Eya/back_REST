package com.example.rest_demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.rest_demo.model.Category;


@Repository
public interface categoryRepository extends JpaRepository<Category,Integer> {
}
