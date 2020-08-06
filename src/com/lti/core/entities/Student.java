package com.lti.core.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity(name="student")
@Table(name="StudentTP10")
public class Student {

	@Id
	@Column(name="STUDENT_AADHARNO")
	private String studentAadharNo;

	@Column(name="STUDENT_NAME")
	private String studentName;

	@Column(name="STUDENT_EMAIL")
	private String studentEmail;

	@Column(name="STUDENT_PASSWORD")
	private String studentPassword;

	@Column(name="STUDENT_AGE")
	private String studentAge;
	
	@Column(name="STUDENT_DOB")
	private String studentDob;
	
	@Column(name="STUDENT_ADDRESS")
	private String studentAddress;
	
	@Column(name="STUDENT_GENDER")
	private String studentGender;
	
	@Column(name="STUDENT_MOBILE")
	private String studentMobile;
	
	@Column(name="STUDENT_10TH_YEAR")
	private String student10thYear;
	
	@Column(name="STUDENT_10TH_PERCENTAGE")
	private String student10thPercentage;

	
	@Column(name="STUDENT_12TH_YEAR")
	private String student12thYear;

	@Column(name="STUDENT_12TH_PERCENTAGE")
	private String student12thPercentage;

	@Column(name="JOB_ID")
	private String jobId;
	
	@Column(name="COURSE_ID")
	private String studentCourseId;
	
	@Column(name="COURSE_NAME")
	private String studentCourseName;
	
	@Column(name="STUDENT_COURSE_STATUS")
	private String studentCourseStatus;
	
	@OneToMany(mappedBy="studentid")
	private List<Completedcourse> completedcourses;
	
	@OneToMany(mappedBy="studentjid")
	private List<Jobapply> jobapply;

	public String getStudentAadharNo() {
		return studentAadharNo;
	}

	public void setStudentAadharNo(String studentAadharNo) {
		this.studentAadharNo = studentAadharNo;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentEmail() {
		return studentEmail;
	}

	public void setStudentEmail(String studentEmail) {
		this.studentEmail = studentEmail;
	}

	public String getStudentPassword() {
		return studentPassword;
	}

	public void setStudentPassword(String studentPassword) {
		this.studentPassword = studentPassword;
	}

	public String getStudentAge() {
		return studentAge;
	}

	public void setStudentAge(String studentAge) {
		this.studentAge = studentAge;
	}

	public String getStudentDob() {
		return studentDob;
	}

	public void setStudentDob(String studentDob) {
		this.studentDob = studentDob;
	}

	public String getStudentAddress() {
		return studentAddress;
	}

	public void setStudentAddress(String studentAddress) {
		this.studentAddress = studentAddress;
	}

	public String getStudentGender() {
		return studentGender;
	}

	public void setStudentGender(String studentGender) {
		this.studentGender = studentGender;
	}

	public String getStudentMobile() {
		return studentMobile;
	}

	public void setStudentMobile(String studentMobile) {
		this.studentMobile = studentMobile;
	}

	public String getStudent10thYear() {
		return student10thYear;
	}

	public void setStudent10thYear(String student10thYear) {
		this.student10thYear = student10thYear;
	}

	public String getStudent10thPercentage() {
		return student10thPercentage;
	}

	public void setStudent10thPercentage(String student10thPercentage) {
		this.student10thPercentage = student10thPercentage;
	}

	public String getStudent12thYear() {
		return student12thYear;
	}

	public void setStudent12thYear(String student12thYear) {
		this.student12thYear = student12thYear;
	}

	public String getStudent12thPercentage() {
		return student12thPercentage;
	}

	public void setStudent12thPercentage(String student12thPercentage) {
		this.student12thPercentage = student12thPercentage;
	}

	public String getJobId() {
		return jobId;
	}

	public void setJobId(String jobId) {
		this.jobId = jobId;
	}

	public String getStudentCourseId() {
		return studentCourseId;
	}

	public void setStudentCourseId(String studentCourseId) {
		this.studentCourseId = studentCourseId;
	}

	public String getStudentCourseName() {
		return studentCourseName;
	}

	public void setStudentCourseName(String studentCourseName) {
		this.studentCourseName = studentCourseName;
	}

	public String getStudentCourseStatus() {
		return studentCourseStatus;
	}

	public void setStudentCourseStatus(String studentCourseStatus) {
		this.studentCourseStatus = studentCourseStatus;
	}

	public List<Completedcourse> getCompletedcourses() {
		return completedcourses;
	}

	public void setCompletedcourses(List<Completedcourse> completedcourses) {
		this.completedcourses = completedcourses;
	}

	public List<Jobapply> getJobapply() {
		return jobapply;
	}

	public void setJobapply(List<Jobapply> jobapply) {
		this.jobapply = jobapply;
	}

	public Student(String studentAadharNo, String studentName, String studentEmail, String studentPassword,
			String studentAge, String studentDob, String studentAddress, String studentGender, String studentMobile,
			String student10thYear, String student10thPercentage, String student12thYear, String student12thPercentage,
			String jobId, String studentCourseId, String studentCourseName, String studentCourseStatus,
			List<Completedcourse> completedcourses, List<Jobapply> jobapply) {
		super();
		this.studentAadharNo = studentAadharNo;
		this.studentName = studentName;
		this.studentEmail = studentEmail;
		this.studentPassword = studentPassword;
		this.studentAge = studentAge;
		this.studentDob = studentDob;
		this.studentAddress = studentAddress;
		this.studentGender = studentGender;
		this.studentMobile = studentMobile;
		this.student10thYear = student10thYear;
		this.student10thPercentage = student10thPercentage;
		this.student12thYear = student12thYear;
		this.student12thPercentage = student12thPercentage;
		this.jobId = jobId;
		this.studentCourseId = studentCourseId;
		this.studentCourseName = studentCourseName;
		this.studentCourseStatus = studentCourseStatus;
		this.completedcourses = completedcourses;
		this.jobapply = jobapply;
	}

	
	

public Student() {
		
	}
	
	
	
	

	
	
	






	
	
	
}
