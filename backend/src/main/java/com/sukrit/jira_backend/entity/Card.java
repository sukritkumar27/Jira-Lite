package com.sukrit.jira_backend.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Data
@Table(name = "cards")
public class Card {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "list_id")
    private List list;

    private String title;
    private String description;

    @ManyToOne @JoinColumn(name = "assigned_to_user_id")
    private User assignedTo;

    @ManyToOne(optional = false)
    @JoinColumn(name = "created_by_user_id")
    private User createdBy;

    @ManyToOne @JoinColumn(name = "supervisor_id")
    private User supervisor;

    private LocalDate dueDate;
    private Short priority;
    private Integer position;

    @Column(nullable = false, updatable = false)
    private Instant createdAt;

    @Column(nullable = false)
    private Instant updatedAt;

    @OneToMany(mappedBy = "card")
    private Set<Comment> comments;
}
