package com.example.clothes_fashion_be.entitys;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(columnDefinition = "boolean default false")
    boolean isDeleted;
    String name;
    long price;
    String backgroundImage;
    String images;
    @Column(columnDefinition = "boolean default false")
    boolean gender;
    @Column(nullable = false, columnDefinition = "BIGINT default 0")
    long sold;
    Date lastUpdate;
    String description;
    @ManyToOne
    @JoinColumn(name = "category_id")
    Category categories;
}
