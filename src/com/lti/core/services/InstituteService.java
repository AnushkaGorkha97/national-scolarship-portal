package com.lti.core.services;
import java.util.List;

import com.lti.core.entities.*;
import com.lti.core.exceptions.ScholarException;


public interface InstituteService {
	
	public boolean insertNewInstitute1(Institute institute);
	public boolean setPassForInstitute1(String instituteCode, String institutePasswordCrypt);
	public Institute instituteLogin1(String instituteCode);
	public boolean editProfileForInstitute1(Institute institute);
	
	public boolean insertNewCourse1(Course course, Institute instituteid);
	public List<Course> viewCourseStatus1(Institute instituteid);
	public int updateCourseStatusByInstitute1(Institute instituteid);
	public List<Completedcourse> viewStudentsForCertification1(String compId);
	public int instituteCertifiesStudent1(String compId, Student studentid);
}
