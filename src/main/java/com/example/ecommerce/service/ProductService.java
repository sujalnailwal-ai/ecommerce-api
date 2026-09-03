package com.example.ecommerce.service;

import com.example.ecommerce.dto.ProductDto;
import com.example.ecommerce.entity.Product;
import com.example.ecommerce.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;


    public List<ProductDto> getProducts(){

        List<Product> productList=productRepository.findAll();


        return productList.stream()
                .map((element) ->
                modelMapper.map(element, ProductDto.class))
                .toList();

    }

    public void saveProduct(ProductDto productDto){
        Product product =modelMapper.map(productDto,Product.class);
        productRepository.save(product);
    }




}
