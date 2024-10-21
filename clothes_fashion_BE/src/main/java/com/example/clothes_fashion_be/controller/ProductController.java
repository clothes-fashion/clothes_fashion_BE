package com.example.clothes_fashion_be.controller;

import com.example.clothes_fashion_be.entitys.dto.request.ProductCreateRequest;
import com.example.clothes_fashion_be.entitys.dto.request.ProductUpdateRequest;
import com.example.clothes_fashion_be.entitys.dto.response.ApiResponse;
import com.example.clothes_fashion_be.entitys.dto.response.ProductResponse;
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
    public ApiResponse<List<ProductResponse>> getAllProducts() {
        return ApiResponse.<List<ProductResponse>>builder().data(productService.findAllProducts()).build();
    }

    @GetMapping("/{id}")
    public ApiResponse<ProductResponse> getProductById(@PathVariable Long id) {
        ProductResponse productResponse = productService.findProductById(id);
        return ApiResponse.<ProductResponse>builder().data(productResponse).build();
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
