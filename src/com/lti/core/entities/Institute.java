package com.lti.core.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.lti.core.entities.Course;
import java.util.ArrayList;
import java.util.List;


@Entity(name="institute")
@Table(name="InstituteTP10")
public class Institute {

	@Id
	@Column(name="INSTUTUTE_CODE")
	private String instituteCode;

	@Column(name="INSTITUTE_NAME")
	private String instituteName;
	
	@Column(name="INSTITUTE_EMAIL")
	private String instituteEmail;	
	
	@Column(name="INSTITUTE_PASSWORD")
	private String institutePassword;	
	
	@Column(name="INSTITUTE_MOBILE")
	private String instituteMobile;
	
	@Column(name="INSTITUTE_ADDRESS")
	private String instituteAddress;

	@Column(name="INSTITUTE_TYPE")
	private String instituteType;
	
	@OneToMany(mappedBy="instituteid")
	private List<Course> courses;

	public String getInstituteCode() {
		return instituteCode;
	}

	public void setInstituteCode(String instituteCode) {
		this.instituteCode = instituteCode;
	}

	public String getInstituteName() {
		return instituteName;
	}

	public void setInstituteName(String instituteName) {
		this.instituteName = instituteName;
	}

	public String getInstituteEmail() {
		return instituteEmail;
	}

	public void setInstituteEmail(String instituteEmail) {
		this.instituteEmail = instituteEmail;
	}

	public String getInstitutePassword() {
		return institutePassword;
	}

	public void setInstitutePassword(String institutePassword) {
		this.institutePassword = institutePassword;
	}

	public String getInstituteMobile() {
		return instituteMobile;
	}

	public void setInstituteMobile(String instituteMobile) {
		this.instituteMobile = instituteMobile;
	}

	public String getInstituteAddress() {
		return instituteAddress;
	}

	public void setInstituteAddress(String instituteAddress) {
		this.instituteAddress = instituteAddress;
	}

	public String getInstituteType() {
		return instituteType;
	}

	public void setInstituteType(String instituteType) {
		this.instituteType = instituteType;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	public Institute(String instituteCode, String instituteName, String instituteEmail, String institutePassword,
			String instituteMobile, String instituteAddress, String instituteType, List<Course> courses) {
		super();
		this.instituteCode = instituteCode;
		this.instituteName = instituteName;
		this.instituteEmail = instituteEmail;
		this.institutePassword = institutePassword;
		this.instituteMobile = instituteMobile;
		this.instituteAddress = instituteAddress;
		this.instituteType = instituteType;
		this.courses = courses;
	}

	

	public Institute() {
	}
	
	
	
	
	
	
	
	

	
	
	
	
	
	
	
	
	
	
}
