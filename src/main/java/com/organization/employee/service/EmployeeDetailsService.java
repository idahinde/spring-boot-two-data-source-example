package com.organization.employee.service;

import com.organization.employee.entity.EmployeeDetails;

public interface EmployeeDetailsService {

    void save(EmployeeDetails employeeDetails);

    EmployeeDetails findByEmpEmail(String empEmail);
}
