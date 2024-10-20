package com.example.clothes_fashion_be.service;

import com.example.clothes_fashion_be.entitys.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> getAllCategory();

    Category getCategoryById(Long id);

    Category saveCategory(Category category);

    void deleteCategoryById(Long id);
}
