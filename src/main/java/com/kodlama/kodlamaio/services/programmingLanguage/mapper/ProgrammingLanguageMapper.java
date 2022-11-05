package com.kodlama.kodlamaio.services.programmingLanguage.mapper;

import com.kodlama.kodlamaio.models.ProgrammingLanguage;
import com.kodlama.kodlamaio.services.programmingLanguage.commands.CreateProgrammingLanguageDto;
import com.kodlama.kodlamaio.services.programmingLanguage.commands.DeleteProgrammingLanguageDto;
import com.kodlama.kodlamaio.services.programmingLanguage.commands.UpdateProgrammingLanguageDto;
import com.kodlama.kodlamaio.services.programmingLanguage.queries.GetListProgrammingLanguageDto;
import com.kodlama.kodlamaio.services.programmingLanguage.queries.GetProgrammingLanguageByIdDto;
import com.kodlama.kodlamaio.services.programmingLanguage.queries.GetProgrammingLanguageByNameDto;
import com.kodlama.kodlamaio.services.programmingLanguage.queries.GetProgrammingLanguagesWithTechnologyDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@Mapper(componentModel = "spring")
public interface ProgrammingLanguageMapper {

    ProgrammingLanguageMapper INSTANCE = Mappers.getMapper(ProgrammingLanguageMapper.class);

    List<GetListProgrammingLanguageDto> toLanguages(List<ProgrammingLanguage> programmingLanguages);
    List<GetProgrammingLanguagesWithTechnologyDto> toLanguagesWithTechnologies(List<ProgrammingLanguage> programmingLanguages);
    GetProgrammingLanguageByIdDto toLanguageById(ProgrammingLanguage programmingLanguage);
    GetProgrammingLanguageByNameDto toLanguageByName(ProgrammingLanguage programmingLanguage);
    ProgrammingLanguage toCreateLanguage(CreateProgrammingLanguageDto programmingLanguage);
    ProgrammingLanguage toDeleteLanguage(DeleteProgrammingLanguageDto programmingLanguage);
    void update(@MappingTarget ProgrammingLanguage language, UpdateProgrammingLanguageDto programmingLanguage);
}
