package com.organization.project.repository;

import com.organization.project.entity.ProjectDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectDetailsRepository extends JpaRepository<ProjectDetails, Integer> {
    List<ProjectDetails> findByJodId(int jodId);
}
