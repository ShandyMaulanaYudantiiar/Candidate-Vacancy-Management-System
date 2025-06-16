package com.jobseeker.vacancy_system.repository;

import com.jobseeker.vacancy_system.entity.Candidate;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface CandidateRepository extends MongoRepository<Candidate, String> {
    Optional<Candidate> findByEmail(String email);
    boolean existsByEmail(String email);
}
