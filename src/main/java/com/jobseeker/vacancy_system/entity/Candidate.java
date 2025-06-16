package com.jobseeker.vacancy_system.entity;

import com.jobseeker.vacancy_system.enums.Gender;
import com.jobseeker.vacancy_system.enums.LastEducation;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Getter @Setter @Builder
@NoArgsConstructor @AllArgsConstructor
@Document("candidates")
public class Candidate {
    @Id
    private String id;
    private String name;
    private String email;
    private String placeOfBirth;
    private LocalDate birthDate;
    private Gender gender;
    private Integer currentSalary;
    private Integer expectedSalary;
    private LastEducation lastEducation;
}