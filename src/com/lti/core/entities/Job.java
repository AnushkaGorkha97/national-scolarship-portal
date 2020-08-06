package com.lti.core.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity(name="job")
@Table(name="JobTP10")
public class Job {
	
	
	

	@Id
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid") 
	@Column(name="JOB_CODE")
	private String jobId;
	
	@Column(name="JOB_NAME")
	private String jobName;
	
	@Column(name="JOB_DESCRIPTION")
	private String jobDescription;
	
	@Column(name="JOB_SALARY")
	private String jobSalary;
	
	@Column(name="JOB_AR")
	private String jobAR;
	
	@ManyToOne
    @JoinColumn(name="JOB_INDUSTRID")
	private Industry industryid;

	public String getJobId() {
		return jobId;
	}

	public void setJobId(String jobId) {
		this.jobId = jobId;
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public String getJobDescription() {
		return jobDescription;
	}

	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}

	public String getJobSalary() {
		return jobSalary;
	}

	public void setJobSalary(String jobSalary) {
		this.jobSalary = jobSalary;
	}

	public String getJobAR() {
		return jobAR;
	}

	public void setJobAR(String jobAR) {
		this.jobAR = jobAR;
	}

	public Industry getIndustryid() {
		return industryid;
	}

	public void setIndustryid(Industry industryid) {
		this.industryid = industryid;
	}

	public Job(String jobId, String jobName, String jobDescription, String jobSalary, String jobAR,
			Industry industryid) {
		super();
		this.jobId = jobId;
		this.jobName = jobName;
		this.jobDescription = jobDescription;
		this.jobSalary = jobSalary;
		this.jobAR = jobAR;
		this.industryid = industryid;
	}

	
	
	
	

	public Job() {
	}
	

}
