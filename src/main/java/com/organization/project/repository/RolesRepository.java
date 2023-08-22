package com.organization.project.repository;

import com.organization.project.entity.ProjectDetails;
import com.organization.project.entity.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RolesRepository extends JpaRepository<Roles, Integer> {

    List<Roles> findByProjectDetails(ProjectDetails projectDetails);
}
