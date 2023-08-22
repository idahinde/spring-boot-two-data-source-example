package com.organization.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class UpdateEmployeeProjectDetails {

    @PutMapping("/updateEmployeeProjectDetails")
    public ResponseEntity<?> updateEmployeeProjectDetails() {
        return ResponseEntity.ok("");
    }

}
