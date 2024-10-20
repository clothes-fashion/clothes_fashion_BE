package com.example.clothes_fashion_be.service;

import com.example.clothes_fashion_be.entitys.Product;
import com.example.clothes_fashion_be.entitys.dto.request.ProductCreateRequest;
import com.example.clothes_fashion_be.entitys.dto.request.ProductUpdateRequest;
import com.example.clothes_fashion_be.entitys.dto.response.ProductResponse;

import java.util.List;

public interface IProductService {
    List<ProductResponse> getAllProducts();

    ProductResponse getProductById(Long id);

    void createProduct(ProductCreateRequest productCreateRequest);
    ProductResponse updateProduct(ProductUpdateRequest productUpdateRequest);

    void deleteProductByID(Long id);
}