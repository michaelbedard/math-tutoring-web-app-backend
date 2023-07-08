package com.mathtutoringwebapp.mathtutoringwebapp.backendServer.mappersAndDtos.QuestionRelatedDtos;

import com.mathtutoringwebapp.mathtutoringwebapp.backendServer.entities.questionRelatedEntities.Equation.Equation;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StepDto {
    private String stepType;

    // Common fields or methods for all steps
    private Equation equation;
    private String useCase;
    private List<String> variablesUseByName;

    //EquationStep
    private String variableCreatedByName;
}

