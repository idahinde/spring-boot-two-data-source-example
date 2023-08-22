package com.organization.employee.entity;

import lombok.Data;

import javax.persistence.Embeddable;

@Data
@Embeddable
public class Dependents {
    private String dependentName;
    private String dependentRelationship;
    private String dependentDOB;
}
