package com.jobseeker.vacancy_system.models.request;

import lombok.Data;

@Data
public class SalaryRangeCriteriaRequest extends BaseCriteriaRequest {
    private int minSalary;
    private int maxSalary;
}
