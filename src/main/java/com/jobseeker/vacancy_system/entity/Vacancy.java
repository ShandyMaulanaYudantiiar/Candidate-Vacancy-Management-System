package com.jobseeker.vacancy_system.entity;

import com.jobseeker.vacancy_system.entity.criteria.BaseCriteria;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter @Setter @Builder
@NoArgsConstructor @AllArgsConstructor
@Document("vacancies")
public class Vacancy {
    @Id
    private String id;
    private String vacancy;
    private String description;
    private List<BaseCriteria> criteria;
}