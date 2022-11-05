package com.kodlama.kodlamaio.services.programmingLanguage.queries;

public class GetProgrammingLanguageByNameDto {
    private Long id;
    private String name;

    public GetProgrammingLanguageByNameDto(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public GetProgrammingLanguageByNameDto(){

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
}
