package com.organization.project.service;

import com.organization.project.entity.ProjectDetails;

import java.util.List;

public interface ProjectDetailsService {

    void save(ProjectDetails projectDetails);

    ProjectDetails findProjectDetails(int jodId);

    List<ProjectDetails> getProjectDetailsList(int jodId);
}
