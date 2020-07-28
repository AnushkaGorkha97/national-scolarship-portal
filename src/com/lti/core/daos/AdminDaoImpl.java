package com.lti.core.daos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.lti.core.entities.*;




@Repository("AdminDao")
public class AdminDaoImpl implements AdminDao {
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Course> viewCourseAdmin0() {

		
			String k="0";
			
			  Query qry1 =entityManager.createQuery("select c from course c where c.courseAR= :k");
			  qry1.setParameter("k", k); 
			  List<Course> courseList0=qry1.getResultList();
				return courseList0;
		
		}

	@Override
	public int accCourse0(String courseId) {
		String a="1";
		Query qry2 = entityManager.createQuery("update course c set c.courseAR= :a where c.courseId= :courseId");
		qry2.setParameter("a", a);
		qry2.setParameter("courseId", courseId);
		qry2.executeUpdate();
		return 1;
	}

	@Override
	public int rejCourse0(String courseId) {
		String r="3";
		Query qry3 = entityManager.createQuery("update course c set c.courseAR= :r where c.courseId= :courseId");
		qry3.setParameter("r", r);
		qry3.setParameter("courseId", courseId);
		qry3.executeUpdate();
		return 1;
		
	}

	@Override
	public List<Institute> monitoringInstitutes0() {
		Query qry4=entityManager.createQuery("select i from institute i");
		List<Institute> instituteList0=qry4.getResultList();
		return instituteList0;
	}

	@Override
	public List<Student> viewStudentReqByAdmin0() {
		String id="0";
		String e="0";
		Query qry5=entityManager.createQuery("select s from student s where s.studentCourseId<> :id and s.studentCourseStatus= :e");
		qry5.setParameter("id", id);
		qry5.setParameter("e", e);
		List<Student> stdList0=qry5.getResultList();
		return stdList0;
	}

	@Override
	public int accStudentReqByAdmin0(String studentAadharNo) {
		String f="1";
		Query qry6=entityManager.createQuery("update student s set s.studentCourseStatus= :f where s.studentAadharNo= :studentAadharNo");
		qry6.setParameter("studentAadharNo", studentAadharNo);
		qry6.setParameter("f", f);
		qry6.executeUpdate();
		return 1;
	}

	@Override
	public int rejStudentReqByAdmin0(String studentAadharNo) {
		String x="0";
		String y="0";
		String z="0";
		Query qry7=entityManager.createQuery("update student s set s.studentCourseStatus= :y, s.studentCourseId= :x, s.studentCourseName= :z where s.studentAadharNo= :studentAadharNo");
		qry7.setParameter("x", x);
		qry7.setParameter("y", y);
		qry7.setParameter("z", z);
		qry7.setParameter("studentAadharNo", studentAadharNo);
		qry7.executeUpdate();
		return 1;
	}

	@Override
	public List<Job> viewJobAdmin0() {
		String k="0";
		
		  Query qry8 =entityManager.createQuery("select j from job j where j.jobAR= :k");
		  qry8.setParameter("k", k); 
		  List<Job> jobList0=qry8.getResultList();
			return jobList0;
	}

	@Override
	public int accJob0(String jobId) {
		String aa="1";
		Query qry9 = entityManager.createQuery("update job j set j.jobAR= :aa where j.jobId= :jobId");
		qry9.setParameter("aa", aa);
		qry9.setParameter("jobId", jobId);
		qry9.executeUpdate();
		return 1;
	}

	@Override
	public int rejJob0(String jobId) {
		String rr="3";
		Query qry10 = entityManager.createQuery("update job j set j.jobAR= :rr where j.jobId= :jobId");
		qry10.setParameter("rr", rr);
		qry10.setParameter("jobId", jobId);
		qry10.executeUpdate();
		return 1;
	}

	@Override
	public List<Industry> monitoringIndustry0() {
		Query qry11=entityManager.createQuery("select i from industry i");
		List<Industry> industryList0=qry11.getResultList();
		return industryList0;
	}

	@Override
	public List<Student> monitoringStudent0() {
		Query qry12=entityManager.createQuery("select s from student s");
		List<Student> studentList0=qry12.getResultList();
		return studentList0;
	}

	@Override
	public List<Course> returnAllInstituteAccCourse(Institute instituteid) {
		String y="1";
		Query qry13=entityManager.createQuery("select c from course c where c.instituteid= :instituteid and c.courseAR= :y");
		qry13.setParameter("instituteid", instituteid);
		qry13.setParameter("y", y);
		List<Course> courseList0=qry13.getResultList();
		return courseList0;
	}

	@Override
	public List<Job> returnsAllIndustryAccJob(Industry industryid) {
		String z="1";
		Query qry14=entityManager.createQuery("select j from job j where j.industryid= :industryid and j.jobAR= :z");
		qry14.setParameter("industryid", industryid);
		qry14.setParameter("z", z);
		List<Job> jobList0=qry14.getResultList();
		return jobList0;
	}

	

	}
	
	
	


