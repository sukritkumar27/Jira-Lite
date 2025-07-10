package com.sukrit.jira_backend.repository;

import com.sukrit.jira_backend.entity.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ListRepository extends JpaRepository<List,Long> {
}
