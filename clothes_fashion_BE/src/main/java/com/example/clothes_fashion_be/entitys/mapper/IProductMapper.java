package com.example.clothes_fashion_be.entitys.mapper;

import com.example.clothes_fashion_be.entitys.Product;
import com.example.clothes_fashion_be.entitys.dto.request.ProductCreateRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IProductMapper {
    Product toProduct(ProductCreateRequest productCreateRequest);
}
///    User toUser(UserCreationRequest userCreationRequest);
/// //    @Mapping(source = "firstName", target = "lastName")
/// //    @Mapping(target = "firstName", ignore = true)
///     UserResponse toUserResponse(User user);
///     @Mapping(target = "roles", ignore = true)
///     void updateUser(@MappingTarget User user, UserUpdateRequest userUpdateRequest);