package com.organization.controller;

import com.organization.project.entity.ProjectDetails;
import com.organization.project.service.ProjectDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UpdateProjectDetails {

    @Autowired
    private ProjectDetailsService projectDetailsService;

    @PutMapping("/updateProjectDetails")
    public ResponseEntity<?> updateProjectDetails(@RequestBody ProjectDetails projectDetails) {

        ProjectDetails details = projectDetailsService.findProjectDetails(projectDetails.getProjectId());
        details.setProjectName(projectDetails.getProjectName());
        details.setProjectNumber(projectDetails.getProjectNumber());
        details.setProjectLocation(projectDetails.getProjectLocation());

        projectDetailsService.save(details);
        return ResponseEntity.ok("Update Successful");
    }

}
