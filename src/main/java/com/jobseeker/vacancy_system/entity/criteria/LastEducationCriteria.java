package com.jobseeker.vacancy_system.entity.criteria;

import com.jobseeker.vacancy_system.enums.LastEducation;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class LastEducationCriteria extends BaseCriteria {
    private LastEducation education;

    public LastEducationCriteria() {
        setType("LAST_EDUCATION");
    }
}
