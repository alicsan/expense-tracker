package com.alicsan.expense_tracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alicsan.expense_tracker.model.Category;

public interface  CategoryRepository  extends JpaRepository<Category, Long>{
    boolean existsByNameIgnoreCase(String name);
}
