package com.mathtutoringwebapp.mathtutoringwebapp.backendServer.mappersAndDtos.mappers;

import com.mathtutoringwebapp.mathtutoringwebapp.backendServer.entities.questionRelatedEntities.steps.EquationStep;
import com.mathtutoringwebapp.mathtutoringwebapp.backendServer.entities.questionRelatedEntities.steps.GraphStep;
import com.mathtutoringwebapp.mathtutoringwebapp.backendServer.mappersAndDtos.QuestionRelatedDtos.StepDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface StepMapper {

    EquationStep toEquationStep(StepDto stepDto);

    default EquationStep toEquationStep(StepDto stepDto, @MappingTarget EquationStep equationStep) {
        equationStep.setVariableCreatedByName(stepDto.getVariableCreatedByName());
        // map other fields if needed
        return equationStep;
    }

    GraphStep toGraphStep(StepDto stepDto);
}
