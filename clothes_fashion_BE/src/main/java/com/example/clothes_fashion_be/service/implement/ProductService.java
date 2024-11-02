package com.example.clothes_fashion_be.service.implement;

import com.example.clothes_fashion_be.entitys.dto.request.ProductCreateRequest;
import com.example.clothes_fashion_be.entitys.dto.request.ProductUpdateRequest;
import com.example.clothes_fashion_be.entitys.dto.response.ProductResponse;
import com.example.clothes_fashion_be.entitys.dto.response.ProductResponseProjection;
import com.example.clothes_fashion_be.repository.ICategoryRepository;
import com.example.clothes_fashion_be.repository.IProductRepository;
import com.example.clothes_fashion_be.service.IProductService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ProductService implements IProductService {
    IProductRepository productRepository;
    ModelMapper modelMapper;
    ICategoryRepository categoryRepository;

    @Override
    public List<ProductResponseProjection> findAllProducts() {
        return productRepository.findAllProductByQuery();
    }

    @Override
    public ProductResponseProjection findProductById(Long id) {
        return productRepository.findProductByQuery(id);
    }

    @Override
    public void addProduct(ProductCreateRequest productCreateRequest) {
        productCreateRequest.setLastUpdate(new Date());
    }

    @Override
    public ProductResponse updateProduct(ProductUpdateRequest productUpdateRequest) {
        productUpdateRequest.setLastUpdate(new Date());
        productRepository.updateProductByQuery(productUpdateRequest);
        return null;
    }

    @Override
    public void deleteProductByID(Long id) {
    }
}
    //    public UserResponse createUser(UserCreationRequest request) {
//        User user = userMapper.toUser(request);
//        user.setPassword(passwordEncoder.encode(request.getPassword()));
//
//        HashSet<Role> roles = new HashSet<>();
////        roles.add(roleRepository.getRoleById(request.getClass()));
////        user.setRoles(roles);
//        return userMapper.toUserResponse(userRepository.save(user));
//    }

////    @PreAuthorize("hasRole('ADMIN')")
//    @PreAuthorize("hasAuthority('APPROVE_POST')")
//    public List<UserResponse> getUsers() {
//        List<User> users = userRepository.findAll();
//        List<UserResponse> userResponses = new ArrayList<>();
//        for (User user : users) {
//            userResponses.add(userMapper.toUserResponse(user));
//        }
//        return userResponses;
//
//    }

//    @PostAuthorize("returnObject.id == authentication.principal.id")
//    public UserResponse getUser(String id) {
//        UserResponse userResponse = userMapper.toUserResponse(userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found")));
//        System.out.println(userResponse.getId());
//        System.out.println(SecurityContextHolder.getContext().getAuthentication());
//        return userResponse;
//    }
//
//    public UserResponse updateUser(String id, UserUpdateRequest request) {
//        User user = userRepository.findById(id).orElseThrow(() -> new AppException(ErrorCode.USER_NOT_EXISTED));
//
//        userMapper.updateUser(user, request);
//
//        user.setPassword(passwordEncoder.encode(request.getPassword()));
//        var roles = roleRepository.findAllById(request.getRoles());
//        user.setRoles(new HashSet<>(roles) );
//        return userMapper.toUserResponse(userRepository.save(user));
//    }