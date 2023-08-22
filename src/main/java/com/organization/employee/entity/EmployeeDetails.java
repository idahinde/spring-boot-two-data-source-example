package com.organization.employee.entity;

import com.organization.response.RequestData;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity(name = "employeedetails")
public class EmployeeDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer empId;
    private String empFirstName;
    private String empLastName;
    private String empEmail;
    private String empAddress;
    private Double empSalary;
    private String empDepartment;
    private String empLocation;
    @OneToMany
    private List<JobDetails> jobDetailsList;

    public static EmployeeDetails build(RequestData data) {
        EmployeeDetails details = new EmployeeDetails();
        details.setEmpFirstName(data.getEmpFirstName());
        details.setEmpLastName(data.getEmpLastName());
        details.setEmpEmail(data.getEmpEmail());
        details.setEmpAddress(data.getEmpAddress());
        details.setEmpSalary(data.getEmpSalary());
        details.setEmpDepartment(data.getEmpDepartment());
        details.setEmpLocation(data.getEmpLocation());
        return details;
    }
}
