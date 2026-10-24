package com.alicsan.expense_tracker.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.alicsan.expense_tracker.model.Category;
import com.alicsan.expense_tracker.repository.CategoryRepository;


@Service 
public class CategoryService {
    
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getAllCategories(){
        return categoryRepository.findAll();
    }

    public Category createCategory(Category new_category){
        if (new_category.getName() == null || new_category.getName().isBlank()){
            throw new IllegalArgumentException("Category cannot be empty.");
        }
        String name = new_category.getName().trim();

        if (categoryRepository.existsByNameIgnoreCase(name)){
            throw new IllegalArgumentException("A Category with this name has already been registered.");
        }
        new_category.setName(name);
        return categoryRepository.save(new_category);
    }
    
}
