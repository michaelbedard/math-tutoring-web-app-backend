package com.mathtutoringwebapp.mathtutoringwebapp.backendServer.mappersAndDtos.otherDtos;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class CredentialsDto {

    private String email;
    private String password;

}
