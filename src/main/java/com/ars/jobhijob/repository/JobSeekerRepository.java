package com.ars.jobhijob.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ars.jobhijob.entity.JobSeeker;

@Repository
public interface JobSeekerRepository extends JpaRepository<JobSeeker, Integer>
{
    JobSeeker findByUser_Id(int userId);
}