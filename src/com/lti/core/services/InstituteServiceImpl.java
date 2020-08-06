package com.lti.core.services;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lti.core.daos.InstituteDao;
import com.lti.core.daos.StudentDao;
import com.lti.core.entities.*;
import com.lti.core.exceptions.ScholarException;

@Transactional
@Repository("InstituteService")
public class InstituteServiceImpl implements InstituteService {

	@Autowired
	private InstituteDao instituteDao;

	@Override
	public boolean insertNewInstitute1(Institute institute) {
		int result = instituteDao.insertNewInstitute0(institute);
		if(result==1) {
			return true;
		} else {
		return false;
		}
	}

	@Override
	public boolean setPassForInstitute1(String instituteCode, String institutePasswordCrypt) {
		String institutePassword = institutePasswordCrypt;
		int passResult = instituteDao.setPassForInstitute0(instituteCode, institutePassword);
		if(passResult==1)
			return true;
		else
		return false;
	}

	@Override
	public Institute instituteLogin1(String instituteCode) {
		Institute institute1 = new Institute();
		institute1 = instituteDao.instituteLogin0(instituteCode);
		return institute1;
	}

	@Override
	public boolean editProfileForInstitute1(Institute institute) {
		int editResult = instituteDao.editProfileForInstitute0(institute);
		if(editResult==1)
		return true;
		else
		return false;
	}

	@Override
	public boolean insertNewCourse1(Course course, Institute instituteid) {
		int addcourse=instituteDao.insertNewCourse0(course, instituteid);
		if(addcourse==1)
			return true;
		else
		return false;
	}

	@Override
	public List<Course> viewCourseStatus1(Institute instituteid) {
		List<Course> courseStatusList1=instituteDao.viewCourseStatus0(instituteid);
		return courseStatusList1;
	}

	@Override
	public int updateCourseStatusByInstitute1(Institute instituteid) {
		int res=instituteDao.updateCourseStatusByInstitute0(instituteid);
		return res;
	}

	@Override
	public List<Completedcourse> viewStudentsForCertification1(String compId) {
		List<Completedcourse> ccList1=instituteDao.viewStudentsForCertification0(compId);
		return ccList1;
	}

	@Override
	public int instituteCertifiesStudent1(String compId, Student studentid) {
	
		int certi=instituteDao.instituteCertifiesStudent0(compId, studentid);
		return certi;
	}

	@Override
	public List<Course> getAccCoursesOnInstituteid1(Institute instituteid) {
		List<Course> courseStatusList1=instituteDao.getAccCoursesOnInstituteid0(instituteid);
		return courseStatusList1;
	}

	

	
	
	


}
