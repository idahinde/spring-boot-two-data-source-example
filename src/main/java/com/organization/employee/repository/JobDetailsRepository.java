package com.organization.employee.repository;

import com.organization.employee.entity.EmployeeDetails;
import com.organization.employee.entity.JobDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobDetailsRepository extends JpaRepository<JobDetails, Integer> {

    List<JobDetails> findByEmployeeDetails(EmployeeDetails employeeDetails);
}
