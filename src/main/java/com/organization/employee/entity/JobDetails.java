package com.organization.employee.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "jobdetails")
public class JobDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer jodId;
    @JoinColumn(name = "empId", referencedColumnName = "empId")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE, targetEntity = EmployeeDetails.class)
    private EmployeeDetails employeeDetails;
    @Embedded
    private Dependents dependents;
}
