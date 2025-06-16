package com.jobseeker.vacancy_system.models.response;

import lombok.Data;

@Data
public class RankingResponse {
    private String candidateId;
    private String name;
    private String email;
    private int score;
}
