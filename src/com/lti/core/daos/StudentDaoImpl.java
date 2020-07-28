package com.lti.core.daos;

import com.lti.core.entities.Completedcourse;
import com.lti.core.entities.Course;
import com.lti.core.entities.Institute;
import com.lti.core.entities.Job;
import com.lti.core.entities.Jobapply;
import com.lti.core.entities.Student;
import com.lti.core.exceptions.ScholarException;

import org.springframework.stereotype.Repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;




@Repository("StudentDao")
public class StudentDaoImpl implements StudentDao{
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public int insertNewStudent0(Student student) {
		student.setStudentCourseId("0");
		student.setStudentCourseStatus("0");
		
		entityManager.persist(student);
		return 1;
	}

	@Override
	public int setPassForStudent0(String studentAadharNo, String studentPassword) {
		Query qry1 = entityManager.createQuery("update student s set s.studentPassword= :studentPassword where s.studentAadharNo= :studentAadharNo");
		qry1.setParameter("studentPassword", studentPassword);
		qry1.setParameter("studentAadharNo", studentAadharNo);
		qry1.executeUpdate();
		return 1;
	}

	@Override
	public Student studentLogin0(String studentAadharNo) {
		Query qry2 = entityManager.createQuery("select s from student s where s.studentAadharNo= :studentAadharNo");
		qry2.setParameter("studentAadharNo", studentAadharNo);
		
			return (Student)(qry2.getSingleResult()); 
	}

	@Override
	public int editProfileForStudent0(Student student) {
		entityManager.merge(student);
		return 1;
	
	}

	@Override
	public List<Course> viewCourseByStudent0() {
		String l="1";
		Query qry3 = entityManager.createQuery("select c from course c where c.courseAR= :l");
		qry3.setParameter("l", l);
		List<Course> courseList0=(List<Course>)(qry3.getResultList());
		return courseList0;
	}

	@Override
	public int applyForCourse0(String studentCourseId, String studentAadharNo, String studentCourseName) {
		String status="0";
    Query qry4=entityManager.createQuery("update student s set s.studentCourseId= :studentCourseId, s.studentCourseStatus= :status, s.studentCourseName= :studentCourseName where s.studentAadharNo= :studentAadharNo");
    qry4.setParameter("studentAadharNo", studentAadharNo);
    qry4.setParameter("studentCourseId", studentCourseId);
    qry4.setParameter("status", status);
    qry4.setParameter("studentCourseName", studentCourseName);
    qry4.executeUpdate();
    return 1;
	}

	@Override
	public Course returnCourseOnId(String courseId) {
		
		 Query qry5=entityManager.createQuery("select c from course c where c.courseId= :courseId");
         qry5.setParameter("courseId", courseId);
         Course course0=(Course) qry5.getSingleResult();
         return course0;
	}

	@Override
	public int addCompletedCourse0(Completedcourse completedcourse) {
		completedcourse.setCompCertification("0");
		entityManager.persist(completedcourse);
		return 1;
	}

	@Override
	public Completedcourse CheckStudentapplyingSameCourse(String compCourseId, Student studentid) {
		Query qry6=entityManager.createQuery("select cc from completedcourse cc where cc.compCourseId= :compCourseId and cc.studentid= :studentid");
		qry6.setParameter("compCourseId", compCourseId);
		qry6.setParameter("studentid", studentid);
		Completedcourse checkstd0=(Completedcourse) qry6.getSingleResult();
		return checkstd0;
	}

	@Override
	public List<Job> searchJobByStudent0() {
		String m="1";
		Query qry7=entityManager.createQuery("select j from job j where j.jobAR= :m");
		qry7.setParameter("m", m);
		List<Job> jobList0=qry7.getResultList();
		return jobList0;
	}

	@Override
	public List<Jobapply> returnStudentStatusOfApplyjob0(Student studentjid) {
		
		Query qry8=entityManager.createQuery("select ja from jobapply ja where ja.studentjid= :studentjid");
				qry8.setParameter("studentjid", studentjid);
		List<Jobapply> jobapply0=qry8.getResultList();
		return jobapply0;
	}

	@Override
	public int rejJobByStudent(String appJobId, Student studentjid) {
		Query qry9=entityManager.createQuery("delete from jobapply ja where ja.studentjid= :studentjid and ja.appJobId= :appJobId");
		qry9.setParameter("studentjid", studentjid);
		qry9.setParameter("appJobId", appJobId);
		qry9.executeUpdate();
		return 1;
		
	}

	@Override
	public int accJobByStudentA(Student studentjid) {
		String y="0";
		Query qry10=entityManager.createQuery("delete from jobapply ja where ja.studentjid= :studentjid and ja.appAccByStudent= :y");
		qry10.setParameter("studentjid", studentjid);
		qry10.setParameter("y", y);
		qry10.executeUpdate();
		return 1;
	}

	@Override
	public int accJobByStudentB(String studentAadharNo, String jobId) {
		Query qry11=entityManager.createQuery("update student s set s.jobId= :jobId where s.studentAadharNo= :studentAadharNo");
	    qry11.setParameter("jobId", jobId);
	    qry11.setParameter("studentAadharNo", studentAadharNo);
	    qry11.executeUpdate();
	    return 1;
	
	}

	@Override
	public int accJobByStudent0(Student studentjid, String appJobId) {
		String h="1";
	Query qry12=entityManager.createQuery("update jobapply ja set ja.appAccByStudent= :h where ja.studentjid= :studentjid and ja.appJobId= :appJobId");
	qry12.setParameter("h", h);
	qry12.setParameter("studentjid", studentjid);
	qry12.setParameter("appJobId", appJobId);
	qry12.executeUpdate();
	return 1;
	}

	
	
	
	

	

}
