package com.lti.core.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity(name="jobapply")
@Table(name="JobapplyTP10")
public class Jobapply {
	
	@Id
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid") 
	@Column(name="APPLIED_ID")
	private String appId;
	
	@Column(name="APPLIED_JOB_ID")
	private String appJobId;
	
	@Column(name="APPLIED_JOB_NAME")
	private String appJobName;
	
	@Column(name="APPLIED_JOB_DESCRIPTION")
	private String appJobDescription;
	
	@Column(name="APPLIED_BY_STD")
	private String appByStudent;
	
	@Column(name="APPLIED_BY_INDUSTRY")
	private String appByIndustry;
	
	@Column(name="APPLIED_ACC_INDUSTRY")
	private String appAccByIndustry;
	
	@Column(name="APPLIED_JOB_ACC_STUDENT")
	private String appAccByStudent;
	
	@ManyToOne
    @JoinColumn(name="JOBAPPLIED_STUDENT_ID")
	private Student studentjid;

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getAppJobId() {
		return appJobId;
	}

	public void setAppJobId(String appJobId) {
		this.appJobId = appJobId;
	}

	public String getAppJobName() {
		return appJobName;
	}

	public void setAppJobName(String appJobName) {
		this.appJobName = appJobName;
	}

	public String getAppJobDescription() {
		return appJobDescription;
	}

	public void setAppJobDescription(String appJobDescription) {
		this.appJobDescription = appJobDescription;
	}

	public String getAppByStudent() {
		return appByStudent;
	}

	public void setAppByStudent(String appByStudent) {
		this.appByStudent = appByStudent;
	}

	public String getAppByIndustry() {
		return appByIndustry;
	}

	public void setAppByIndustry(String appByIndustry) {
		this.appByIndustry = appByIndustry;
	}

	public String getAppAccByIndustry() {
		return appAccByIndustry;
	}

	public void setAppAccByIndustry(String appAccByIndustry) {
		this.appAccByIndustry = appAccByIndustry;
	}

	public String getAppAccByStudent() {
		return appAccByStudent;
	}

	public void setAppAccByStudent(String appAccByStudent) {
		this.appAccByStudent = appAccByStudent;
	}

	public Student getStudentjid() {
		return studentjid;
	}

	public void setStudentjid(Student studentjid) {
		this.studentjid = studentjid;
	}

	public Jobapply(String appId, String appJobId, String appJobName, String appJobDescription, String appByStudent,
			String appByIndustry, String appAccByIndustry, String appAccByStudent, Student studentjid) {
		super();
		this.appId = appId;
		this.appJobId = appJobId;
		this.appJobName = appJobName;
		this.appJobDescription = appJobDescription;
		this.appByStudent = appByStudent;
		this.appByIndustry = appByIndustry;
		this.appAccByIndustry = appAccByIndustry;
		this.appAccByStudent = appAccByStudent;
		this.studentjid = studentjid;
	}
	
	
	
public Jobapply() {
		
	}
	
	

}
