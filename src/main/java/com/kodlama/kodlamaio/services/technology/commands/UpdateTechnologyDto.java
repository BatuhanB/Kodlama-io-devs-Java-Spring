package com.kodlama.kodlamaio.services.technology.commands;

public class UpdateTechnologyDto {
    private String name;
    private Long programmingLanguageId;

    public UpdateTechnologyDto(){}

    public UpdateTechnologyDto(String name, Long programmingLanguageId) {
        this.name = name;
        this.programmingLanguageId = programmingLanguageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getProgrammingLanguageId() {
        return programmingLanguageId;
    }

    public void setProgrammingLanguageId(Long programmingLanguageId) {
        this.programmingLanguageId = programmingLanguageId;
    }
}
