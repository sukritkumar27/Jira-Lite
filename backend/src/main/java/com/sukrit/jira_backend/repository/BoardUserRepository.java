package com.sukrit.jira_backend.repository;

import com.sukrit.jira_backend.entity.BoardUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardUserRepository extends JpaRepository<BoardUser, BoardUser.Id> {
}
