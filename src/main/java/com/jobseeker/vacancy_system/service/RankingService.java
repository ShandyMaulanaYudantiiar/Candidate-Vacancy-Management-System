package com.jobseeker.vacancy_system.service;

import com.jobseeker.vacancy_system.entity.Candidate;
import com.jobseeker.vacancy_system.entity.Vacancy;
import com.jobseeker.vacancy_system.entity.criteria.*;
import com.jobseeker.vacancy_system.enums.Gender;
import com.jobseeker.vacancy_system.models.response.RankingResponse;
import com.jobseeker.vacancy_system.repository.CandidateRepository;
import com.jobseeker.vacancy_system.repository.VacancyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RankingService {

    private final VacancyRepository vacancyRepository;
    private final CandidateRepository candidateRepository;

    public List<RankingResponse> rankCandidates(String vacancyId) {
        Vacancy vacancy = vacancyRepository.findById(vacancyId)
                .orElseThrow(() -> new RuntimeException("Vacancy not found"));

        List<Candidate> candidates = candidateRepository.findAll(PageRequest.of(0, 1000)).getContent();

        return candidates.parallelStream().map(c -> {
            int score = 0;

            for (BaseCriteria crit : vacancy.getCriteria()) {
                if (crit instanceof AgeCriteria age) {
                    int ageCandidate = Period.between(c.getBirthDate(), LocalDate.now()).getYears();
                    if (ageCandidate >= age.getMinAge() && ageCandidate <= age.getMaxAge()) {
                        score += age.getWeight();
                    }
                } else if (crit instanceof GenderCriteria gender) {
                    if (gender.getGender() == Gender.ANY || gender.getGender() == c.getGender()) {
                        score += gender.getWeight();
                    }
                } else if (crit instanceof SalaryRangeCriteria sal) {
                    if (c.getCurrentSalary() >= sal.getMinSalary() && c.getCurrentSalary() <= sal.getMaxSalary()) {
                        score += sal.getWeight();
                    }
                } else if (crit instanceof LastEducationCriteria edu) {
                    if (c.getLastEducation() == edu.getEducation()) {
                        score += edu.getWeight();
                    }
                }
            }

            RankingResponse res = new RankingResponse();
            res.setCandidateId(c.getId());
            res.setName(c.getName());
            res.setEmail(c.getEmail());
            res.setScore(score);
            return res;

        }).sorted(Comparator.comparingInt(RankingResponse::getScore).reversed()).toList();
    }
}