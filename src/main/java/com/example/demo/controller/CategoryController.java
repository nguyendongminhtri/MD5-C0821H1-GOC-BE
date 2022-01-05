package com.example.demo.controller;

import com.example.demo.dto.response.ResponMessage;
import com.example.demo.model.Category;
import com.example.demo.model.User;
import com.example.demo.security.userprincal.UserDetailServices;
import com.example.demo.service.impl.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RequestMapping("category")
@RestController
public class CategoryController {
    @Autowired
    CategoryServiceImpl categoryService;
    @Autowired
    UserDetailServices userDetailServices;
    @PostMapping
    public ResponseEntity<?> createCategory(@RequestBody Category category){
        User user = userDetailServices.getCurrentUser();
        if(user.getUsername().equals("Anonymous")){
            return new ResponseEntity<>(new ResponMessage("Please login!"), HttpStatus.OK);
        }
        if(categoryService.existsByNameCategory(category.getNameCategory())){
            return new ResponseEntity<>(new ResponMessage("no_name_category"), HttpStatus.OK);
        }
        if(category.getAvatarCategory()==null){
            return new ResponseEntity<>(new ResponMessage("no_avatar_category"), HttpStatus.OK);
        }
        categoryService.save(category);
        return new ResponseEntity<>(new ResponMessage("yes"), HttpStatus.OK);
    }
    @GetMapping("/list")
    public ResponseEntity<?> showListCategory(){
        List<Category> categoryList = categoryService.findAll();
        if(categoryList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(categoryList, HttpStatus.OK);
    }
}
