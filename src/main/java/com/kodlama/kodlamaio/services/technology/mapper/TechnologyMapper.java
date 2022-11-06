package com.kodlama.kodlamaio.services.technology.mapper;

import com.kodlama.kodlamaio.models.Technology;
import com.kodlama.kodlamaio.services.programmingLanguage.queries.GetListTechnologyForLanguageDto;
import com.kodlama.kodlamaio.services.technology.commands.CreateTechnologyDto;
import com.kodlama.kodlamaio.services.technology.commands.UpdateTechnologyDto;
import com.kodlama.kodlamaio.services.technology.queries.GetListTechnologyDto;
import com.kodlama.kodlamaio.services.technology.queries.GetTechnologiesWithLanguages;
import com.kodlama.kodlamaio.services.technology.queries.GetTechnologyByIdDto;
import com.kodlama.kodlamaio.services.technology.queries.GetTechnologyByNameDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper(componentModel = "spring")
public interface TechnologyMapper {
    TechnologyMapper INSTANCE = Mappers.getMapper(TechnologyMapper.class);

    List<GetListTechnologyDto> toTechnologies(List<Technology> technologies);
    @Mapping(source = "programmingLanguage.name", target = "languageName")
    List<GetTechnologiesWithLanguages> toTechnologiesWithLanguages(List<Technology> technologies);

    List<GetListTechnologyForLanguageDto> toTechListForLanguage(List<Technology> technologies);
    GetTechnologyByIdDto toTechnologyById(Technology technology);
    GetTechnologyByNameDto toTechnologyByName(Technology technology);
    Technology toCreateTechnology(CreateTechnologyDto technology);
    @Mapping( target = "programmingLanguage.id", source = "programmingLanguageId")
    void update(@MappingTarget Technology technology,UpdateTechnologyDto updateTechnology);
}
