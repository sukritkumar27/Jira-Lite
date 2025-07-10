package com.sukrit.jira_backend.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.Instant;


@Entity
@Data
@Table(name = "comments")
public class Comment {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "card_id")
    private Card card;

    @ManyToOne(optional = false)
    @JoinColumn(name = "author_user_id")
    private User author;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false, updatable = false)
    private Instant createdAt;
}
