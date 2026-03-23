package com.ars.jobhijob.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ars.jobhijob.entity.Company;
import com.ars.jobhijob.entity.User;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Integer>
{
	Company findByUser_Id(int id);
}
