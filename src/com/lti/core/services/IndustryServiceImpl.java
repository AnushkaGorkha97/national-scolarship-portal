package com.lti.core.services;

import java.util.List;

import javax.transaction.Transactional;
import com.lti.core.daos.IndustryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.lti.core.entities.*;




@Transactional
@Repository("IndustryService")
public class IndustryServiceImpl implements IndustryService {
	
	@Autowired
	private IndustryDao industryDao;

	@Override
	public boolean insertNewIndustry1(Industry industry) {
		int result = industryDao.insertNewIndustry0(industry);
		if(result==1) {
			return true;
		} else {
		return false;
		}
	}

	@Override
	public boolean setPassForIndustry1(String industryCode, String industryPasswordCrypt) {
		String industryPassword = industryPasswordCrypt;
		int passResult = industryDao.setPassForIndustry0(industryCode, industryPassword);
		if(passResult==1)
			return true;
		else
		return false;
	}

	@Override
	public Industry industryLogin1(String industryCode) {
		Industry industry1 = new Industry();
		industry1 = industryDao.industryLogin0(industryCode);
		return industry1;
	}

	@Override
	public boolean editProfileForIndustry1(Industry industry) {
		int editResult = industryDao.editProfileForIndustry0(industry);
		if(editResult==1)
		return true;
		else
		return false;
	}

	@Override
	public boolean insertNewJob1(Job job, Industry industryid) {
		int addjob=industryDao.insertNewJob0(job, industryid);
		if(addjob==1)
			return true;
		else
		return false;
	}

	@Override
	public List<Completedcourse> returnsStudentList1(String compCourseId) {
		List<Completedcourse> stdList1=industryDao.returnsStudentList0(compCourseId);
		return stdList1;
	}

	@Override
	public List<Job> viewJobStatus1(Industry industryid) {
		List<Job> jobStatusList1=industryDao.viewJobStatus0(industryid);
		return jobStatusList1;
	}

	@Override
	public int updateJobStatusByIndustry1(Industry industryid) {
		int res=industryDao.updateJobStatusByIndustry0(industryid);
		return res;
	}

	@Override
	public List<Job> ViewAccJob1(Industry industryid) {
		List<Job> jobList1=industryDao.ViewAccJob(industryid);
		return jobList1;
	}

	@Override
	public List<Completedcourse> sendCompletedCourseByStudent1(Student studentid) {
		List<Completedcourse> courseList1=industryDao.sendCompletedCourseByStudent(studentid);
		return courseList1;
	}

	@Override
	public Job getJobOnId1(String jobId) {
		Job job1=industryDao.getJobOnId0(jobId);
		return job1;
	}

	@Override
	public int addApplicationOfJob1(Jobapply jobapply) {
		int app=industryDao.addApplicationOfJob(jobapply);
		return app;
	}

	@Override
	public Jobapply returnsduplicatedJobapply1(Student studentjid, String appJobId) {
		Jobapply jobapp1=industryDao.returnsduplicatedJobapply(studentjid, appJobId);
		return jobapp1;
	}

	@Override
	public List<Jobapply> returnsStudentAppliedJob1(String appJobId) {
		List<Jobapply> jobapplyList1=industryDao.returnsStudentAppliedJob(appJobId);
		return jobapplyList1;
	}

	@Override
	public int accStudentByIndustry1(Student studentjid, String appJobId) {
		int accres=industryDao.accStudentByIndustry(studentjid, appJobId);
		return accres;
	}

	@Override
	public int rejStudentByIndustry1(Student studentjid, String appJobId) {
		int rejres=industryDao.rejStudentByIndustry(studentjid, appJobId);
		return rejres;
	}

	@Override
	public List<Jobapply> returnStudentHiredAccJob1(String jobId) {
		List<Jobapply> jobapply1=industryDao.returnStudentHiredAccJob(jobId);
		return jobapply1;
	}

	@Override
	public int delfinalFromJobapply1(Student studentjid) {
		int rest=industryDao.delfinalFromJobapply0(studentjid);
		return 1;
	}

	

}
