package com.lti.core.services;
import java.util.ArrayList;
import java.util.List;

import com.lti.core.entities.*;


public interface AdminService {

	public List<Course> viewCourseAdmin1();
	public int accCourse1(String courseId);
    public int rejCourse1(String courseId);
    
    public List<Institute> monitoringInstitutes1();
    public List<Student> viewStudentReqByAdmin1();
    public int accStudentReqByAdmin1(String studentAadharNo);
    public int rejStudentReqByAdmin1(String studentAadharNo);
    
    public List<Job> viewJobAdmin1();
	public int accJob1(String jobId);
    public int rejJob1(String jobId);
    
    public List<Industry> monitoringIndustry1();
    public List<Student> monitoringStudent1();
    public List<Course> returnAllInstituteAccCourse1(Institute instituteid);
    public List<Job> returnsAllIndustryAccJob1(Industry industryid);
}
