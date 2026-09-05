package com.example.ecommerce.controller;


import com.example.ecommerce.dto.CategoryDto;
import com.example.ecommerce.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping("/api/category")
public class CategoryController {


    private final CategoryService categoryService;


    @GetMapping
    public ResponseEntity<List<CategoryDto>> getAllCategories(){
        return ResponseEntity.ok(categoryService.getCategories());
    }


    @PostMapping
    public ResponseEntity<Void> addCategory(@RequestBody CategoryDto categoryDto){
        categoryService.addNewCategory(categoryDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


    @DeleteMapping("/{id}")
    public void deleteCategoryById(@PathVariable Long id){
        categoryService.deleteCategory(id);
        ResponseEntity.noContent().build();
    }


    @PatchMapping("/{id}")
    public void fixCategoryName(@PathVariable("id") Long id,@RequestBody CategoryDto categoryDto){
        categoryService.updateCategoryName(id,categoryDto);
        ResponseEntity.noContent().build();
    }



}
