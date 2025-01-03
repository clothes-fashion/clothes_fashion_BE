package com.example.clothes_fashion_be.entitys.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductCreateRequest {
    String name;
    long price;
    String backgroundImage;
    String images;
    boolean gender;
    Date lastUpdate;
    String description;
    Long categoryId;
}
