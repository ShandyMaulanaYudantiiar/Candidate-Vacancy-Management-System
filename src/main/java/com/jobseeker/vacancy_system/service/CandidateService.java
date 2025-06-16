package com.jobseeker.vacancy_system.service;

import com.jobseeker.vacancy_system.entity.Candidate;
import com.jobseeker.vacancy_system.models.request.CandidateRequest;
import com.jobseeker.vacancy_system.models.response.CandidateResponse;
import com.jobseeker.vacancy_system.repository.CandidateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CandidateService {
    private final CandidateRepository candidateRepository;

    public CandidateResponse createCandidate(CandidateRequest req) {
        if (candidateRepository.existsByEmail(req.getEmail()))
            throw new RuntimeException("Email already exists");
        Candidate candidate = Candidate.builder()
                .name(req.getName())
                .email(req.getEmail())
                .placeOfBirth(req.getPlaceOfBirth())
                .birthDate(req.getBirthDate())
                .gender(req.getGender())
                .currentSalary(req.getCurrentSalary())
                .expectedSalary(req.getExpectedSalary())
                .lastEducation(req.getLastEducation())
                .build();
        candidate = candidateRepository.save(candidate);

        CandidateResponse res = new CandidateResponse();
        res.setId(candidate.getId());
        res.setName(candidate.getName());
        res.setEmail(candidate.getEmail());
        res.setPlaceOfBirth(candidate.getPlaceOfBirth());
        res.setBirthDate(candidate.getBirthDate());
        res.setGender(candidate.getGender());
        res.setCurrentSalary(candidate.getCurrentSalary());
        res.setExpectedSalary(candidate.getExpectedSalary());
        res.setLastEducation(candidate.getLastEducation());
        return res;
    }

    public List<CandidateResponse> getAll() {
        return candidateRepository.findAll().stream().map(candidate -> {
            CandidateResponse res = new CandidateResponse();
            res.setId(candidate.getId());
            res.setName(candidate.getName());
            res.setEmail(candidate.getEmail());
            res.setPlaceOfBirth(candidate.getPlaceOfBirth());
            res.setBirthDate(candidate.getBirthDate());
            res.setGender(candidate.getGender());
            res.setCurrentSalary(candidate.getCurrentSalary());
            res.setExpectedSalary(candidate.getExpectedSalary());
            res.setLastEducation(candidate.getLastEducation());
            return res;
        }).toList();
    }

    public CandidateResponse getById(String id) {
        Candidate candidate = candidateRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Candidate not found"));

        CandidateResponse res = new CandidateResponse();
        res.setId(candidate.getId());
        res.setName(candidate.getName());
        res.setEmail(candidate.getEmail());
        res.setPlaceOfBirth(candidate.getPlaceOfBirth());
        res.setBirthDate(candidate.getBirthDate());
        res.setGender(candidate.getGender());
        res.setCurrentSalary(candidate.getCurrentSalary());
        res.setExpectedSalary(candidate.getExpectedSalary());
        res.setLastEducation(candidate.getLastEducation());
        return res;
    }

    public CandidateResponse updateCandidate(String id, CandidateRequest req) {
        Candidate candidate = candidateRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Candidate not found"));

        candidate.setName(req.getName());
        candidate.setEmail(req.getEmail());
        candidate.setPlaceOfBirth(req.getPlaceOfBirth());
        candidate.setBirthDate(req.getBirthDate());
        candidate.setGender(req.getGender());
        candidate.setCurrentSalary(req.getCurrentSalary());
        candidate.setExpectedSalary(req.getExpectedSalary());
        candidate.setLastEducation(req.getLastEducation());

        candidate = candidateRepository.save(candidate);

        CandidateResponse res = new CandidateResponse();
        res.setId(candidate.getId());
        res.setName(candidate.getName());
        res.setEmail(candidate.getEmail());
        res.setPlaceOfBirth(candidate.getPlaceOfBirth());
        res.setBirthDate(candidate.getBirthDate());
        res.setGender(candidate.getGender());
        res.setCurrentSalary(candidate.getCurrentSalary());
        res.setExpectedSalary(candidate.getExpectedSalary());
        res.setLastEducation(candidate.getLastEducation());
        return res;
    }

    public void deleteCandidate(String id) {
        Candidate candidate = candidateRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Candidate not found"));
        candidateRepository.delete(candidate);
    }

}
