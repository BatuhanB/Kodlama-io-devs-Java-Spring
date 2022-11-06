package com.kodlama.kodlamaio.services.technology.queries;

public class GetTechnologiesWithLanguages {

    private Long id;
    private String name;
    private String languageName;

    public GetTechnologiesWithLanguages(Long id, String name, String languageName) {
        this.id = id;
        this.name = name;
        this.languageName = languageName;
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

    public String getLanguageName() {
        return languageName;
    }

    public void setLanguageName(String languageName) {
        this.languageName = languageName;
    }
}
