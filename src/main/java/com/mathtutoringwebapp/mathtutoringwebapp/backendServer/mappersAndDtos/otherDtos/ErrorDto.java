package com.mathtutoringwebapp.mathtutoringwebapp.backendServer.mappersAndDtos.otherDtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder
public class ErrorDto {

    private String message;
}
