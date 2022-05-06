package az.developia.compshopsemseddinsalehli.service;

import az.developia.compshopsemseddinsalehli.dto.request.UserRequest;
import az.developia.compshopsemseddinsalehli.dto.response.UserResponse;

import java.util.List;

public interface UserService {

    List<UserResponse> getAll();

    Long add(UserRequest userRequest);

    UserResponse update(Long id , UserRequest request);

    Long delete(Long id);

    UserResponse findByUsername(String username);

}
