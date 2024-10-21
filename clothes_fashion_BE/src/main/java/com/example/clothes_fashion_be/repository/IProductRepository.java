package com.example.clothes_fashion_be.repository;

import com.example.clothes_fashion_be.entitys.Product;
import com.example.clothes_fashion_be.entitys.dto.request.ProductCreateRequest;
import com.example.clothes_fashion_be.entitys.dto.request.ProductUpdateRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface IProductRepository extends JpaRepository<Product, Long> {
    @Query(value = "select p.id, p.name, p.price, p.background_image, p.images, p.sold, p.last_update, p.description " +
            "from product p join category c on p.category_id = c.id where p.is_deleted = false", nativeQuery = true)
    List<Object[]> findAllProductByQuery();

    @Modifying
    @Transactional
    @Query(value = "insert into product(name, price, background_image, images, gender, last_update, description, category_id)" +
            "values(:#{#request.name}, :#{#request.price}, :#{#request.backgroundImage}, :#{#request.images}, :#{#request.gender}," +
            ":#{#request.lastUpdate}, :#{#request.description}, :#{#request.categoryId});"
            , nativeQuery = true)
    void addProductByQuery(@Param("request") ProductCreateRequest request);


    @Modifying
    @Transactional
    @Query(value = "update product p set " +
            "p.name = :#{#request.name}, p.price = :#{#request.price},p.background_image =:#{#request.backgroundImage}," +
            "p.images= :#{#request.images},p.gender= :#{#request.gender}," +
            "p.last_update=:#{#request.lastUpdate},p.description= :#{#request.description},p.category_id= :#{#request.categoryId} where p.id = :#{#request.id};"
            , nativeQuery = true)
    void updateProductByQuery(@Param("request") ProductUpdateRequest request);

    @Query(value = "select p.id, p.name, p.price, p.background_image, p.images, p.sold, p.last_update, p.description " +
            "from product p join category c on p.category_id = c.id where p.id = ?1 and p.is_deleted = 0;", nativeQuery = true)
    List<Object[]> findProductByQuery(Long id);

}