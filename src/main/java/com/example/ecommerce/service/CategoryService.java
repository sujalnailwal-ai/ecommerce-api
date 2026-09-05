package com.example.ecommerce.service;


import com.example.ecommerce.dto.CategoryDto;
import com.example.ecommerce.entity.Category;
import com.example.ecommerce.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
@RequiredArgsConstructor
public class CategoryService {


    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;


    public List<CategoryDto> getCategories(){
        List<Category> list=categoryRepository.findAll();
        return list.stream().map((element) -> modelMapper.map(element, CategoryDto.class)).toList();
    }


    public void addNewCategory(CategoryDto categoryDto){
        Category category = modelMapper.map(categoryDto,Category.class);
        categoryRepository.save(category);
    }


    public void deleteCategory(Long id){
        Category category=categoryRepository.findById(id).orElseThrow();
        categoryRepository.delete(category);
    }


    public void updateCategoryName(Long id,CategoryDto categoryDto){
        Category category = categoryRepository.findById(id).orElseThrow();
        category.setCategoryName(categoryDto.getName());
    }



}
