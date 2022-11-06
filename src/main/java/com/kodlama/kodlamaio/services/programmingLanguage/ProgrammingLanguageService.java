package com.kodlama.kodlamaio.services.programmingLanguage;

import com.kodlama.kodlamaio.models.ProgrammingLanguage;
import com.kodlama.kodlamaio.models.Technology;
import com.kodlama.kodlamaio.repositories.ProgrammingLanguageRepository;
import com.kodlama.kodlamaio.repositories.TechnologyRepository;
import com.kodlama.kodlamaio.services.programmingLanguage.commands.CreateProgrammingLanguageDto;
import com.kodlama.kodlamaio.services.programmingLanguage.commands.UpdateProgrammingLanguageDto;
import com.kodlama.kodlamaio.services.programmingLanguage.constants.ProgrammingLanguageMessages;
import com.kodlama.kodlamaio.services.programmingLanguage.mapper.ProgrammingLanguageMapper;
import com.kodlama.kodlamaio.services.programmingLanguage.queries.GetListProgrammingLanguageDto;
import com.kodlama.kodlamaio.services.programmingLanguage.queries.GetProgrammingLanguageByIdDto;
import com.kodlama.kodlamaio.services.programmingLanguage.queries.GetProgrammingLanguageByNameDto;
import com.kodlama.kodlamaio.services.programmingLanguage.queries.GetProgrammingLanguagesWithTechnologyDto;
import com.kodlama.kodlamaio.services.technology.mapper.TechnologyMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProgrammingLanguageService {

    private final ProgrammingLanguageRepository repository;
    private final TechnologyRepository technologyRepository;
    private final ProgrammingLanguageMapper mapper;
    private final TechnologyMapper technologyMapper;

    public ProgrammingLanguageService(ProgrammingLanguageRepository repository, TechnologyRepository technologyRepository, ProgrammingLanguageMapper mapper, TechnologyMapper technologyMapper) {
        this.repository = repository;
        this.technologyRepository = technologyRepository;
        this.mapper = mapper;
        this.technologyMapper = technologyMapper;
    }

    public List<GetListProgrammingLanguageDto> getAll(){
        var languageList = repository.findAll();
        return mapper.toLanguages(languageList);
    }

//    public List<GetProgrammingLanguagesWithTechnologyDto> getAllWithTechnologies(){
//        var languageList = repository.findAll();
//
//        var technologyList  = technologyMapper.toTechListForLanguage(technologyRepository.findAll());
//
//        var mappedLanguageList = mapper.toLanguagesWithTechnologies(languageList);
//
//        for (var languages:mappedLanguageList) {
//                languages.setTechnologies(technologyList);
//        }
//        return mappedLanguageList;
//    }
    public List<GetProgrammingLanguagesWithTechnologyDto> getAllWithTechnologies(){
            var languageList = repository.findAll();
            return mapper.toLanguagesWithTechnologies(languageList);
    }


    public GetProgrammingLanguageByIdDto getById(Long id){
        var language = repository.findById(id).get();
        return mapper.toLanguageById(language);
    }

    public GetProgrammingLanguageByNameDto getByName(String name){
        var language = repository.findProgrammingLanguageByName(name);
        return mapper.toLanguageByName(language);
    }

    public CreateProgrammingLanguageDto createProgrammingLanguage(CreateProgrammingLanguageDto programmingLanguage) throws Exception{
        var language = mapper.toCreateLanguage(programmingLanguage);
        if(checkIfProgrammingLanguageNameValid(language)){
            throw new Exception(ProgrammingLanguageMessages.PROGRAMMINGLANGUAGE_NOTVALID);
        }
        repository.save(language);
        programmingLanguage.setName(language.getName());
        programmingLanguage.setId(language.getId());
        return programmingLanguage;
    }

    public void delete(Long id){
        repository.deleteById(id);
    }

    public UpdateProgrammingLanguageDto update(UpdateProgrammingLanguageDto programmingLanguage, Long id) throws Exception{
        var updateLanguage = repository.findById(id).get();
        mapper.update(updateLanguage,programmingLanguage);
        if(checkIfProgrammingLanguageNameValid(updateLanguage)){
            throw new Exception(ProgrammingLanguageMessages.PROGRAMMINGLANGUAGE_NOTVALID);
        }
        repository.save(updateLanguage);
        programmingLanguage.setName(updateLanguage.getName());
        return programmingLanguage;
    }

    private boolean checkIfProgrammingLanguageNameValid(ProgrammingLanguage language){
        return language.getName().isEmpty();
    }
    private boolean checkIfProgrammingLanguageExists(ProgrammingLanguage programmingLanguage){
        var language = repository.findById(programmingLanguage.getId()).get();
        return programmingLanguage == language;
    }
}
