package com.sukrit.jira_backend.dto.user;

import jakarta.persistence.Column;
import lombok.Data;

import java.time.Instant;

@Data
public class UserDto {
    private Long id;

    private String name;

    private String email;

    private String phoneNumber;

    private String passwordHash;

    private String status;

    private Instant createdAt;

    private Instant updatedAt;
}
