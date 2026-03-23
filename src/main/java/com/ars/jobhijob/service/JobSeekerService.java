package com.ars.jobhijob.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ars.jobhijob.entity.JobSeeker;
import com.ars.jobhijob.repository.JobSeekerRepository;

@Service
public class JobSeekerService 
{
	@Autowired
	public JobSeekerRepository repo;
	public JobSeeker save(JobSeeker jobSeeker)
	{
	    return repo.save(jobSeeker);
	}

	public JobSeeker getByUser(int userId)
	{
	    return repo.findByUser_Id(userId);
	}

	public JobSeeker update(JobSeeker jobSeeker)
	{
	    return repo.save(jobSeeker);
	}
}
