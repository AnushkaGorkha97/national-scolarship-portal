package com.lti.core.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity(name="industry")
@Table(name="IndustryTP10")
public class Industry {
	
	@Id
	@Column(name="INDUSTRY_CODE")
	private String industryCode;

	@Column(name="INDUSTRY_NAME")
	private String industryName;
	
	@Column(name="INDUSTRY_EMAIL")
	private String industryEmail;	
	
	@Column(name="INDUSTRY_MOBILE")
	private String industryMob;
	
	@Column(name="INDUSTRY_PASSWORD")
	private String industryPassword;	
	
	@Column(name="INDUSTRY_ADDRESS")
	private String industryAddress;
	
	@OneToMany(mappedBy="industryid")
	private List<Job> jobs;

	public String getIndustryCode() {
		return industryCode;
	}

	public void setIndustryCode(String industryCode) {
		this.industryCode = industryCode;
	}

	public String getIndustryName() {
		return industryName;
	}

	public void setIndustryName(String industryName) {
		this.industryName = industryName;
	}

	public String getIndustryEmail() {
		return industryEmail;
	}

	public void setIndustryEmail(String industryEmail) {
		this.industryEmail = industryEmail;
	}

	public String getIndustryMob() {
		return industryMob;
	}

	public void setIndustryMob(String industryMob) {
		this.industryMob = industryMob;
	}

	public String getIndustryPassword() {
		return industryPassword;
	}

	public void setIndustryPassword(String industryPassword) {
		this.industryPassword = industryPassword;
	}

	public String getIndustryAddress() {
		return industryAddress;
	}

	public void setIndustryAddress(String industryAddress) {
		this.industryAddress = industryAddress;
	}

	public List<Job> getJobs() {
		return jobs;
	}

	public void setJobs(List<Job> jobs) {
		this.jobs = jobs;
	}

	public Industry(String industryCode, String industryName, String industryEmail, String industryMob,
			String industryPassword, String industryAddress, List<Job> jobs) {
		super();
		this.industryCode = industryCode;
		this.industryName = industryName;
		this.industryEmail = industryEmail;
		this.industryMob = industryMob;
		this.industryPassword = industryPassword;
		this.industryAddress = industryAddress;
		this.jobs = jobs;
	}

	
	

	public Industry() {
		
		
	}
	

	
	
	
	
	
	
	

}
