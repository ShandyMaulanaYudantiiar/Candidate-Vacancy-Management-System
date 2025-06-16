package com.jobseeker.vacancy_system.repository;

import com.jobseeker.vacancy_system.entity.Vacancy;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface VacancyRepository extends MongoRepository<Vacancy, String> {
}
