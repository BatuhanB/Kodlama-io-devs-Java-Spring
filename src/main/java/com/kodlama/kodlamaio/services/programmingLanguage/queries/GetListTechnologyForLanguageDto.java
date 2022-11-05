package com.kodlama.kodlamaio.services.programmingLanguage.queries;

public class GetListTechnologyForLanguageDto {
    private String name;

    public GetListTechnologyForLanguageDto(){}
    public GetListTechnologyForLanguageDto( String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
