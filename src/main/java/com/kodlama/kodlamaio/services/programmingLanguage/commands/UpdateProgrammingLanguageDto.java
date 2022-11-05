package com.kodlama.kodlamaio.services.programmingLanguage.commands;

public class UpdateProgrammingLanguageDto {
    private String name;

    public UpdateProgrammingLanguageDto(){

    }

    public UpdateProgrammingLanguageDto(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
