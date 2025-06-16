package com.jobseeker.vacancy_system.models.request;

import com.jobseeker.vacancy_system.enums.LastEducation;
import lombok.Data;

@Data
public class LastEducationCriteriaRequest extends BaseCriteriaRequest {
    private LastEducation education;
}
