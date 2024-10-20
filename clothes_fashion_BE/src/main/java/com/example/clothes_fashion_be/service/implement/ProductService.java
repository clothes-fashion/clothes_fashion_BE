package com.example.clothes_fashion_be.service.implement;

import com.example.clothes_fashion_be.entitys.dto.request.ProductCreateRequest;
import com.example.clothes_fashion_be.entitys.dto.request.ProductUpdateRequest;
import com.example.clothes_fashion_be.entitys.dto.response.ProductResponse;
import com.example.clothes_fashion_be.repository.IProductRepository;
import com.example.clothes_fashion_be.service.IProductService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ProductService implements IProductService {
    IProductRepository productRepository;
    ModelMapper modelMapper;

    @Override
    public List<ProductResponse> getAllProducts() {
        List<Object[]> list = productRepository.findAllProductByQuery();
        List<ProductResponse> productResponseList = new ArrayList<>();
        for (Object[] object : list) {
            productResponseList.add(new ProductResponse(
                    (Long) object[0],
                    (String) object[1],
                    (Long) object[2],
                    (String) object[3],
                    (String) object[4],
                    (Long) object[5],
                    (Date) object[6],
                    (String) object[7]));
        }
        return productResponseList;
    }

    @Override
    public ProductResponse getProductById(Long id) {
        return null;
    }

    @Override
    public void createProduct(ProductCreateRequest productCreateRequest) {
        productRepository.createProductByQuery(productCreateRequest);
    }

    @Override
    public ProductResponse updateProduct(ProductUpdateRequest productUpdateRequest) {
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
//        System.out.println("In method getUsers");
//        List<User> users = userRepository.findAll();
//        List<UserResponse> userResponses = new ArrayList<>();
//        for (User user : users) {
//            userResponses.add(userMapper.toUserResponse(user));
//
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
//    public UserResponse getMyInfo() {
//        var context = SecurityContextHolder.getContext();
//        String username = context.getAuthentication().getName();
//        User user = userRepository.findByUsername(username).orElseThrow(() -> new AppException(ErrorCode.USER_NOT_EXISTED));
//        return userMapper.toUserResponse(user);
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
//
//    public void deleteUser(String id) {
//        userRepository.deleteById(id);
//    }
//}
