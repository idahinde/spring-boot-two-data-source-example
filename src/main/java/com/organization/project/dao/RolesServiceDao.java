package com.organization.project.dao;

import com.organization.project.entity.ProjectDetails;
import com.organization.project.entity.Roles;
import com.organization.project.repository.RolesRepository;
import com.organization.project.service.RolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolesServiceDao implements RolesService {

    @Autowired
    private RolesRepository repository;

    @Override
    public void save(Roles roles) {
        this.repository.save(roles);
    }

    @Override
    public List<Roles> getRoles(ProjectDetails projectDetails) {
        return this.repository.findByProjectDetails(projectDetails);
    }

}
