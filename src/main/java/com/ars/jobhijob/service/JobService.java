package com.ars.jobhijob.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ars.jobhijob.entity.Job;
import com.ars.jobhijob.repository.JobRepository;

@Service
public class JobService 
{
    @Autowired
    private JobRepository repo;

    public void saveJob(Job job)
    {
        repo.save(job);
    }
    public List<Job> getJobsByCompany(int companyId) {
        return repo.findByCompanyId(companyId);
    }
    public Job getJobById(int id)
    {
        return repo.findById(id).orElse(null);
    }

    public void deleteJob(int id)
    {
        repo.deleteById(id);
    }

    public void updateJob(Job job)
    {
        repo.save(job);
    }
    public List<Job> getAllJobs()
    {
        return repo.findAll();
    }
}