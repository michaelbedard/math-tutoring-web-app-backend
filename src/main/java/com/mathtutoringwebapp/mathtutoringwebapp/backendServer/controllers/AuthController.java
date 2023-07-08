package com.mathtutoringwebapp.mathtutoringwebapp.backendServer.controllers;

import com.mathtutoringwebapp.mathtutoringwebapp.backendServer.config.security.UserJwtTokenAuthProvider;
import com.mathtutoringwebapp.mathtutoringwebapp.backendServer.mappersAndDtos.otherDtos.CredentialsDto;
import com.mathtutoringwebapp.mathtutoringwebapp.backendServer.mappersAndDtos.otherDtos.SignUpDto;
import com.mathtutoringwebapp.mathtutoringwebapp.backendServer.mappersAndDtos.UserDto;
import com.mathtutoringwebapp.mathtutoringwebapp.backendServer.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.net.URI;

@RequiredArgsConstructor
@RequestMapping("/api")
@RestController
public class AuthController {

    private final UserService userService;
    private final UserJwtTokenAuthProvider userAuthenticationProvider;

    @PostMapping("/login")
    public ResponseEntity<UserDto> login(@RequestBody @Valid CredentialsDto credentialsDto) {
        UserDto userDto = userService.login(credentialsDto);
        userDto.setJWT_TOKEN(userAuthenticationProvider.createToken(userDto.getEmail()));
        return ResponseEntity.ok(userDto);
    }

    @PostMapping("/register")
    public ResponseEntity<UserDto> register(@RequestBody @Valid SignUpDto user) {
        UserDto createdUser = userService.register(user);
        createdUser.setJWT_TOKEN(userAuthenticationProvider.createToken(user.getEmail()));
        return ResponseEntity.created(URI.create("/users/" + createdUser.getUserId())).body(createdUser);
    }

}
