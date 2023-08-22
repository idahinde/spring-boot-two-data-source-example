package com.organization.test;

import com.organization.OrganizationProjectApplication;
import com.organization.controller.AddOrganizationDetailsController;
import com.organization.employee.entity.JobDetails;
import com.organization.project.entity.ProjectDetails;
import com.organization.response.RequestData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = OrganizationProjectApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AddOrganizationRecordTest {

    @LocalServerPort
    private int port;

    @Autowired
    private AddOrganizationDetailsController addOrganizationDetailsController;


    @Test
    public void addOrganizationDetails() {

        List<ProjectDetails> projectDetailsList = new ArrayList<>();
        List<JobDetails> jobDetailsList = new ArrayList<>();

        RequestData requestData = new RequestData();
        requestData.setEmpFirstName("Anil");
        requestData.setEmpLastName("Kumar");
        requestData.setEmpAddress("10 Crecent street Nellero");
        requestData.setEmpSalary(34992.2);
        requestData.setEmpDepartment("Account");
        requestData.setEmpLocation("Mumbai");


        requestData.setJobDetails(jobDetailsList);
    }

}
