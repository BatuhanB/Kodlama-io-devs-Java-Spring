package com.kodlama.kodlamaio.services.programmingLanguage.queries;

import java.util.List;

public class GetProgrammingLanguagesWithTechnologyDto {
    private Long id;
    private String name;
    private List<GetListTechnologyForLanguageDto> technologies;

    public GetProgrammingLanguagesWithTechnologyDto(){}

    public GetProgrammingLanguagesWithTechnologyDto(Long id, String name, List<GetListTechnologyForLanguageDto> technologies) {
        this.id = id;
        this.name = name;
        this.technologies = technologies;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<GetListTechnologyForLanguageDto> getTechnologies() {
        return technologies;
    }

    public void setTechnologies(List<GetListTechnologyForLanguageDto> technologies) {
        this.technologies = technologies;
    }
}
