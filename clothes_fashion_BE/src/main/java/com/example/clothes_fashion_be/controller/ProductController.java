package com.example.clothes_fashion_be.controller;

import com.example.clothes_fashion_be.entitys.dto.request.ProductCreateRequest;
import com.example.clothes_fashion_be.entitys.dto.request.ProductUpdateRequest;
import com.example.clothes_fashion_be.entitys.dto.response.ApiResponse;
import com.example.clothes_fashion_be.entitys.dto.response.ProductResponseProjection;
import com.example.clothes_fashion_be.service.IProductService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequestMapping("/products")
public class ProductController {
    IProductService productService;

    @GetMapping
    public ApiResponse<List<ProductResponseProjection>> getAllProducts() {
        return ApiResponse.<List<ProductResponseProjection>>builder().data(productService.findAllProducts()).build();
    }

    @GetMapping("/{id}")
    public ApiResponse<ProductResponseProjection> getProductById(@PathVariable Long id) {
        return ApiResponse.<ProductResponseProjection>builder().data(productService.findProductById(id)).build();
    }
    @PostMapping
    public ApiResponse<Void> createProduct(@RequestBody ProductCreateRequest productCreateRequest) {
        productService.addProduct(productCreateRequest);
        return ApiResponse.<Void>builder().build();
    }
    @PutMapping
    public ApiResponse<Void> updateProduct(@RequestBody ProductUpdateRequest productUpdateRequest) {
        productService.updateProduct(productUpdateRequest);
        return ApiResponse.<Void>builder().build();
    }

}
