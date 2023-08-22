package com.organization.project.dao;

import com.organization.project.entity.ProjectDetails;
import com.organization.project.repository.ProjectDetailsRepository;
import com.organization.project.service.ProjectDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectDetailsServiceDao implements ProjectDetailsService {

    @Autowired
    private ProjectDetailsRepository repository;

    @Override
    public void save(ProjectDetails projectDetails) {
        this.save(projectDetails);
    }

    @Override
    public ProjectDetails findProjectDetails(int jodId) {
        return this.repository.findById(jodId).get();
    }

    @Override
    public List<ProjectDetails> getProjectDetailsList(int jodId) {
        return this.repository.findByJodId(jodId);
    }

}
