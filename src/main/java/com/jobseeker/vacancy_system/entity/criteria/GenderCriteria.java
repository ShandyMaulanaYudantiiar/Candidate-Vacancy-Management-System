package com.jobseeker.vacancy_system.entity.criteria;

import com.jobseeker.vacancy_system.enums.Gender;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class GenderCriteria extends BaseCriteria {
    private Gender gender;

    public GenderCriteria() {
        setType("GENDER");
    }
}
