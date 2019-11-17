package com.gta.pmasurveyservices.request;

import com.gta.pmasurveyservices.entity.Survey;

import java.util.ArrayList;
import java.util.List;

public class SurveyRequest {

    List<Survey> survey = new ArrayList<>();

    public List<Survey> getSurvey() {
        return survey;
    }

    public void setSurvey(List<Survey> survey) {
        this.survey = survey;
    }
}
