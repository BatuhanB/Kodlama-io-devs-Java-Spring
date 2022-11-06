package com.kodlama.kodlamaio.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "technologies")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler","technologies"})
public class Technology extends BaseEntity {
    @Column(name = "name")
    private String name;

    public Technology(){}

    public Technology(Long id,String name) {
        super(id);
        this.name = name;
    }
    public Technology(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ProgrammingLanguage getProgrammingLanguage() {
        return programmingLanguage;
    }

    public void setProgrammingLanguage(ProgrammingLanguage programmingLanguage) {
        this.programmingLanguage = programmingLanguage;
    }

    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "programmingLanguageId")
    private ProgrammingLanguage programmingLanguage;
}
