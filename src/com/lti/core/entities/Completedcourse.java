package com.lti.core.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity(name="completedcourse")
@Table(name="CompletedCourseTP10")
public class Completedcourse {
	
	@Id
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid") 
	@Column(name="COMPLETED_COURSE_ID")
	private String compId;
	
	@Column(name="COMPLETED_COURSE_NAME")
	private String compName;
	
	@Column(name="COMPLETED_COURSE_STDID")
	private String compStdId;
	
	@Column(name="COMPLETED_COURSE_COURSEID")
	private String compCourseId;
	
	@Column(name="COMPLETED_COURSE_SCORE")
	private String compScore;
	
	@Column(name="COMPLETED_COURSE_CERTIFICATION")
	private String compCertification;
	
	@ManyToOne
    @JoinColumn(name="COMPLETED_STUDENT_ID")
	private Student studentid;

	public String getCompId() {
		return compId;
	}

	public void setCompId(String compId) {
		this.compId = compId;
	}

	public String getCompName() {
		return compName;
	}

	public void setCompName(String compName) {
		this.compName = compName;
	}

	public String getCompStdId() {
		return compStdId;
	}

	public void setCompStdId(String compStdId) {
		this.compStdId = compStdId;
	}

	public String getCompCourseId() {
		return compCourseId;
	}

	public void setCompCourseId(String compCourseId) {
		this.compCourseId = compCourseId;
	}

	public String getCompScore() {
		return compScore;
	}

	public void setCompScore(String compScore) {
		this.compScore = compScore;
	}

	public String getCompCertification() {
		return compCertification;
	}

	public void setCompCertification(String compCertification) {
		this.compCertification = compCertification;
	}

	public Student getStudentid() {
		return studentid;
	}

	public void setStudentid(Student studentid) {
		this.studentid = studentid;
	}

	public Completedcourse(String compId, String compName, String compStdId, String compCourseId, String compScore,
			String compCertification, Student studentid) {
		super();
		this.compId = compId;
		this.compName = compName;
		this.compStdId = compStdId;
		this.compCourseId = compCourseId;
		this.compScore = compScore;
		this.compCertification = compCertification;
		this.studentid = studentid;
	}

	
	
	public Completedcourse() {
		// TODO Auto-generated constructor stub
	}


	
	

}
