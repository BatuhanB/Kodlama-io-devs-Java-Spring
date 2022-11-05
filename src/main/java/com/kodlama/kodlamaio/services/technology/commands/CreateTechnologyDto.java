package com.kodlama.kodlamaio.services.technology.commands;

public class CreateTechnologyDto {
    private Long id;
    private String name;
    private Long programmingLanguageId;

    public CreateTechnologyDto(){}

    public CreateTechnologyDto(Long id, String name, Long programmingLanguageId) {
        this.id = id;
        this.name = name;
        this.programmingLanguageId = programmingLanguageId;
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

    public Long getProgrammingLanguageId() {
        return programmingLanguageId;
    }

    public void setProgrammingLanguageId(Long programmingLanguageId) {
        this.programmingLanguageId = programmingLanguageId;
    }
}
