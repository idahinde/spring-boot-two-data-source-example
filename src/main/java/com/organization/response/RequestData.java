package com.organization.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.organization.employee.entity.EmployeeDetails;
import com.organization.employee.entity.JobDetails;
import lombok.Data;

import java.util.List;

@Data
public class RequestData {
    private String empEmail;
    private String empFirstName;
    private String empLastName;
    private String empAddress;
    private Double empSalary;
    private String empDepartment;
    private String empLocation;
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private List<JobDetails> jobDetails;

    public static RequestData build(EmployeeDetails details) {
        RequestData data = new RequestData();
        data.setEmpFirstName(details.getEmpFirstName());
        data.setEmpLastName(details.getEmpLastName());
        data.setEmpAddress(details.getEmpAddress());
        data.setEmpSalary(details.getEmpSalary());
        data.setEmpDepartment(details.getEmpDepartment());
        data.setEmpEmail(details.getEmpEmail());
        data.setEmpLocation(details.getEmpLocation());
        return data;
    }
}
