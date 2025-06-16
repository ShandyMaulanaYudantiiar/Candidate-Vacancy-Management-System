package com.jobseeker.vacancy_system.models.request;

import lombok.Data;

@Data
public class AgeCriteriaRequest extends BaseCriteriaRequest {
    private int minAge;
    private int maxAge;
}
