package com.example.ecommerce.controller;




import com.example.ecommerce.dto.ProductDto;
import com.example.ecommerce.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;




@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {


    private final ProductService productService;


    @GetMapping
    public List<ProductDto> getAllProducts(){
        return productService.getProducts();
    }


    @PostMapping
    public void addProduct(@RequestBody ProductDto product){
        productService.saveProduct(product);
    }

}
