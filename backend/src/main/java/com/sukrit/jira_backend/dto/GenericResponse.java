package com.sukrit.jira_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class GenericResponse<T> {
    private boolean success;
    private String message;
    private T data;

    public GenericResponse(T data) {
        this.success = true;
        this.data = data;
    }
}
