package com.lti.core.services;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.core.daos.AdminDao;
import com.lti.core.entities.*;


@Transactional
@Service("AdminService")
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminDao adminDao;

	@Override
	public List<Course> viewCourseAdmin1() {
		List<Course> courseList1=adminDao.viewCourseAdmin0();
		return courseList1;
	}

	@Override
	public int accCourse1(String courseId) {
		int accCourse=adminDao.accCourse0(courseId);
		return accCourse;
	}

	@Override
	public int rejCourse1(String courseId) {
		int rejCourse=adminDao.rejCourse0(courseId);
		return rejCourse;
	}

	@Override
	public List<Institute> monitoringInstitutes1() {
		List<Institute> instituteList1=adminDao.monitoringInstitutes0();
		return instituteList1;
	}

	@Override
	public List<Student> viewStudentReqByAdmin1() {
		List<Student> stdList1=adminDao.viewStudentReqByAdmin0();
		return stdList1;
	}

	@Override
	public int accStudentReqByAdmin1(String studentAadharNo) {
		int acc=adminDao.accStudentReqByAdmin0(studentAadharNo);
		return acc;
	}

	@Override
	public int rejStudentReqByAdmin1(String studentAadharNo) {
		int rej=adminDao.rejStudentReqByAdmin0(studentAadharNo);
		return rej;
	}

	@Override
	public List<Job> viewJobAdmin1() {
		List<Job> jobList1=adminDao.viewJobAdmin0();
		return jobList1;
	}

	@Override
	public int accJob1(String jobId) {
		int accJob=adminDao.accJob0(jobId);
		return accJob;
	}

	@Override
	public int rejJob1(String jobId) {
		int rejJob=adminDao.rejJob0(jobId);
		return rejJob;
	}

	@Override
	public List<Industry> monitoringIndustry1() {
		List<Industry> industryList1=adminDao.monitoringIndustry0();
		return industryList1;
	}

	@Override
	public List<Student> monitoringStudent1() {
		List<Student> studentList1=adminDao.monitoringStudent0();
		return studentList1;
	}

	@Override
	public List<Course> returnAllInstituteAccCourse1(Institute instituteid) {
		List<Course> courseList1=adminDao.returnAllInstituteAccCourse(instituteid);
		return courseList1;
	}

	@Override
	public List<Job> returnsAllIndustryAccJob1(Industry industryid) {
		List<Job> jobList1=adminDao.returnsAllIndustryAccJob(industryid);
		return jobList1;
	}


	
	
	
	
	
}
