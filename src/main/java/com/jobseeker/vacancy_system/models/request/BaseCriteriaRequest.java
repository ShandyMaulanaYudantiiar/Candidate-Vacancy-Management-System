package com.jobseeker.vacancy_system.models.request;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Data;

@Data
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        property = "type",
        visible = true
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = AgeCriteriaRequest.class, name = "AGE"),
        @JsonSubTypes.Type(value = GenderCriteriaRequest.class, name = "GENDER"),
        @JsonSubTypes.Type(value = SalaryRangeCriteriaRequest.class, name = "SALARY"),
        @JsonSubTypes.Type(value = LastEducationCriteriaRequest.class, name = "EDUCATION")
})
public abstract class BaseCriteriaRequest {
    private String type; // wajib agar Jackson tahu field ini
    private int weight = 1;
}
