package com.lti.core.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.lti.core.entities.Institute;

@Entity(name="course")
@Table(name="CourseTP7")
public class Course {
	
	@Id
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid") 
	@Column(name="COURSE_ID")
	private String courseId;
	
	@Column(name="COURSE_Name")
	private String courseName;
	
	@Column(name="COURSE_DESCRIPTION")
	private String courseDescription;
	
	@ManyToOne
    @JoinColumn(name="COURSE_INSTITUTEID")
	private Institute instituteid;
	
	@Column(name="COURSE_Q1")
	private String courseQ1;
	
	@Column(name="COURSE_Q1A")
	private String courseQ1A;
	
	@Column(name="COURSE_Q1A1")
	private String courseQ1A1;
	
	@Column(name="COURSE_Q1A2")
	private String courseQ1A2;
	
	@Column(name="COURSE_Q2")
	private String courseQ2;
	
	@Column(name="COURSE_Q2A")
	private String courseQ2A;
	
	@Column(name="COURSE_Q2A1")
	private String courseQ2A1;
	
	@Column(name="COURSE_Q2A2")
	private String courseQ2A2;
	
	@Column(name="COURSE_Q3")
	private String courseQ3;
	
	@Column(name="COURSE_Q3A")
	private String courseQ3A;
	
	@Column(name="COURSE_Q3A1")
	private String courseQ3A1;
	
	@Column(name="COURSE_Q3A2")
	private String courseQ3A2;
	
	@Column(name="COURSE_LINK")
	private String courseLink;
	
	@Column(name="COURSE_AR")
	private String courseAR;

	public String getCourseId() {
		return courseId;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getCourseDescription() {
		return courseDescription;
	}

	public void setCourseDescription(String courseDescription) {
		this.courseDescription = courseDescription;
	}

	public Institute getInstituteid() {
		return instituteid;
	}

	public void setInstituteid(Institute instituteid) {
		this.instituteid = instituteid;
	}

	public String getCourseQ1() {
		return courseQ1;
	}

	public void setCourseQ1(String courseQ1) {
		this.courseQ1 = courseQ1;
	}

	public String getCourseQ1A() {
		return courseQ1A;
	}

	public void setCourseQ1A(String courseQ1A) {
		this.courseQ1A = courseQ1A;
	}

	public String getCourseQ1A1() {
		return courseQ1A1;
	}

	public void setCourseQ1A1(String courseQ1A1) {
		this.courseQ1A1 = courseQ1A1;
	}

	public String getCourseQ1A2() {
		return courseQ1A2;
	}

	public void setCourseQ1A2(String courseQ1A2) {
		this.courseQ1A2 = courseQ1A2;
	}

	public String getCourseQ2() {
		return courseQ2;
	}

	public void setCourseQ2(String courseQ2) {
		this.courseQ2 = courseQ2;
	}

	public String getCourseQ2A() {
		return courseQ2A;
	}

	public void setCourseQ2A(String courseQ2A) {
		this.courseQ2A = courseQ2A;
	}

	public String getCourseQ2A1() {
		return courseQ2A1;
	}

	public void setCourseQ2A1(String courseQ2A1) {
		this.courseQ2A1 = courseQ2A1;
	}

	public String getCourseQ2A2() {
		return courseQ2A2;
	}

	public void setCourseQ2A2(String courseQ2A2) {
		this.courseQ2A2 = courseQ2A2;
	}

	public String getCourseQ3() {
		return courseQ3;
	}

	public void setCourseQ3(String courseQ3) {
		this.courseQ3 = courseQ3;
	}

	public String getCourseQ3A() {
		return courseQ3A;
	}

	public void setCourseQ3A(String courseQ3A) {
		this.courseQ3A = courseQ3A;
	}

	public String getCourseQ3A1() {
		return courseQ3A1;
	}

	public void setCourseQ3A1(String courseQ3A1) {
		this.courseQ3A1 = courseQ3A1;
	}

	public String getCourseQ3A2() {
		return courseQ3A2;
	}

	public void setCourseQ3A2(String courseQ3A2) {
		this.courseQ3A2 = courseQ3A2;
	}

	public String getCourseLink() {
		return courseLink;
	}

	public void setCourseLink(String courseLink) {
		this.courseLink = courseLink;
	}

	public String getCourseAR() {
		return courseAR;
	}

	public void setCourseAR(String courseAR) {
		this.courseAR = courseAR;
	}

	public Course(String courseId, String courseName, String courseDescription, Institute instituteid, String courseQ1,
			String courseQ1A, String courseQ1A1, String courseQ1A2, String courseQ2, String courseQ2A,
			String courseQ2A1, String courseQ2A2, String courseQ3, String courseQ3A, String courseQ3A1,
			String courseQ3A2, String courseLink, String courseAR) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.courseDescription = courseDescription;
		this.instituteid = instituteid;
		this.courseQ1 = courseQ1;
		this.courseQ1A = courseQ1A;
		this.courseQ1A1 = courseQ1A1;
		this.courseQ1A2 = courseQ1A2;
		this.courseQ2 = courseQ2;
		this.courseQ2A = courseQ2A;
		this.courseQ2A1 = courseQ2A1;
		this.courseQ2A2 = courseQ2A2;
		this.courseQ3 = courseQ3;
		this.courseQ3A = courseQ3A;
		this.courseQ3A1 = courseQ3A1;
		this.courseQ3A2 = courseQ3A2;
		this.courseLink = courseLink;
		this.courseAR = courseAR;
	}

	
	
public Course() {
		
	}
	


	
	
	
	
	
	
	
	
	
	

}
