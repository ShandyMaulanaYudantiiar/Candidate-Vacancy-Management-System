package com.jobseeker.vacancy_system.entity.criteria;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
public abstract class BaseCriteria {
    @Field("_type")
    private String type;
    private int weight = 1;
}
