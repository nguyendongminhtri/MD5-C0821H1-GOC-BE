package com.example.demo.service.impl;

import com.example.demo.model.Category;
import com.example.demo.model.User;
import com.example.demo.repository.ICategoryRepository;
import com.example.demo.security.userprincal.UserDetailServices;
import com.example.demo.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements ICategoryService {
    @Autowired
    UserDetailServices userDetailServices;
    @Autowired
    ICategoryRepository categoryRepository;
    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Page<Category> findAll(Pageable pageable) {
        return categoryRepository.findAll(pageable);
    }

    @Override
    public void deleteById(Long id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public Category save(Category category) {
        User user = userDetailServices.getCurrentUser();
        category.setUser(user);
        return categoryRepository.save(category);
    }

    @Override
    public Optional<Category> findById(Long id) {
        return categoryRepository.findById(id);
    }

    @Override
    public boolean existsByNameCategory(String nameCategory) {
        return categoryRepository.existsByNameCategory(nameCategory);
    }
}
