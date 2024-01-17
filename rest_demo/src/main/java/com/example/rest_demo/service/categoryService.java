package com.example.rest_demo.service;


import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.rest_demo.model.Category;

import java.util.List;

@Service
@Primary
public interface categoryService {

    // add category
    Category addCategory(Category c);

    // delete category
    void deleteCategory(int id);

    // update category

    Category updateCategory(Category c);

    // get category by id

    Category getCategoryById(int id);

    // get all categories

    List<Category> getAllCategories();

}
