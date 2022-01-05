package com.example.demo.service;

import com.example.demo.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ICategoryService {
    List<Category> findAll();
    Page<Category> findAll(Pageable pageable);
    void deleteById(Long id);
    Category save(Category category);
    Optional<Category> findById(Long id);
    boolean existsByNameCategory(String nameCategory);
}
