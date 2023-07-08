package com.mathtutoringwebapp.mathtutoringwebapp.backendServer.services;

import com.mathtutoringwebapp.mathtutoringwebapp.backendServer.mappersAndDtos.otherDtos.CredentialsDto;
import com.mathtutoringwebapp.mathtutoringwebapp.backendServer.mappersAndDtos.otherDtos.SignUpDto;
import com.mathtutoringwebapp.mathtutoringwebapp.backendServer.mappersAndDtos.UserDto;
import com.mathtutoringwebapp.mathtutoringwebapp.backendServer.entities.User;
import com.mathtutoringwebapp.mathtutoringwebapp.backendServer.exception.AppException;
import com.mathtutoringwebapp.mathtutoringwebapp.backendServer.mappersAndDtos.mappers.UserMapper;
import com.mathtutoringwebapp.mathtutoringwebapp.backendServer.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;


    public User findById(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            return optionalUser.get();
        } else {
            throw new RuntimeException("user not found");
        }
    }

    public void saveUser(User user) {
        userRepository.save(user);
    }

    public UserDto login(CredentialsDto credentialsDto) {
        User user = userRepository.findByEmail(credentialsDto.getEmail())
                .orElseThrow(() -> new AppException("Unknown user", HttpStatus.NOT_FOUND));

        if (passwordEncoder.matches(credentialsDto.getPassword(), user.getPassword())) {
            return userMapper.toUserDto(user);
        }
        throw new AppException("Invalid password", HttpStatus.BAD_REQUEST);
    }

    public UserDto register(SignUpDto userDto) {
        Optional<User> optionalUser = userRepository.findByEmail(userDto.getEmail());

        if (optionalUser.isPresent()) {
            throw new AppException("Login already exists", HttpStatus.BAD_REQUEST);
        }

        User user = userMapper.signUpToUser(userDto);
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));

        User savedUser = userRepository.save(user);

        return userMapper.toUserDto(savedUser);
    }

    public UserDto findByEmail(String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new AppException("Unknown user", HttpStatus.NOT_FOUND));
        return userMapper.toUserDto(user);
    }

    public Long getIdByEmail(String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new AppException("Unknown user", HttpStatus.NOT_FOUND));
        return user.getId();
    }

}
