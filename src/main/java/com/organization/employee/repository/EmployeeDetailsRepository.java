package com.organization.employee.repository;

import com.organization.employee.entity.EmployeeDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeDetailsRepository extends JpaRepository<EmployeeDetails, Integer> {

    EmployeeDetails findByEmpEmail(String empEmail);
}
