package com.ars.jobhijob.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="jobseeker")
public class JobSeeker 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int js_id;
	
	@Column(name="js_name")
	private String name;

	@Column(name="js_email")
	private String email;

	@Column(name="js_phone_no")
	private String phone_no;

	@Column(name="js_skills")
	private String skills;

	@Column(name="js_experience")
	private int experience;
	
	@OneToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public void setJs_id(int js_id) {
		this.js_id = js_id;
	}
	public int getJs_id() {
		return js_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone_no() {
		return phone_no;
	}
	public void setPhone_no(String phone_no) {
		this.phone_no = phone_no;
	}
	public String getSkills() {
		return skills;
	}
	public void setSkills(String skills) {
		this.skills = skills;
	}
	public int getExperience() {
		return experience;
	}
	public void setExperience(int experience) {
		this.experience = experience;
	}
	
	
}
