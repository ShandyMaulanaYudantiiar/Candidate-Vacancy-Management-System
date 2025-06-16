package com.jobseeker.vacancy_system.controller;

import com.jobseeker.vacancy_system.models.request.CandidateRequest;
import com.jobseeker.vacancy_system.models.response.CandidateResponse;
import com.jobseeker.vacancy_system.models.response.WebResponse;
import com.jobseeker.vacancy_system.service.CandidateService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/candidates")
@RequiredArgsConstructor
public class CandidateController {

    private final CandidateService candidateService;

    @PostMapping
    public WebResponse<CandidateResponse> create(@RequestBody @Valid CandidateRequest request) {
        CandidateResponse result = candidateService.createCandidate(request);
        return new WebResponse<>(201, "success", "Candidate created", result);
    }

    @GetMapping
    public WebResponse<List<CandidateResponse>> getAll() {
        List<CandidateResponse> result = candidateService.getAll();
        return new WebResponse<>(200, "success", "List of candidates", result);
    }

    @GetMapping("/{id}")
    public WebResponse<CandidateResponse> getById(@PathVariable String id) {
        CandidateResponse result = candidateService.getById(id);
        return new WebResponse<>(200, "success", "Candidate detail", result);
    }

    @PutMapping("/{id}")
    public WebResponse<CandidateResponse> update(
            @PathVariable String id,
            @RequestBody @Valid CandidateRequest request
    ) {
        CandidateResponse result = candidateService.updateCandidate(id, request);
        return new WebResponse<>(200, "success", "Candidate updated", result);
    }

    @DeleteMapping("/{id}")
    public WebResponse<String> delete(@PathVariable String id) {
        candidateService.deleteCandidate(id);
        return new WebResponse<>(200, "success", "Candidate deleted", null);
    }

}
