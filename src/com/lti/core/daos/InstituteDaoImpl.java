package com.lti.core.daos;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.lti.core.entities.*;
import com.lti.core.exceptions.ScholarException;

@Repository("InstituteDao")
public class InstituteDaoImpl implements InstituteDao {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public int insertNewInstitute0(Institute institute) {
		entityManager.persist(institute);
		return 1;
	}

	@Override
	public int setPassForInstitute0(String instituteCode, String institutePassword) {
		Query qry1 = entityManager.createQuery("update institute i set i.institutePassword= :institutePassword where i.instituteCode= :instituteCode");
		qry1.setParameter("institutePassword", institutePassword);
		qry1.setParameter("instituteCode", instituteCode);
		qry1.executeUpdate();
		return 1;
		
	}

	@Override
	public Institute instituteLogin0(String instituteCode) {
		Query qry2 = entityManager.createQuery("select i from institute i where i.instituteCode= :instituteCode");
		qry2.setParameter("instituteCode", instituteCode);
		
			return (Institute)(qry2.getSingleResult());
	}

	@Override
	public int editProfileForInstitute0(Institute institute) {
		entityManager.merge(institute);
		return 1;
	}

	@Override
	public int insertNewCourse0(Course course, Institute instituteid) {
		course.setCourseAR("0");
		course.setInstituteid(instituteid);
		entityManager.persist(course);
		return 1;
	}

	@Override
	public List<Course> viewCourseStatus0(Institute instituteid) {
		Query qry3 = entityManager.createQuery("select c from course c where c.instituteid= :instituteid");
		qry3.setParameter("instituteid",instituteid);
		List<Course> courseStatusList0=qry3.getResultList();
		return courseStatusList0;
		
	}

	@Override
	public int updateCourseStatusByInstitute0(Institute instituteid) {
		String d="3";
		Query qry4 = entityManager.createQuery("delete from course c where c.instituteid= :instituteid and c.courseAR= :d");
	    qry4.setParameter("d", d);
	    qry4.setParameter("instituteid", instituteid);
	    qry4.executeUpdate();
	    return 1;
	}

	@Override
	public List<Completedcourse> viewStudentsForCertification0(String compId) {
		String g="0";
		Query qry5=entityManager.createQuery("select cc from completedcourse cc where cc.compCourseId= :compId and cc.compCertification= :g");
	    qry5.setParameter("compId", compId);
	    qry5.setParameter("g", g);
	    List<Completedcourse> ccList0=qry5.getResultList();
	    return ccList0;
	
	}

	@Override
	public int instituteCertifiesStudent0(String compId, Student studentid) {
	    String compCertification="1";
		String compCourseId=compId;
		Query qry6=entityManager.createQuery("update completedcourse cc set cc.compCertification= :compCertification where cc.compCourseId= :compCourseId and cc.studentid= :studentid");
		qry6.setParameter("compCertification", compCertification);
		qry6.setParameter("compCourseId", compCourseId);
		qry6.setParameter("studentid", studentid);
		qry6.executeUpdate();
		return 1;
	}

	@Override
	public List<Course> getAccCoursesOnInstituteid0(Institute instituteid) {
		String s="1";
		Query qry7 = entityManager.createQuery("select c from course c where c.instituteid= :instituteid and c.courseAR= :s");
		qry7.setParameter("instituteid",instituteid);
		qry7.setParameter("s", s);
		List<Course> courseStatusList0=qry7.getResultList();
		return courseStatusList0;
	}

	

	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
