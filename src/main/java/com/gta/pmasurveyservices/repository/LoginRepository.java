package com.gta.pmasurveyservices.repository;

import com.gta.pmasurveyservices.entity.Login;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepository extends JpaRepository<Login, Integer> {
}
