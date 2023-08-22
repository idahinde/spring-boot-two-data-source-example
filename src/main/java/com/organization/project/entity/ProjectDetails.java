package com.organization.project.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity(name = "projectdetails")
public class ProjectDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer projectId;
    private Integer jodId;
    private String projectName;
    private String projectNumber;
    private String projectLocation;
    @Transient
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private List<Roles> roles;
}
