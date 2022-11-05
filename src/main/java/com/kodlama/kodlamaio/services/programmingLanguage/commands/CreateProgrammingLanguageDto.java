package com.kodlama.kodlamaio.services.programmingLanguage.commands;

public class CreateProgrammingLanguageDto {
    private Long id;
    private String name;

    public CreateProgrammingLanguageDto(Long id, String name) {
        this.name = name;
        this.id = id;
    }
    public CreateProgrammingLanguageDto(){}
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
