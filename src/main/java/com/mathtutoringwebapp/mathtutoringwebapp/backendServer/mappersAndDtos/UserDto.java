package com.mathtutoringwebapp.mathtutoringwebapp.backendServer.mappersAndDtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {

    private Long userId;
    private String name;
    private String email;
    private String password;
    private String[] authorizations;
    private String JWT_TOKEN;
}