package com.jobseeker.vacancy_system.models.response;

import lombok.Data;

import java.util.List;

@Data
public class VacancyResponse {
    private String id;
    private String vacancy;
    private String description;
    private List<Object> criteria; // Map as needed for response, or make specific response DTO
}
