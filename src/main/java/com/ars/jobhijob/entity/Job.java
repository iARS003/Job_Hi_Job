package com.ars.jobhijob.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="job")
public class Job 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int job_id;
	
	@Column(name="job_title")
	private String title;
	
	@Column(name="job_skill_req")
	private String skill_required;
	
	@Column(name="job_salary")
	private int salary;
	
	@ManyToOne
    @JoinColumn(name = "job_com_id")
	private Company company;

	public int getJob_id() {
		return job_id;
	}

	public void setJob_id(int job_id) {
		this.job_id = job_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSkill_required() {
		return skill_required;
	}

	public void setSkill_required(String skill_required) {
		this.skill_required = skill_required;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}
	
	
}
