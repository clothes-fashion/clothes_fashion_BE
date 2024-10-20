package com.example.clothes_fashion_be.repository;

import com.example.clothes_fashion_be.entitys.Product;
import com.example.clothes_fashion_be.entitys.dto.request.ProductCreateRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Repository
public interface IProductRepository extends JpaRepository<Product, Long> {
    @Query(value = "select p.id, p.name, p.price, p.background_image, p.images, p.sold, p.last_update, p.description " +
            "from product p join category c on p.category_id = c.id", nativeQuery = true)
    List<Object[]> findAllProductByQuery();

    @Modifying
    @Transactional
    @Query(value = "insert into product(name, price, background_image, images, gender, last_update, description, category_id)" +
            "values(:#{#request.name}, :#{#request.price}, :#{#request.backgroundImage}, :#{#request.images}, :#{#request.gender}," +
            ":#{#request.lastUpdate}, :#{#request.description}, :#{#request.categoryId});"
            , nativeQuery = true)
    void createProductByQuery(@Param("request") ProductCreateRequest request);
}