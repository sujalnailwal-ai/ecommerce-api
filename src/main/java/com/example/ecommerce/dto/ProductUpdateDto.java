package com.example.ecommerce.dto;


import com.example.ecommerce.entity.Category;
import lombok.Data;
import java.math.BigDecimal;


@Data
public class ProductUpdateDto {

    private String productName;

    private String description;

    private BigDecimal price;

    private Integer stock;

    private Category category;
}
