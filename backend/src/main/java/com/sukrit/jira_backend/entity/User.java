package com.sukrit.jira_backend.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.Instant;
import java.util.Set;

@Entity
@Data
@Table(name = "users")
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(unique = true, nullable = false)
    private String email;

    private String phoneNumber;

    @Column(nullable = false)
    private String passwordHash;

    @Column(nullable = false)
    private String status;

    @Column(nullable = false, updatable = false)
    private Instant createdAt;

    @Column(nullable = false)
    private Instant updatedAt;

    @OneToMany(mappedBy = "owner")
    private Set<Board> ownedBoards;

    @OneToMany(mappedBy = "assignedTo")
    private Set<Card> assignedCards;

    @OneToMany(mappedBy = "createdBy")
    private Set<Card> createdCards;

    @OneToMany(mappedBy = "supervisor")
    private Set<Card> supervisedCards;

    @OneToMany(mappedBy = "author")
    private Set<Comment> comments;

}
