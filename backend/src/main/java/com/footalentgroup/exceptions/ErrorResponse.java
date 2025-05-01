package com.footalentgroup.exceptions;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorResponse {
    private String error;
    private String message;
    private Integer code;
    private List<String> details;

    public ErrorResponse(Exception ex, Integer code) {
        this.error = ex.getClass().getSimpleName();
        this.message = ex.getMessage();
        this.code = code;
        this.details = null;
    }

    public ErrorResponse(String error, String message, Integer code) {
        this.error = error;
        this.message = message;
        this.code = code;
        this.details = null;
    }

    public ErrorResponse(String error, String message, Integer code, List<String> details) {
        this.error = error;
        this.message = message;
        this.code = code;
        this.details = details;
    }
}
