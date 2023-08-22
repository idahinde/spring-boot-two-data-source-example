package com.organization.employee.dao;

import com.organization.employee.entity.EmployeeDetails;
import com.organization.employee.repository.EmployeeDetailsRepository;
import com.organization.employee.service.EmployeeDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeDetailsServiceDao implements EmployeeDetailsService {

    @Autowired
    private EmployeeDetailsRepository employeeDetailsRepository;
    
    @Override
    public void save(EmployeeDetails employeeDetails) {
        this.employeeDetailsRepository.save(employeeDetails);
    }

    @Override
    public EmployeeDetails findByEmpEmail(String empEmail) {
        return this.employeeDetailsRepository.findByEmpEmail(empEmail);
    }

}
