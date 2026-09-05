package com.example.ecommerce.controller;


import com.example.ecommerce.dto.ProductDto;
import com.example.ecommerce.dto.ProductUpdateDto;
import com.example.ecommerce.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {


    private final ProductService productService;


    @GetMapping
    public ResponseEntity<List<ProductDto>> getAllProducts(){
        return ResponseEntity.ok(productService.getProducts());
    }


    @GetMapping("/categoryId")
    public ResponseEntity<List<ProductDto>> getAllProductsByCategory(@PathVariable("categoryId") Long id){
        return ResponseEntity.ok(productService.findByCategory(id));
    }


    @PostMapping
    public ResponseEntity<Void> addProduct(@RequestBody ProductDto product) {
        productService.saveProduct(product);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProductById(@PathVariable("id") Long id){
        productService.deleteProduct(id);
        return ResponseEntity.accepted().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateProductById(@PathVariable("id") Long id ,
                                                  @RequestBody ProductUpdateDto productUpdateDto){

        productService.updateProductById(id,productUpdateDto);
        return ResponseEntity.noContent().build();

    }


    @PatchMapping("/{id}")
    public ResponseEntity<Void> updateProductInfo(@PathVariable("id") Long id,@RequestBody ProductUpdateDto productUpdateDto){
        productService.updateFieldsInProduct(id,productUpdateDto);
        return ResponseEntity.noContent().build();
    }
}
