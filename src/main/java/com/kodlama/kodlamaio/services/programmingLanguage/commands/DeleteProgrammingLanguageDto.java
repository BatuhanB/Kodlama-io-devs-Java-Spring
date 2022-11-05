package com.kodlama.kodlamaio.services.programmingLanguage.commands;

public class DeleteProgrammingLanguageDto {
    private Long id;

    public DeleteProgrammingLanguageDto(){

    }
    public DeleteProgrammingLanguageDto(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
