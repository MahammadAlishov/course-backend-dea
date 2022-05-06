package az.developia.compshopsemseddinsalehli.service.impl;

import az.developia.compshopsemseddinsalehli.dto.request.UserRequest;
import az.developia.compshopsemseddinsalehli.dto.response.UserResponse;
import az.developia.compshopsemseddinsalehli.enums.ExceptionCode;
import az.developia.compshopsemseddinsalehli.exception.NotFoundException;
import az.developia.compshopsemseddinsalehli.model.Computer;
import az.developia.compshopsemseddinsalehli.model.User;
import az.developia.compshopsemseddinsalehli.repository.ComputerRepository;
import az.developia.compshopsemseddinsalehli.repository.UserRepository;
import az.developia.compshopsemseddinsalehli.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public List<UserResponse> getAll() {
        List<UserResponse> allUsers = userRepository.findAll().stream()
                .map(user -> modelMapper.map(user , UserResponse.class)).collect(Collectors.toList());
        return allUsers;
    }

    @Override
    public Long add(UserRequest userRequest) {
        userRequest.setPassword(passwordEncoder.encode(userRequest.getPassword()));
        User savedUser = userRepository
                .save(modelMapper.map(userRequest, User.class));
        return savedUser.getId();
    }

    @Override
    public UserResponse update(Long id, UserRequest request) {

        userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(User.class, id,
                ExceptionCode.USER_NOT_FOUND.getCode()));

        User newUser = User.builder()
                .id(id)
                .username(request.getUsername())
                .password(request.getPassword())
                .email(request.getEmail())
                .phone(request.getPhone())
                .name(request.getName())
                .surname(request.getSurname()).build();

        userRepository.save(newUser);

        return modelMapper.map(newUser , UserResponse.class);
    }

    @Override
    public Long delete(Long id) {
        User deletedUser = userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(User.class, id,
                        ExceptionCode.USER_NOT_FOUND.getCode()));
        userRepository.deleteById(deletedUser.getId());
        return deletedUser.getId();
    }

    @Override
    public UserResponse findByUsername(String username) {
        User findUser = userRepository.findByUsername(username).orElseThrow(() ->
                new NotFoundException(User.class , username , ExceptionCode.USER_NOT_FOUND.getCode()));

        return modelMapper.map(findUser , UserResponse.class);
    }
}
