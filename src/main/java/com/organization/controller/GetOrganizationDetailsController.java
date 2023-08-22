package com.organization.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.organization.employee.entity.EmployeeDetails;
import com.organization.employee.entity.JobDetails;
import com.organization.employee.service.EmployeeDetailsService;
import com.organization.employee.service.JobDetailsService;
import com.organization.project.service.ProjectDetailsService;
import com.organization.project.service.RolesService;
import com.organization.response.RequestData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

@RestController
public class GetOrganizationDetailsController {

    @Autowired
    private RolesService rolesService;

    @Autowired
    private JobDetailsService jobDetailsService;

    @Autowired
    private ProjectDetailsService projectDetailsService;

    @Autowired
    private EmployeeDetailsService employeeDetailsService;

    @GetMapping(value = "/getOrganizationDetails", produces = "application/json")
    public ResponseEntity<?> getOrganizationDetails(@RequestParam("empEmail") String email) throws Exception {

        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        EmployeeDetails employeeDetails = employeeDetailsService.findByEmpEmail(email);
        RequestData requestData = RequestData.build(employeeDetails);

        var jobDetailList = jobDetailsService.getEmployeeDetails(employeeDetails);
        for (JobDetails jobDetails : jobDetailList) {
            var projectDetails =
                    projectDetailsService.getProjectDetailsList(jobDetails.getJodId()).stream().map(m -> {
                        m.setRoles(rolesService.getRoles(m));
                        return m;
                    }).collect(Collectors.toList());
            //jobDetails.setProjectDetails(projectDetails);
        }

        requestData.setJobDetails(jobDetailList);
        String json = mapper.writeValueAsString(requestData);

        return ResponseEntity.ok(json);
    }

}
