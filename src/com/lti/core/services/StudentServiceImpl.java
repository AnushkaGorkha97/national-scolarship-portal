package com.lti.core.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.core.entities.Completedcourse;
import com.lti.core.entities.Course;
import com.lti.core.entities.Job;
import com.lti.core.entities.Jobapply;
import com.lti.core.entities.Student;
import com.lti.core.exceptions.ScholarException;
import com.lti.core.daos.StudentDao;

@Transactional
@Service("studentService")
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentDao studentDao;
	
	
	@Override
	public boolean insertNewStudent1(Student student){
		int result = studentDao.insertNewStudent0(student);
		if(result==1) {
			return true;
		} else {
		return false;
		}
	}


	@Override
	public boolean setPassForStudent1(String studentAadharNo, String studentPasswordCrypt) {
		String studentPassword = studentPasswordCrypt;
		int passResult = studentDao.setPassForStudent0(studentAadharNo, studentPassword);
		if(passResult==1)
			return true;
		else
		return false;
	}


	@Override
	public Student studentLogin1(String studentAadharNo) {
		Student student1= new Student();  
				student1 = studentDao.studentLogin0(studentAadharNo);
		return student1;
	}


	@Override
	public boolean editProfileForStudent1(Student student) {
		int editResult = studentDao.editProfileForStudent0(student);
		if(editResult==1)
		return true;
		else
		return false;
	}


	@Override
	public List<Course> viewCourseByStudent1() {
		List<Course> courseList1=studentDao.viewCourseByStudent0();
		return courseList1;
	}


	@Override
	public int applyForCourse1(String studentCourseId, String studentAadharNo, String studentCourseName) {
		int applyCourse=studentDao.applyForCourse0(studentCourseId, studentAadharNo, studentCourseName);
		return applyCourse;
	}


	@Override
	public Course returnCourseOnId1(String courseId) {
		Course course1=studentDao.returnCourseOnId(courseId);
		return course1;
	}


	@Override
	public int addCompletedCourse0(Completedcourse completedcourse) {
		int res=studentDao.addCompletedCourse0(completedcourse);
		return res;
	}


	@Override
	public Completedcourse CheckStudentapplyingSameCourse1(String compCourseId, Student studentid) {
		Completedcourse checkstd2=studentDao.CheckStudentapplyingSameCourse(compCourseId, studentid);
		return checkstd2;
	}


	@Override
	public List<Job> searchJobByStudent1() {
		List<Job> jobList1=studentDao.searchJobByStudent0();
		return jobList1;
	}


	@Override
	public List<Jobapply> returnStudentStatusOfApplyjob1(Student studentjid) {
	List<Jobapply> jobapply1=studentDao.returnStudentStatusOfApplyjob0(studentjid);
		return jobapply1;
	}


	@Override
	public int rejJobByStudent1(String appJobId, Student studentjid) {
		int rej1=studentDao.rejJobByStudent(appJobId, studentjid);
		return rej1;
	}


	@Override
	public int accJobByStudentA1(Student studentjid) {
		int acc1=studentDao.accJobByStudentA(studentjid);
		return acc1;
	}


	@Override
	public int accJobByStudentB1(String studentAadharNo, String jobId) {
		int acc2=studentDao.accJobByStudentB(studentAadharNo, jobId);
		return 1;
	}


	@Override
	public int accJobByStudent1(Student studentjid, String appJobId) {
		int acc0=studentDao.accJobByStudent0(studentjid, appJobId);
		return acc0;
	}


	@Override
	public List<Completedcourse> listOfArchiveCoursesForStudent1(Student studentid) {
		List<Completedcourse> courseList1=studentDao.listOfArchiveCoursesForStudent0(studentid);
		return courseList1;
	}

	
	
}
