package com.mathtutoringwebapp.mathtutoringwebapp.backendServer.mappersAndDtos.QuestionRelatedDtos;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PostQuestionDto {
    private QuestionDto questionDto;
    private List<StepDto> stepDtos;
    private List<VariableDto> variableDtos;
}
