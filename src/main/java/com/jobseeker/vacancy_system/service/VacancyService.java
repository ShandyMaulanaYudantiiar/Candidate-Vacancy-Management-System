package com.jobseeker.vacancy_system.service;

import com.jobseeker.vacancy_system.entity.Vacancy;
import com.jobseeker.vacancy_system.entity.criteria.*;
import com.jobseeker.vacancy_system.models.request.*;
import com.jobseeker.vacancy_system.models.response.VacancyResponse;
import com.jobseeker.vacancy_system.repository.VacancyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class VacancyService {
    private final VacancyRepository vacancyRepository;

    public VacancyResponse createVacancy(VacancyRequest req) {
        List<BaseCriteria> criteriaEntities = new ArrayList<>();
        for (BaseCriteriaRequest critReq : req.getCriteria()) {
            if (critReq instanceof AgeCriteriaRequest ageReq) {
                AgeCriteria crit = new AgeCriteria();
                crit.setMinAge(ageReq.getMinAge());
                crit.setMaxAge(ageReq.getMaxAge());
                crit.setWeight(ageReq.getWeight());
                criteriaEntities.add(crit);
            } else if (critReq instanceof GenderCriteriaRequest genderReq) {
                GenderCriteria crit = new GenderCriteria();
                crit.setGender(genderReq.getGender());
                crit.setWeight(genderReq.getWeight());
                criteriaEntities.add(crit);
            } else if (critReq instanceof SalaryRangeCriteriaRequest salaryReq) {
                SalaryRangeCriteria crit = new SalaryRangeCriteria();
                crit.setMinSalary(salaryReq.getMinSalary());
                crit.setMaxSalary(salaryReq.getMaxSalary());
                crit.setWeight(salaryReq.getWeight());
                criteriaEntities.add(crit);
            } else if (critReq instanceof LastEducationCriteriaRequest eduReq) {
                LastEducationCriteria crit = new LastEducationCriteria();
                crit.setEducation(eduReq.getEducation());
                crit.setWeight(eduReq.getWeight());
                criteriaEntities.add(crit);
            }
        }

        Vacancy vacancy = Vacancy.builder()
                .vacancy(req.getVacancy())
                .description(req.getDescription())
                .criteria(criteriaEntities)
                .build();
        vacancy = vacancyRepository.save(vacancy);

        VacancyResponse res = new VacancyResponse();
        res.setId(vacancy.getId());
        res.setVacancy(vacancy.getVacancy());
        res.setDescription(vacancy.getDescription());
        res.setCriteria((List<Object>) (List<?>) criteriaEntities);
        return res;
    }
    public List<VacancyResponse> getAll() {
        List<Vacancy> vacancies = vacancyRepository.findAll();

        return vacancies.stream().map(v -> {
            VacancyResponse res = new VacancyResponse();
            res.setId(v.getId());
            res.setVacancy(v.getVacancy());
            res.setDescription(v.getDescription());
            res.setCriteria((List<Object>) (List<?>) v.getCriteria());
            return res;
        }).toList();
    }

    public VacancyResponse getById(String id) {
        Vacancy v = vacancyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vacancy not found"));

        VacancyResponse res = new VacancyResponse();
        res.setId(v.getId());
        res.setVacancy(v.getVacancy());
        res.setDescription(v.getDescription());
        res.setCriteria((List<Object>) (List<?>) v.getCriteria());
        return res;
    }

    public VacancyResponse updateVacancy(String id, VacancyRequest req) {
        Vacancy v = vacancyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vacancy not found"));

        List<BaseCriteria> criteriaEntities = new ArrayList<>();
        for (BaseCriteriaRequest critReq : req.getCriteria()) {
            if (critReq instanceof AgeCriteriaRequest ageReq) {
                AgeCriteria crit = new AgeCriteria();
                crit.setMinAge(ageReq.getMinAge());
                crit.setMaxAge(ageReq.getMaxAge());
                crit.setWeight(ageReq.getWeight());
                criteriaEntities.add(crit);
            } else if (critReq instanceof GenderCriteriaRequest genderReq) {
                GenderCriteria crit = new GenderCriteria();
                crit.setGender(genderReq.getGender());
                crit.setWeight(genderReq.getWeight());
                criteriaEntities.add(crit);
            } else if (critReq instanceof SalaryRangeCriteriaRequest salaryReq) {
                SalaryRangeCriteria crit = new SalaryRangeCriteria();
                crit.setMinSalary(salaryReq.getMinSalary());
                crit.setMaxSalary(salaryReq.getMaxSalary());
                crit.setWeight(salaryReq.getWeight());
                criteriaEntities.add(crit);
            } else if (critReq instanceof LastEducationCriteriaRequest eduReq) {
                LastEducationCriteria crit = new LastEducationCriteria();
                crit.setEducation(eduReq.getEducation());
                crit.setWeight(eduReq.getWeight());
                criteriaEntities.add(crit);
            }
        }

        v.setVacancy(req.getVacancy());
        v.setDescription(req.getDescription());
        v.setCriteria(criteriaEntities);
        v = vacancyRepository.save(v);

        VacancyResponse res = new VacancyResponse();
        res.setId(v.getId());
        res.setVacancy(v.getVacancy());
        res.setDescription(v.getDescription());
        res.setCriteria((List<Object>) (List<?>) criteriaEntities);
        return res;
    }

    public void deleteVacancy(String id) {
        Vacancy v = vacancyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vacancy not found"));
        vacancyRepository.delete(v);
    }

}
