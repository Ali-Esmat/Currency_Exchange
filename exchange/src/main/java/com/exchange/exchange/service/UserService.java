package com.exchange.exchange.service;

import org.springframework.stereotype.Service;
import com.exchange.exchange.repository.UserRepository;
import com.exchange.exchange.dto.RegisterRequest;
import com.exchange.exchange.dto.RegisterResponse;
import com.exchange.exchange.entity.User;
import com.exchange.exchange.exception.EmailAlreadyExistsException;

@Service
public class UserService {
    private final UserRepository userRepository;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public RegisterResponse registerUser(RegisterRequest request){
        if (userRepository.findByEmail(request.getEmail()).isPresent()){
            throw new EmailAlreadyExistsException(request.getEmail());
        }
        User user = new User(request.getEmail(), request.getPassword());
        userRepository.save(user);
        return new RegisterResponse("User registered successfully", user.getEmail());
    }

}
