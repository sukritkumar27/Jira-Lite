package com.sukrit.jira_backend.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Entity
@Data
@Table(name = "board_users")
@IdClass(BoardUser.Id.class)
public class BoardUser {
    @jakarta.persistence.Id
    @ManyToOne
    @JoinColumn(name = "board_id")
    private Board board;

    @jakarta.persistence.Id
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(nullable = false)
    private String role;

    @Data
    public static class Id implements Serializable {
        private Long board;
        private Long user;
    }
}
