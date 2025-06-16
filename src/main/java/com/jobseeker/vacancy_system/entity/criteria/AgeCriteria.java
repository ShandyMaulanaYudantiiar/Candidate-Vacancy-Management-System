package com.jobseeker.vacancy_system.entity.criteria;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class AgeCriteria extends BaseCriteria {
    private int minAge;
    private int maxAge;

    public AgeCriteria() {
        setType("AGE");
    }
}