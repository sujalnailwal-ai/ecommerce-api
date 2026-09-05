package com.example.ecommerce.service;

import com.example.ecommerce.dto.ProductDto;
import com.example.ecommerce.dto.ProductUpdateDto;
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

    public List<ProductDto> findByCategory(Long id){
        List<Product> list=productRepository.findByCategoryCategoryId(id);
        return list.stream()
                .map((element)
                        -> modelMapper.map(element, ProductDto.class))
                .toList();
    }

    public void saveProduct(ProductDto productDto){
        Product product =modelMapper.map(productDto,Product.class);
        productRepository.save(product);
    }

    public void deleteProduct(Long id){
        Product product = productRepository.findById(id).orElseThrow();
        productRepository.delete(product);
    }


    public void updateProductById(Long id, ProductUpdateDto productUpdateDto){
        Product product = productRepository.findById(id).orElseThrow();
        modelMapper.map(productUpdateDto,product);
        productRepository.save(product);
    }


    public void updateFieldsInProduct(Long id,ProductUpdateDto productUpdateDto){
        Product product = productRepository.findById(id).orElseThrow();
        if(productUpdateDto.getPrice()!=null){
            product.setPrice(productUpdateDto.getPrice());
        }
        if(productUpdateDto.getProductName()!=null){
            product.setProductName(productUpdateDto.getProductName());
        }
        if(productUpdateDto.getCategory()!=null){
            product.setCategory(productUpdateDto.getCategory());
        }
        if(productUpdateDto.getDescription()!=null){
            product.setDescription(productUpdateDto.getDescription());
        }
        if(productUpdateDto.getStock()!=null){
            product.setStock(productUpdateDto.getStock());
        }

        productRepository.save(product);
    }




}
