package com.kodlama.kodlamaio.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "programming_languages")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ProgrammingLanguage extends BaseEntity {
    @Column(name = "name")
    private String name;

    public ProgrammingLanguage(){

    }
    public ProgrammingLanguage(Long id,String name) {
        super(id);
        this.name = name;
    }
    public ProgrammingLanguage(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @JsonIgnore
    @OneToMany(mappedBy = "programmingLanguage",fetch = FetchType.EAGER,cascade = CascadeType.DETACH)
    private List<Technology> technologies;
}
