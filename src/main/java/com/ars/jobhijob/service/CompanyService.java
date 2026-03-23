package com.ars.jobhijob.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ars.jobhijob.entity.Company;
import com.ars.jobhijob.entity.User;
import com.ars.jobhijob.repository.CompanyRepository;

@Service
public class CompanyService 
{
	@Autowired 
	private CompanyRepository repo;
	
	public Company saveCompany(Company company)
    {
        return repo.save(company);
    }

    public Company getByUser(User user)
    {
        return repo.findByUser_Id(user.getId());
    }
    
    public Company getById(int id)
    {
        return repo.findById(id).orElse(null);
    }

    public Company updateCompany(Company company)
    {
        return repo.save(company);
    }
}
