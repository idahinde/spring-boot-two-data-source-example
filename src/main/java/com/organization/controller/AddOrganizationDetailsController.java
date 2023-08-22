package com.organization.controller;

import com.organization.employee.entity.EmployeeDetails;
import com.organization.employee.entity.JobDetails;
import com.organization.employee.service.EmployeeDetailsService;
import com.organization.employee.service.JobDetailsService;
import com.organization.project.entity.ProjectDetails;
import com.organization.project.entity.Roles;
import com.organization.project.service.ProjectDetailsService;
import com.organization.project.service.RolesService;
import com.organization.response.RequestData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class AddOrganizationDetailsController {

    @Autowired
    private RolesService rolesService;

    @Autowired
    private JobDetailsService jobDetailsService;

    @Autowired
    private ProjectDetailsService projectDetailsService;

    @Autowired
    private EmployeeDetailsService employeeDetailsService;

    @PostMapping(value = "/addOrganizationDetails")
    public ResponseEntity<Map<String, Object>> addOrganizationDetails(@RequestBody RequestData requestData) {

        EmployeeDetails employeeDetails = EmployeeDetails.build(requestData);
        employeeDetailsService.save(employeeDetails);
        for (JobDetails jobDetails : requestData.getJobDetails()) {
            jobDetails.setEmployeeDetails(employeeDetails);
            jobDetailsService.save(jobDetails);
        }

        return ResponseEntity.ok(Map.of("message", "Organization Details Added"));
    }

}
