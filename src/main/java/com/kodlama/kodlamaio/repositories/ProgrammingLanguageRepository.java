package com.kodlama.kodlamaio.repositories;

import com.kodlama.kodlamaio.models.ProgrammingLanguage;
import com.kodlama.kodlamaio.services.programmingLanguage.queries.GetProgrammingLanguagesWithTechnologyDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProgrammingLanguageRepository extends JpaRepository<ProgrammingLanguage,Long> {
    @Query("select p from ProgrammingLanguage p where p.name = ?1")
    ProgrammingLanguage findProgrammingLanguageByName(String name);

    @Query(value = "Select * from programming_languages p inner join technologies t on p.id = t.programming_language_id where p.id = 3",nativeQuery = true)
    List<GetProgrammingLanguagesWithTechnologyDto> testquery();

}
