package com.example.clothes_fashion_be.entitys.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductResponse {
    Long id;
    String name;
    long price;
    String backgroundImage;
    String images;
    long sold;
    Date lastUpdate;
    String description;
}
