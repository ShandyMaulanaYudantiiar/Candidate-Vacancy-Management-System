package com.jobseeker.vacancy_system.models.request;

import com.jobseeker.vacancy_system.enums.Gender;
import lombok.Data;

@Data
public class GenderCriteriaRequest extends BaseCriteriaRequest {
    private Gender gender;
}
