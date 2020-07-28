package com.lti.core.daos;

import com.lti.core.entities.*;
import com.lti.core.exceptions.ScholarException;
import com.lti.core.entities.Course;
import java.util.ArrayList;
import java.util.List;

public interface InstituteDao {

	public int insertNewInstitute0(Institute institute );
	public int setPassForInstitute0(String instituteCode, String institutePassword );
	public Institute instituteLogin0(String instituteCode);
	public int editProfileForInstitute0(Institute institute);
	
	public int insertNewCourse0(Course course, Institute instituteid);
	public List<Course> viewCourseStatus0(Institute instituteid);
	public int updateCourseStatusByInstitute0(Institute instituteid);
	public List<Completedcourse> viewStudentsForCertification0(String compId);
	public int instituteCertifiesStudent0(String compId, Student stdentid);
}
