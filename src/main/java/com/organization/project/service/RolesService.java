package com.organization.project.service;

import com.organization.project.entity.ProjectDetails;
import com.organization.project.entity.Roles;

import java.util.List;

public interface RolesService {

    void save(Roles roles);

    List<Roles> getRoles(ProjectDetails projectDetails);
}
