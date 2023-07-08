package com.mathtutoringwebapp.mathtutoringwebapp.backendServer.mappersAndDtos.mappers;

import com.mathtutoringwebapp.mathtutoringwebapp.backendServer.entities.TabRelatedEntities.Highlight;
import com.mathtutoringwebapp.mathtutoringwebapp.backendServer.entities.questionRelatedEntities.Variable;
import com.mathtutoringwebapp.mathtutoringwebapp.backendServer.mappersAndDtos.HighlightDto;
import com.mathtutoringwebapp.mathtutoringwebapp.backendServer.mappersAndDtos.QuestionRelatedDtos.VariableDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface VariableMapper {

    Variable toVariable(VariableDto variableDto);
}
