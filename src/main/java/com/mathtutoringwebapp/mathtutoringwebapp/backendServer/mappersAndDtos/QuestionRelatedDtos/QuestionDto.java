package com.mathtutoringwebapp.mathtutoringwebapp.backendServer.mappersAndDtos.QuestionRelatedDtos;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class QuestionDto {
    private String questionText;
    private String image;
}
