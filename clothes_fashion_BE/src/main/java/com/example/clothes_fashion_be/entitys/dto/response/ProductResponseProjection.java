package com.example.clothes_fashion_be.entitys.dto.response;

import java.util.Date;

public interface ProductResponseProjection {
    Long getId();

    String getName();

    long getPrice();

    String getBackgroundImage();

    String getImages();

    long getSold();

    Date getLastUpdate();

    String getDescription();
}
