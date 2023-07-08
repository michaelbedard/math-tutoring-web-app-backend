package com.mathtutoringwebapp.mathtutoringwebapp.backendServer.mappersAndDtos.mappers;


import com.mathtutoringwebapp.mathtutoringwebapp.backendServer.entities.TabRelatedEntities.Highlight;
import com.mathtutoringwebapp.mathtutoringwebapp.backendServer.mappersAndDtos.HighlightDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface HighlightMapper {

    HighlightDto toHighlightDto(Highlight highlight);

    Highlight toHighlight(HighlightDto highlightDto);

    List<HighlightDto> toHighlightDtoList(List<Highlight> highlights);

    List<Highlight> toHighlightList(List<HighlightDto> highlightDtos);
}