package com.jobseeker.vacancy_system.controller;

import com.jobseeker.vacancy_system.models.response.RankingResponse;
import com.jobseeker.vacancy_system.models.response.WebResponse;
import com.jobseeker.vacancy_system.service.RankingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rankings")
@RequiredArgsConstructor
public class RankingController {

    private final RankingService rankingService;

    @GetMapping("/{vacancyId}")
    public WebResponse<List<RankingResponse>> rankCandidates(@PathVariable String vacancyId) {
        List<RankingResponse> result = rankingService.rankCandidates(vacancyId);
        return new WebResponse<>(200, "success", "Ranking result", result);
    }
}
