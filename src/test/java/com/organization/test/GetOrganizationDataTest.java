package com.organization.test;

import com.organization.OrganizationProjectApplication;
import com.organization.controller.GetOrganizationDetailsController;
import com.organization.controller.GetRoleDetailsController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = OrganizationProjectApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class GetOrganizationDataTest {

    @LocalServerPort
    private int port;

    @Autowired
    private GetRoleDetailsController getRoleDetailsController;

    @Autowired
    private GetOrganizationDetailsController getOrganizationDetailsController;

    @Test
    public void getRoleDetails() throws Exception {
        ResponseEntity<?> responseEntity = getRoleDetailsController.getRoleDetails("abcsrefda@gmail.com");
        System.out.println(responseEntity.getBody());
    }

    @Test
    public void getOrganizationDetails() throws Exception {
        ResponseEntity<?> responseEntity = getOrganizationDetailsController.getOrganizationDetails("abcsrefda@gmail.com");
        System.out.println(responseEntity.getBody());
    }

}
