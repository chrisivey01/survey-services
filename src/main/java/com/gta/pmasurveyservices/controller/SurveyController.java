package com.gta.pmasurveyservices.controller;

import com.gta.pmasurveyservices.entity.Login;
import com.gta.pmasurveyservices.entity.Survey;
import com.gta.pmasurveyservices.repository.LoginRepository;
import com.gta.pmasurveyservices.repository.SurveyRepository;
import com.gta.pmasurveyservices.request.SurveyRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@CrossOrigin
public class SurveyController {

    private SurveyRepository surveyRepository;
    private LoginRepository loginRepository;

    @Autowired
    public SurveyController(SurveyRepository surveyRepository, LoginRepository loginRepository){
        this.surveyRepository = surveyRepository;
        this.loginRepository = loginRepository;

    }

    @PostMapping("/input-survey")
    public void inputSurvey(@RequestBody Survey survey){
        surveyRepository.save(survey);
    }

    @GetMapping("/show-survey")
    public List<Survey> getSurvey(){
        return surveyRepository.findAll();
    }

    @Transactional
    @PostMapping("/delete-survey")
    public void deleteSurvey(@RequestBody List<Survey> survey){
        for(Survey item : survey) {
            surveyRepository.deleteById(item.getId());
        }
    }

    @PostMapping("/login-info")
    public String loginSurvey(@RequestBody Login login){
        List<Login> attempt = loginRepository.findAll();

        if(login.getPassword().equals(attempt.get(0).getPassword()) && login.getUsername().equals(attempt.get(0).getUsername())){
            return "Login Successful!";
        }else{
            return "Login failed.";
        }
    }
}
