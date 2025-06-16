package com.jobseeker.vacancy_system.models.request;

import com.jobseeker.vacancy_system.enums.Gender;
import com.jobseeker.vacancy_system.enums.LastEducation;
import jakarta.validation.constraints.*;

import lombok.Data;
import java.time.LocalDate;

@Data
public class CandidateRequest {
    @NotBlank
    @Pattern(regexp = "^[A-Za-z ]+$", message = "Name must only contain letters and spaces")
    private String name;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    @Pattern(regexp = "^[A-Za-z ]+$", message = "Place of birth must only contain letters and spaces")
    private String placeOfBirth;

    @NotNull
    private LocalDate birthDate;

    @NotNull
    private Gender gender;

    @NotNull
    @PositiveOrZero
    private Integer currentSalary;

    @NotNull
    @PositiveOrZero
    private Integer expectedSalary;

    @NotNull
    private LastEducation lastEducation;
}
