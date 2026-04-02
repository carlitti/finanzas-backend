package com.carlos.finanzas.service;

import com.carlos.finanzas.dto.UserResponse;
import com.carlos.finanzas.entity.User;
import com.carlos.finanzas.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public UserResponse createUser(User user) {
        User savedUser = userRepository.save(user);
        return new UserResponse(
                savedUser.getId(),
                savedUser.getUsername()
        );
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}