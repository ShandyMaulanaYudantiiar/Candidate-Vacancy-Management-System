package com.jobseeker.vacancy_system.models.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

@Data
public class VacancyRequest {
    @NotBlank
    private String vacancy;

    @NotBlank
    private String description;

    @NotEmpty
    @Size(min = 1)
    private List<BaseCriteriaRequest> criteria;
}
