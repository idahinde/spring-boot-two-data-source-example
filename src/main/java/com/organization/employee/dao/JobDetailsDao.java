package com.organization.employee.dao;

import com.organization.employee.entity.EmployeeDetails;
import com.organization.employee.entity.JobDetails;
import com.organization.employee.repository.JobDetailsRepository;
import com.organization.employee.service.JobDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.Tuple;
import java.util.List;

@Service
@Transactional(transactionManager = "employeeTransactionManager")
public class JobDetailsDao implements JobDetailsService {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private JobDetailsRepository repository;

    @Override
    public void save(JobDetails jobDetails) {
        this.repository.save(jobDetails);
    }

    @Override
    public List<JobDetails> getEmployeeDetails(EmployeeDetails employeeDetails) {
        return this.repository.findByEmployeeDetails(employeeDetails);
    }

    @Override
    public int getJobId(String empEmail) {
        Query query = entityManager.createNativeQuery("select j.jodId as jobid from jobdetails j where j.employeeDetails.empEmail=?1", Tuple.class);
        query.setParameter(1, empEmail);
        Tuple tuple = (Tuple) query.getSingleResult();
        return Integer.parseInt(tuple.get("jobid").toString());
    }

    @Override
    public void deleteJobDetails(int id) {
        Query query = entityManager.createQuery("delete from jobdetails j where j.employeeDetails.empId=?1");
        query.setParameter(1, id);
        query.executeUpdate();
    }

}
