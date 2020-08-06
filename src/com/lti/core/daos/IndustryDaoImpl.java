package com.lti.core.daos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.lti.core.entities.*;


@Repository("IndustryDao")
public class IndustryDaoImpl implements IndustryDao {

	
	@PersistenceContext
	private EntityManager entityManager;

	
	
	
	@Override
	public int insertNewIndustry0(Industry industry) {
		entityManager.persist(industry);
		return 1;
	}




	@Override
	public int setPassForIndustry0(String industryCode, String industryPassword) {
		Query qry1 = entityManager.createQuery("update industry i set i.industryPassword= :industryPassword where i.industryCode= :industryCode");
		qry1.setParameter("industryPassword", industryPassword);
		qry1.setParameter("industryCode", industryCode);
		qry1.executeUpdate();
		return 1;
	}




	@Override
	public Industry industryLogin0(String industryCode) {
		Query qry2 = entityManager.createQuery("select i from industry i where i.industryCode= :industryCode");
		qry2.setParameter("industryCode", industryCode);
		
			return (Industry)(qry2.getSingleResult());
	}




	@Override
	public int editProfileForIndustry0(Industry industry) {
		entityManager.merge(industry);
		return 1;
	}




	@Override
	public int insertNewJob0(Job job, Industry industryid) {
		job.setJobAR("0");
		job.setIndustryid(industryid);
		entityManager.persist(job);
		return 1;
	}




	@Override
	public List<Completedcourse> returnsStudentList0(String compCourseId) {
		String g="1";
	
		Query qry3=entityManager.createQuery("select cc from completedcourse cc where cc.compCourseId= :compCourseId and cc.compCertification= :g");
	    qry3.setParameter("compCourseId", compCourseId);
	    qry3.setParameter("g", g);
	
	    List<Completedcourse> stdList0=qry3.getResultList();
	    return stdList0;
	}




	@Override
	public List<Job> viewJobStatus0(Industry industryid) {
		Query qry4 = entityManager.createQuery("select j from job j where j.industryid= :industryid");
		qry4.setParameter("industryid",industryid);
		List<Job> jobStatusList0=qry4.getResultList();
		return jobStatusList0;
	}




	@Override
	public int updateJobStatusByIndustry0(Industry industryid) {
		String d="3";
		Query qry5 = entityManager.createQuery("delete from job j where j.industryid= :industryid and j.jobAR= :d");
	    qry5.setParameter("d", d);
	    qry5.setParameter("industryid", industryid);
	    qry5.executeUpdate();
	    return 1;
	}




	@Override
	public List<Job> ViewAccJob(Industry industryid) {
		String p="1";
		Query qry6=entityManager.createQuery("select j from job j where j.industryid= :industryid and j.jobAR= :p");
	     qry6.setParameter("industryid", industryid);
	     qry6.setParameter("p", p);
	     List<Job> jobList=qry6.getResultList();
	     return jobList;
	}




	@Override
	public List<Completedcourse> sendCompletedCourseByStudent(Student studentid) {
		String b="1";
		Query qry7=entityManager.createQuery("select cc from completedcourse cc where cc.studentid= :studentid and cc.compCertification= :b");
	    qry7.setParameter("b", b);
	    qry7.setParameter("studentid", studentid);
	    List<Completedcourse> courseList0=qry7.getResultList();
	    return courseList0;
	
	}




	@Override
	public Job getJobOnId0(String jobId) {
		Query qry8=entityManager.createQuery("select j from job j where j.jobId=:jobId");
		qry8.setParameter("jobId", jobId);
		Job job0=(Job) qry8.getSingleResult();
		return job0;
	}




	@Override
	public int addApplicationOfJob(Jobapply jobapply) {
		entityManager.persist(jobapply);
		return 1;
	}




	@Override
	public Jobapply returnsduplicatedJobapply(Student studentjid, String appJobId) {
		Query qry9=entityManager.createQuery("select ja from jobapply ja where ja.studentjid= :studentjid and ja.appJobId= :appJobId");
		qry9.setParameter("studentjid", studentjid);
		qry9.setParameter("appJobId", appJobId);
		Jobapply jobapp0=(Jobapply) qry9.getSingleResult();
		return jobapp0;
	}




	@Override
	public List<Jobapply> returnsStudentAppliedJob(String appJobId) {
		String l="1";
		String j="0";
		Query qry10=entityManager.createQuery("select ja from jobapply ja where ja.appJobId= :appJobId and ja.appByStudent= :l and ja.appAccByIndustry= :j");
		qry10.setParameter("l", l);
		qry10.setParameter("j", j);
		qry10.setParameter("appJobId", appJobId);
		List<Jobapply> jobapplyList0=qry10.getResultList();
		return jobapplyList0;
	}




	@Override
	public int accStudentByIndustry(Student studentjid, String appJobId) {
		String q="1";
		
		Query qry11=entityManager.createQuery("update jobapply ja set ja.appAccByIndustry= :q where ja.studentjid= :studentjid and ja.appJobId= :appJobId");
	    qry11.setParameter("studentjid", studentjid);
	    qry11.setParameter("appJobId", appJobId);
	    qry11.setParameter("q", q);
	    qry11.executeUpdate();
	    return 1;
	}




	@Override
	public int rejStudentByIndustry(Student studentjid, String appJobId) {
		String r="3";
	Query qry12=entityManager.createQuery("update jobapply ja set ja.appAccByIndustry= :r where ja.studentjid= :studentjid and ja.appJobId= :appJobId");
	qry12.setParameter("studentjid", studentjid);
	qry12.setParameter("appJobId", appJobId);
	qry12.setParameter("r", r);
	qry12.executeUpdate();
		return 1;
	}




	@Override
	public List<Jobapply> returnStudentHiredAccJob(String jobId) {
		String u="1";
		String appJobId=jobId;
		Query qry13=entityManager.createQuery("select ja from jobapply ja where ja.appJobId= :appJobId and ja.appAccByStudent= :u");
		qry13.setParameter("appJobId", appJobId);
		qry13.setParameter("u", u);
		List<Jobapply> jobapply0=qry13.getResultList();
		return jobapply0;
	}




	@Override
	public int delfinalFromJobapply0(Student studentjid) {
		Query qry14=entityManager.createQuery("delete from jobapply ja where ja.studentjid= :studentjid");
		qry14.setParameter("studentjid", studentjid);
		qry14.executeUpdate();
		return 1;
	}




	@Override
	public List<Completedcourse> studentListCompletedCourseUnemployed0(String compCourseId) {
		String g="1";
		String o="0";
		Query qry15=entityManager.createQuery("select cc from completedcourse cc where cc.compCourseId= :compCourseId and cc.studentid.jobId= :o and cc.compCertification= :g");
	    qry15.setParameter("compCourseId", compCourseId);
	    qry15.setParameter("g", g);
	    qry15.setParameter("o", o);
	    List<Completedcourse> stdList0=qry15.getResultList();
	    return stdList0;
	}




	@Override
	public int deleteJobPostA0(String jobId) {
		String j="4";
		Query qry16=entityManager.createQuery("update job j set j.jobAR= :j where j.jobId= :jobId");
		qry16.setParameter("j", j);
		qry16.setParameter("jobId", jobId);
		qry16.executeUpdate();
		return 1;
	}




	@Override
	public int deleteJobPostB0(String appJobId) {
		Query qry17=entityManager.createQuery("delete from jobapply ja where ja.appJobId= :appJobId");
		qry17.setParameter("appJobId", appJobId);
		qry17.executeUpdate();
		return 1;
	}



 

}
