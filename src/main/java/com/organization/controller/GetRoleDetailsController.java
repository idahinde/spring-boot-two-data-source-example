package com.organization.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.organization.employee.service.JobDetailsService;
import com.organization.project.entity.ProjectDetails;
import com.organization.project.service.ProjectDetailsService;
import com.organization.project.service.RolesService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
public class GetRoleDetailsController {

    private RolesService rolesService;
    private JobDetailsService jobDetailsService;
    private ProjectDetailsService projectDetailsService;

    @GetMapping(value = "/getRoleDetails", produces = "application/json")
    public ResponseEntity<?> getRoleDetails(@RequestParam("empEmail") String email) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        int jobId = jobDetailsService.getJobId(email);
        List<ProjectDetails> projectDetails = projectDetailsService.getProjectDetailsList(jobId);
        var projectData = projectDetails.stream().map(m -> {
            m.setRoles(rolesService.getRoles(m));
            return m;
        }).collect(Collectors.toList());

        String json = mapper.writeValueAsString(projectData);
        return ResponseEntity.ok(json);
    }

}
