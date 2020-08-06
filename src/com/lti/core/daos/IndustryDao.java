package com.lti.core.daos;

import java.util.ArrayList;
import java.util.List;
import com.lti.core.entities.*;


public interface IndustryDao {

	public int insertNewIndustry0(Industry industry);
	public int setPassForIndustry0(String industryCode, String industryPassword );
	public Industry industryLogin0(String industryCode);
	public int editProfileForIndustry0(Industry industry);
	
	public int insertNewJob0(Job job, Industry industryid);
	public List<Completedcourse> returnsStudentList0(String compCourseId);
	public List<Job> viewJobStatus0(Industry industryid);
	public int updateJobStatusByIndustry0(Industry industryid);
	public List<Job> ViewAccJob(Industry industryid);
	public List<Completedcourse> sendCompletedCourseByStudent(Student studentid);
	public Job getJobOnId0(String jobId);
	public int addApplicationOfJob(Jobapply jobapply);
	public Jobapply returnsduplicatedJobapply(Student studentjid, String appJobId);
	
	public List<Jobapply> returnsStudentAppliedJob(String appJobId);
	public int accStudentByIndustry(Student studentjid, String appJobId);
	public int rejStudentByIndustry(Student studentjid, String appJobId);
	public List<Jobapply> returnStudentHiredAccJob(String jobId);
	public int delfinalFromJobapply0(Student studentjid);
	public List<Completedcourse> studentListCompletedCourseUnemployed0(String compCourseId);
	public int deleteJobPostA0(String jobId);
	public int deleteJobPostB0(String appJobId);
	
}
