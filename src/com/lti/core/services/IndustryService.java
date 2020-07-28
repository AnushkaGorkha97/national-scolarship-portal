package com.lti.core.services;

import java.util.List;

import com.lti.core.entities.*;




public interface IndustryService {
	
	
	public boolean insertNewIndustry1(Industry industry);
	public boolean setPassForIndustry1(String industryCode, String industryPasswordCrypt);
	public Industry industryLogin1(String industryCode);
	public boolean editProfileForIndustry1(Industry industry);
	
	public boolean insertNewJob1(Job job, Industry industryid);
	public List<Completedcourse> returnsStudentList1(String compCourseId);
	public List<Job> viewJobStatus1(Industry industryid);
	public int updateJobStatusByIndustry1(Industry industryid);
	public List<Job> ViewAccJob1(Industry industryid);
	public List<Completedcourse> sendCompletedCourseByStudent1(Student studentid);
	public Job getJobOnId1(String jobId);
	public int addApplicationOfJob1(Jobapply jobapply);
	public Jobapply returnsduplicatedJobapply1(Student studentjid, String appJobId);
	
	public List<Jobapply> returnsStudentAppliedJob1(String appJobId);
	public int accStudentByIndustry1(Student studentjid, String appJobId);
	public int rejStudentByIndustry1(Student studentjid, String appJobId);
	public List<Jobapply> returnStudentHiredAccJob1(String jobId);
	public int delfinalFromJobapply1(Student studentjid);

}
