package com.mathtutoringwebapp.mathtutoringwebapp.backendServer.mappersAndDtos.QuestionRelatedDtos;

import com.mathtutoringwebapp.mathtutoringwebapp.backendServer.entities.questionRelatedEntities.Unit;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VariableDto {
    private String name;
    private Unit units;
    private double value;
    private int delta;
    private String type;
}
