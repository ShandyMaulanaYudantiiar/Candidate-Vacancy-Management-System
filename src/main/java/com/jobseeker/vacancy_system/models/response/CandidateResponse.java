package com.jobseeker.vacancy_system.models.response;

import com.jobseeker.vacancy_system.enums.Gender;
import com.jobseeker.vacancy_system.enums.LastEducation;
import lombok.Data;

import java.time.LocalDate;

@Data
public class CandidateResponse {
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
