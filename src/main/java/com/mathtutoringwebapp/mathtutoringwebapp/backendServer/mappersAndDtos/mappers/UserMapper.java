package com.mathtutoringwebapp.mathtutoringwebapp.backendServer.mappersAndDtos.mappers;


import com.mathtutoringwebapp.mathtutoringwebapp.backendServer.mappersAndDtos.otherDtos.SignUpDto;
import com.mathtutoringwebapp.mathtutoringwebapp.backendServer.mappersAndDtos.UserDto;
import com.mathtutoringwebapp.mathtutoringwebapp.backendServer.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto toUserDto(User user);

    @Mapping(target = "password", ignore = true)
    User signUpToUser(SignUpDto signUpDto);
}
