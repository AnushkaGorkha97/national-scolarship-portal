package com.lti.core.daos;
import java.util.ArrayList;
import java.util.List;

import com.lti.core.entities.Course;
import com.lti.core.entities.Institute;
import com.lti.core.entities.Job;
import com.lti.core.entities.Student;
import com.lti.core.entities.*;

public interface AdminDao {

	public List<Course> viewCourseAdmin0();
    public int accCourse0(String courseId);
    public int rejCourse0(String courseId);
    
	public List<Institute> monitoringInstitutes0();
	public List<Student> viewStudentReqByAdmin0(); 
	public int accStudentReqByAdmin0(String studentAadharNo);
	public int rejStudentReqByAdmin0(String studentAadharNo);
	
	public List<Job> viewJobAdmin0();
	public int accJob0(String jobId);
    public int rejJob0(String jobId);
    
    public List<Industry> monitoringIndustry0();
    public List<Student> monitoringStudent0();
    
    public List<Course> returnAllInstituteAccCourse(Institute instituteid);
    public List<Job> returnsAllIndustryAccJob(Industry industryid);
    
}
