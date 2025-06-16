package com.jobseeker.vacancy_system.entity.criteria;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class SalaryRangeCriteria extends BaseCriteria {
    private int minSalary;
    private int maxSalary;

    public SalaryRangeCriteria() {
        setType("SALARY_RANGE");
    }
}
