package com.kodlama.kodlamaio.services.technology;

import com.kodlama.kodlamaio.models.Technology;
import com.kodlama.kodlamaio.repositories.ProgrammingLanguageRepository;
import com.kodlama.kodlamaio.repositories.TechnologyRepository;
import com.kodlama.kodlamaio.services.technology.commands.CreateTechnologyDto;
import com.kodlama.kodlamaio.services.technology.commands.UpdateTechnologyDto;
import com.kodlama.kodlamaio.services.technology.constants.TechnologyMessages;
import com.kodlama.kodlamaio.services.technology.mapper.TechnologyMapper;
import com.kodlama.kodlamaio.services.technology.queries.GetListTechnologyDto;
import com.kodlama.kodlamaio.services.technology.queries.GetTechnologyByIdDto;
import com.kodlama.kodlamaio.services.technology.queries.GetTechnologyByNameDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TechnologyService {

    private final TechnologyRepository technologyRepository;
    private final ProgrammingLanguageRepository languageRepository;
    private final TechnologyMapper mapper;

    public TechnologyService(TechnologyRepository technologyRepository,
                             ProgrammingLanguageRepository languageRepository,
                             TechnologyMapper mapper) {
        this.technologyRepository = technologyRepository;
        this.languageRepository = languageRepository;
        this.mapper = mapper;
    }

    public List<GetListTechnologyDto> getAll(){
        var getListTechnology = technologyRepository.findAll();
        return mapper.toTechnologies(getListTechnology);
    }

    public GetTechnologyByIdDto getById(Long id) throws Exception{
        if(!checkIfTechnologyExists(id)) throw new RuntimeException(TechnologyMessages.TECHNOLOGY_NOT_EXISTS);
        var getTechnology = technologyRepository.findById(id).get();
        return mapper.toTechnologyById(getTechnology);
    }

    public GetTechnologyByNameDto getByName(String name){
        var getTechnology = technologyRepository.findTechnologyByName(name);
        return mapper.toTechnologyByName(getTechnology);
    }

    public CreateTechnologyDto create(CreateTechnologyDto technologyDto) throws Exception{
        var technology = mapper.toCreateTechnology(technologyDto);
        var language = languageRepository.findById(technologyDto.getProgrammingLanguageId()).get();
        if(checkIfTechnologyValid(technology)) throw new RuntimeException(TechnologyMessages.TECHNOLOGY_NOT_VALID);
        technology.setProgrammingLanguage(language);
        technologyRepository.save(technology);
        technologyDto.setId(technology.getId());
        technologyDto.setName(technology.getName());
        technologyDto.setProgrammingLanguageId(language.getId());
        return technologyDto;
    }

    public UpdateTechnologyDto update(UpdateTechnologyDto technologyDto,Long id) throws Exception{
        var technology = technologyRepository.findById(id).get();
        mapper.update(technology,technologyDto);
        var language = languageRepository.findById(technologyDto.getProgrammingLanguageId()).get();
        if(checkIfTechnologyValid(technology)) throw new RuntimeException(TechnologyMessages.TECHNOLOGY_NOT_VALID);
        technology.setProgrammingLanguage(language);
        technologyRepository.save(technology);
        technologyDto.setName(technology.getName());
        technologyDto.setProgrammingLanguageId(language.getId());
        return technologyDto;
    }

    public void delete(Long id) throws Exception{
        var technology = technologyRepository.findById(id).get();
        if(!checkIfTechnologyExists(id)) throw new RuntimeException(TechnologyMessages.TECHNOLOGY_NOT_EXISTS);
        technologyRepository.delete(technology);
    }

    //this method returns true if inbound technology is empty which is mean technology is not in valid format
    private boolean checkIfTechnologyValid(Technology technology){
        return technology.getName().isEmpty();
    }
    //this method also returns true if inbound technology exists
    private boolean checkIfTechnologyExists(Long id){
        return technologyRepository.findById(id).isPresent();
    }
}
