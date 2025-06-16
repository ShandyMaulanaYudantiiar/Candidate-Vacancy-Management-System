package com.jobseeker.vacancy_system.controller;

import com.jobseeker.vacancy_system.models.request.VacancyRequest;
import com.jobseeker.vacancy_system.models.response.VacancyResponse;
import com.jobseeker.vacancy_system.models.response.WebResponse;
import com.jobseeker.vacancy_system.service.VacancyService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vacancies")
@RequiredArgsConstructor
public class VacancyController {

    private final VacancyService vacancyService;

    @PostMapping
    public WebResponse<VacancyResponse> create(@RequestBody @Valid VacancyRequest request) {
        VacancyResponse result = vacancyService.createVacancy(request);
        return new WebResponse<>(201, "success", "Vacancy created", result);
    }

    @GetMapping
    public WebResponse<List<VacancyResponse>> getAll() {
        List<VacancyResponse> result = vacancyService.getAll();
        return new WebResponse<>(200, "success", "List of vacancies", result);
    }

    @GetMapping("/{id}")
    public WebResponse<VacancyResponse> getById(@PathVariable String id) {
        VacancyResponse result = vacancyService.getById(id);
        return new WebResponse<>(200, "success", "Vacancy detail", result);
    }

    @PutMapping("/{id}")
    public WebResponse<VacancyResponse> update(@PathVariable String id, @RequestBody @Valid VacancyRequest request) {
        VacancyResponse result = vacancyService.updateVacancy(id, request);
        return new WebResponse<>(200, "success", "Vacancy updated", result);
    }

    @DeleteMapping("/{id}")
    public WebResponse<String> delete(@PathVariable String id) {
        vacancyService.deleteVacancy(id);
        return new WebResponse<>(200, "success", "Vacancy deleted", null);
    }

}
