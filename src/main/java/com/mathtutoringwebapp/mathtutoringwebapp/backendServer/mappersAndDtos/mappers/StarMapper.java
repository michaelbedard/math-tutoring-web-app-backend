package com.mathtutoringwebapp.mathtutoringwebapp.backendServer.mappersAndDtos.mappers;

import com.mathtutoringwebapp.mathtutoringwebapp.backendServer.entities.TabRelatedEntities.Star;
import com.mathtutoringwebapp.mathtutoringwebapp.backendServer.mappersAndDtos.StarDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StarMapper {
    StarDto toStarDto(Star Star);

    Star toStar(StarDto StarDto);

    List<StarDto> toStarDtoList(List<Star> Stars);

    List<Star> toStarList(List<StarDto> StarDtos);
}
