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
import com.kodlama.kodlamaio.services.technology.queries.GetListTechnologyForLanguageDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProgrammingLanguageService {

    private final ProgrammingLanguageRepository repository;
    private final TechnologyRepository technologyRepository;
    private final ProgrammingLanguageMapper mapper;

    public ProgrammingLanguageService(ProgrammingLanguageRepository repository,
                                      TechnologyRepository technologyRepository,
                                      ProgrammingLanguageMapper mapper) {
        this.repository = repository;
        this.technologyRepository = technologyRepository;
        this.mapper = mapper;
    }

    public List<GetListProgrammingLanguageDto> getAll() {
        var languageList = repository.findAll();
        return mapper.toLanguages(languageList);
    }
    // Not using mapstruct here because it does not mapping language and technologies correctly
    // Mapping by myself
    public List<GetProgrammingLanguagesWithTechnologyDto> getAllWithTechnologies() {
        var languageList = repository.findAll();
        var technologyList = technologyRepository.findAll();

        var responseList = new ArrayList<GetProgrammingLanguagesWithTechnologyDto>();
        for (var language : languageList) {
            var response = new GetProgrammingLanguagesWithTechnologyDto();
            response.setId(language.getId());
            response.setName(language.getName());

            var technologies = new ArrayList<GetListTechnologyForLanguageDto>();
            for (var technology : technologyList) {
                if (technology.getProgrammingLanguage().getId().equals(language.getId())) {
                    var getListTech = new GetListTechnologyForLanguageDto();
                    getListTech.setId(technology.getId());
                    getListTech.setName(technology.getName());
                    technologies.add(getListTech);
                }
            }
            response.setTechnologies(technologies);
            responseList.add(response);
        }
        return responseList;
    }

    public GetProgrammingLanguageByIdDto getById(Long id) {
        var language = repository.findById(id).get();
        return mapper.toLanguageById(language);
    }

    public GetProgrammingLanguageByNameDto getByName(String name) {
        var language = repository.findProgrammingLanguageByName(name);
        return mapper.toLanguageByName(language);
    }

    public CreateProgrammingLanguageDto createProgrammingLanguage(CreateProgrammingLanguageDto programmingLanguage) throws Exception {
        var language = mapper.toCreateLanguage(programmingLanguage);
        if (checkIfProgrammingLanguageNameValid(language)) {
            throw new Exception(ProgrammingLanguageMessages.PROGRAMMINGLANGUAGE_NOTVALID);
        }
        repository.save(language);
        programmingLanguage.setName(language.getName());
        programmingLanguage.setId(language.getId());
        return programmingLanguage;
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public UpdateProgrammingLanguageDto update(UpdateProgrammingLanguageDto programmingLanguage, Long id) throws Exception {
        var updateLanguage = repository.findById(id).get();
        mapper.update(updateLanguage, programmingLanguage);
        if (checkIfProgrammingLanguageNameValid(updateLanguage)) {
            throw new Exception(ProgrammingLanguageMessages.PROGRAMMINGLANGUAGE_NOTVALID);
        }
        repository.save(updateLanguage);
        programmingLanguage.setName(updateLanguage.getName());
        return programmingLanguage;
    }

    private boolean checkIfProgrammingLanguageNameValid(ProgrammingLanguage language) {
        return language.getName().isEmpty();
    }

    private boolean checkIfProgrammingLanguageExists(ProgrammingLanguage programmingLanguage) {
        var language = repository.findById(programmingLanguage.getId()).get();
        return programmingLanguage == language;
    }
}
