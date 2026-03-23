package com.ars.jobhijob.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ars.jobhijob.entity.Job;

@Repository
public interface JobRepository extends JpaRepository<Job, Integer>
{
	@Query("SELECT j FROM Job j WHERE j.company.com_id = :companyId")
    List<Job> findByCompanyId(@Param("companyId") int companyId);
}