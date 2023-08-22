package com.organization.employee.service;

import com.organization.employee.entity.EmployeeDetails;
import com.organization.employee.entity.JobDetails;

import java.util.List;

public interface JobDetailsService {

    void save(JobDetails jobDetails);

    List<JobDetails> getEmployeeDetails(EmployeeDetails employeeDetails);

    int getJobId(String empEmail);

    void deleteJobDetails(int id);

}
