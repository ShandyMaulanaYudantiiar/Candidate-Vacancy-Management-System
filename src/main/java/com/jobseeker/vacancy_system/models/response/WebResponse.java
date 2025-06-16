package com.jobseeker.vacancy_system.models.response;

import lombok.Data;

@Data
public class WebResponse<T> {
    private int code;
    private String status;
    private String message;
    private T data;

    public WebResponse(int code, String status, String message, T data) {
        this.code = code;
        this.status = status;
        this.message = message;
        this.data = data;
    }
}
