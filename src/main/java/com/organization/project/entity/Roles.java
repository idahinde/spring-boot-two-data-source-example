package com.organization.project.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "roles")
public class Roles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer roleId;
    private String roleName;
    private String roleDescription;
    @JsonIgnore
    @JoinColumn(name = "projectId", referencedColumnName = "projectId")
    @ManyToOne(targetEntity = ProjectDetails.class, cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    private ProjectDetails projectDetails;
}
