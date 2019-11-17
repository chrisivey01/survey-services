package com.gta.pmasurveyservices.repository;

import com.gta.pmasurveyservices.entity.Survey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SurveyRepository extends JpaRepository<Survey, Integer> {
    List<Survey> findAll();
    void deleteById(int id);

}
