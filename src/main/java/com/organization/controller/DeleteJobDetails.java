package com.organization.controller;

import com.organization.employee.service.JobDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeleteJobDetails {

    @Autowired
    private JobDetailsService detailsService;

    @PutMapping("/deleteJobDetails")
    public ResponseEntity<?> deleteJobDetails(@RequestParam("empId") int id) {
        detailsService.deleteJobDetails(id);
        return ResponseEntity.ok("Delete Successful");
    }

}
