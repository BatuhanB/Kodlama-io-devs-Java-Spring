package com.kodlama.kodlamaio.repositories;

import com.kodlama.kodlamaio.models.Technology;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TechnologyRepository extends JpaRepository<Technology,Long> {
    @Query("select t from Technology t where t.name = ?1")
    Technology findTechnologyByName(String name);
}
