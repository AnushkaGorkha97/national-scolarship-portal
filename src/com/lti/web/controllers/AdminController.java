package com.lti.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.lti.core.entities.*;
import com.lti.core.services.AdminService;
import com.lti.core.services.IndustryService;
import com.lti.core.services.InstituteService;
import com.lti.core.services.StudentService;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;







@Controller
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	@Autowired
	private StudentService studentService;
	@Autowired
	private InstituteService instituteService;
	@Autowired
	private IndustryService industryService;
	
	//ADMIN LOGIN
	@RequestMapping(path="/adminlogin.hr", method=RequestMethod.GET)
	public String adminLoginPage(){
		return "AdminLogin";
	}
	@RequestMapping(path="/admindashboard.hr")
	public String adminDashboard(){
		return "AdminDashboard";
	}
	@RequestMapping(path="/admindashboard.hr", method=RequestMethod.POST)
	public String adminLogin(@RequestParam("adminId") String adminId, @RequestParam("adminPassword") String adminPassword){
		
		String adminid = "Admin";
		String adminpass = "Anushkaa";
		
		if(adminId.contentEquals(adminid) && adminPassword.contentEquals(adminpass)) {
		return "AdminDashboard";}
		else {
			return "Home";
		}
	}
	
	
	//VIEWING COURSES FOR APPROVAL/REJECTION
	@RequestMapping(path="/viewcourse.hr", method=RequestMethod.GET)
	public ModelAndView viewCourseByAdmin(){
	
		try {
			List<Course> courseList=adminService.viewCourseAdmin1();
			System.out.println(courseList);
			String jspName="AdminViewCourse";
			ModelAndView mAndV=new ModelAndView();
			mAndV.addObject("courseList", courseList);
			mAndV.setViewName(jspName);
			return mAndV;
		} catch (Exception e) {
			e.printStackTrace();
			String jspName="AdminDashboard";
			ModelAndView mAndV=new ModelAndView();
			mAndV.setViewName(jspName);
			return mAndV;
			
		}
	}
	
	//Accept BY Admin for course
	@RequestMapping(path="/acceptcoursebyadmin.hr")
	public ModelAndView adminAccCourse(@RequestParam("courseId") String courseId){
		
		try {
			int acceptCourse=adminService.accCourse1(courseId);
			List<Course> courseList=adminService.viewCourseAdmin1();
			System.out.println(courseList);
			String jspName="AdminViewCourse";
			ModelAndView mAndV=new ModelAndView();
			mAndV.addObject("courseList", courseList);
			mAndV.setViewName(jspName);
			return mAndV;
		} catch (Exception e) {
			e.printStackTrace();
			String jspName="AdminDashboard";
			ModelAndView mAndV=new ModelAndView();
			mAndV.setViewName(jspName);
			return mAndV;
			
		}
	}
	//Reject By Admin for course
	@RequestMapping(path="/rejectcoursebyadmin.hr")
	public ModelAndView adminRejcourse(@RequestParam("courseId") String courseId){
		
		try {
			int acceptCourse=adminService.rejCourse1(courseId);
			List<Course> courseList=adminService.viewCourseAdmin1();
			System.out.println(courseList);
			String jspName="AdminViewCourse";
			ModelAndView mAndV=new ModelAndView();
			mAndV.addObject("courseList", courseList);
			mAndV.setViewName(jspName);
			return mAndV;
		} catch (Exception e) {
			e.printStackTrace();
			String jspName="AdminDashboard";
			ModelAndView mAndV=new ModelAndView();
			mAndV.setViewName(jspName);
			return mAndV;
	      }
	}
	//Accept/Reject Student Requests
	@RequestMapping(path="/studentaccrej.hr", method=RequestMethod.GET)
	public ModelAndView accRejbyAdmin(){
		
		try {
			List<Student> studentList=adminService.viewStudentReqByAdmin1();
			String jsp="AdminViewStudentRequest";
			ModelAndView mAndV=new ModelAndView();
			mAndV.addObject("studentList", studentList);
			mAndV.setViewName(jsp);
			return mAndV;
		} catch (Exception e) {
			
			e.printStackTrace();
			ModelAndView mAndV=new ModelAndView();
			String jsp="AdminViewStudentRequest";
			mAndV.setViewName(jsp);
			return mAndV;
		}
		
	}
	
	//Accept Student Request By Admin
	@RequestMapping(path="/acceptstudentbyadmin.hr")
	public ModelAndView accStudentByAdmin(@RequestParam("studentAadharNo") String studentAadharNo) {
		int accstd=adminService.accStudentReqByAdmin1(studentAadharNo);
		try {
			List<Student> studentList=adminService.viewStudentReqByAdmin1();
			String jsp="AdminViewStudentRequest";
			ModelAndView mAndV=new ModelAndView();
			mAndV.addObject("studentList", studentList);
			mAndV.setViewName(jsp);
			return mAndV;
		} catch (Exception e) {
			
			e.printStackTrace();
			ModelAndView mAndV=new ModelAndView();
			String jsp="AdminViewStudentRequest";
			mAndV.setViewName(jsp);
			return mAndV;
		}
		
		
	}
	//Reject Student Request By Admin
		@RequestMapping(path="/rejectstudentbyadmin.hr")
		public ModelAndView rejStudentByAdmin(@RequestParam("studentAadharNo") String studentAadharNo) {
			int accstd=adminService.rejStudentReqByAdmin1(studentAadharNo);
			try {
				List<Student> studentList=adminService.viewStudentReqByAdmin1();
				String jsp="AdminViewStudentRequest";
				ModelAndView mAndV=new ModelAndView();
				mAndV.addObject("studentList", studentList);
				mAndV.setViewName(jsp);
				return mAndV;
			} catch (Exception e) {
				
				e.printStackTrace();
				ModelAndView mAndV=new ModelAndView();
				String jsp="AdminViewStudentRequest";
				mAndV.setViewName(jsp);
				return mAndV;
			}
			
			
		}
	
		//VIEWING JOBS FOR APPROVAL/REJECTION
		@RequestMapping(path="/viewjob.hr", method=RequestMethod.GET)
		public ModelAndView viewJobByAdmin(){
		
			try {
				List<Job> jobList=adminService.viewJobAdmin1();
				System.out.println(jobList);
				String jspName="AdminViewJob";
				ModelAndView mAndV=new ModelAndView();
				mAndV.addObject("jobList", jobList);
				mAndV.setViewName(jspName);
				return mAndV;
			} catch (Exception e) {
				e.printStackTrace();
				String jspName="AdminDashboard";
				ModelAndView mAndV=new ModelAndView();
				mAndV.setViewName(jspName);
				return mAndV;
				
			}
		}
	
		
		//Accept BY Admin for course
		@RequestMapping(path="/acceptjobbyadmin.hr")
		public ModelAndView adminAccJob(@RequestParam("jobId") String jobId){
			
			try {
				int acceptJob=adminService.accJob1(jobId);
				List<Job> jobList=adminService.viewJobAdmin1();
				System.out.println(jobList);
				String jspName="AdminViewJob";
				ModelAndView mAndV=new ModelAndView();
				mAndV.addObject("jobList", jobList);
				mAndV.setViewName(jspName);
				return mAndV;
			} catch (Exception e) {
				e.printStackTrace();
				String jspName="AdminDashboard";
				ModelAndView mAndV=new ModelAndView();
				mAndV.setViewName(jspName);
				return mAndV;
				
			}
		}
		//Reject By Admin for course
		@RequestMapping(path="/rejectjobbyadmin.hr")
		public ModelAndView adminRejJob(@RequestParam("jobId") String jobId){
			
			try {
				int rejJob=adminService.rejJob1(jobId);
				List<Job> jobList=adminService.viewJobAdmin1();
				
				System.out.println(jobList);
				String jspName="AdminViewJob";
				ModelAndView mAndV=new ModelAndView();
				mAndV.addObject("jobList", jobList);
				mAndV.setViewName(jspName);
				return mAndV;
			} catch (Exception e) {
				e.printStackTrace();
				String jspName="AdminDashboard";
				ModelAndView mAndV=new ModelAndView();
				mAndV.setViewName(jspName);
				return mAndV;
		      }
		}	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
	
	
	//MONITORING INSTITUTES
	@RequestMapping(path="/monitorinstitutes.hr")
	public ModelAndView monitorInstitutes(){
		try {
			List<Institute> instituteList=adminService.monitoringInstitutes1();
			
			String jsp="MonitorInstitutes";
			ModelAndView mAndV=new ModelAndView();
			mAndV.addObject("instituteList", instituteList);
			mAndV.setViewName(jsp);
			return mAndV;
		} catch (Exception e) {
          e.printStackTrace();
          String jsp="AdminDashboard";
			ModelAndView mAndV=new ModelAndView();
		    mAndV.setViewName(jsp);
			return mAndV;
		}
		
	}
	
		//View Each institute Profile
	@RequestMapping(path="/viewinstituteprofile.hr")
	public ModelAndView monitorInstituteByAdmin(@RequestParam("instituteCode") String instituteCode){
		Institute institute=instituteService.instituteLogin1(instituteCode);
		Institute instituteid=institute;
		List<Course> courseList=adminService.returnAllInstituteAccCourse1(instituteid);
		String jsp="ViewInstituteProfileByAdmin";
		ModelAndView mAndV=new ModelAndView();
		mAndV.addObject("courseList", courseList);
		mAndV.addObject("institute", institute);
		mAndV.setViewName(jsp);
		return mAndV;
		}
		
	
	
	//MONITORING INDUSTRY
	
		@RequestMapping(path="/monitorindustry.hr")
		public ModelAndView monitorIndustries(){
			try {
				List<Industry> industryList=adminService.monitoringIndustry1();
				
				
				String jsp="MonitorIndustries";
				ModelAndView mAndV=new ModelAndView();
				mAndV.addObject("industryList", industryList);
				mAndV.setViewName(jsp);
				return mAndV;
			} catch (Exception e) {
	          e.printStackTrace();
	          String jsp="AdminDashboard";
				ModelAndView mAndV=new ModelAndView();
			    mAndV.setViewName(jsp);
				return mAndV;
			}
			
		}
		
			//View Each institute Profile
		@RequestMapping(path="/viewindustryprofilebyadmin.hr")
		public ModelAndView monitorIndustryByAdmin(@RequestParam("industryCode") String industryCode){
			Industry industry=industryService.industryLogin1(industryCode);
			Industry industryid=industry;
			List<Job> jobList=adminService.returnsAllIndustryAccJob1(industryid);
			
			String jsp="ViewIndustryProfileByAdmin";
			ModelAndView mAndV=new ModelAndView();
			mAndV.addObject("jobList", jobList);
			mAndV.addObject("industry", industry);
			mAndV.setViewName(jsp);
			return mAndV;
			}
			
	
		//MONITORING Student
		
			@RequestMapping(path="/monitorstudent.hr")
			public ModelAndView monitorStudent(){
				try {
					List<Student> studentList=adminService.monitoringStudent1();
					
					String jsp="MonitorStudents";
					ModelAndView mAndV=new ModelAndView();
					mAndV.addObject("studentList", studentList);
					mAndV.setViewName(jsp);
					return mAndV;
				} catch (Exception e) {
		          e.printStackTrace();
		          String jsp="AdminDashboard";
					ModelAndView mAndV=new ModelAndView();
				    mAndV.setViewName(jsp);
					return mAndV;
				}
				
			}
	
			//View Each Student Profile
			@RequestMapping(path="/viewistudentprofilebyadmin.hr")
			public ModelAndView monitorStudentByAdmin(@RequestParam("studentAadharNo") String studentAadharNo){
				
				Student student=studentService.studentLogin1(studentAadharNo);
				Student studentid=student;
				List<Completedcourse> courseList=industryService.sendCompletedCourseByStudent1(studentid);
				String b="0";
				String a="1";
				if(student.getJobId().contentEquals(a) || student.getJobId().contentEquals(b)) {
				String jsp="ViewStudentProfileByAdmin1";
				ModelAndView mAndV=new ModelAndView();
				mAndV.addObject("courseList", courseList);
				mAndV.addObject("student", student);
				mAndV.setViewName(jsp);
				return mAndV;
				} else {
					String jobId=student.getJobId();
					Job job = industryService.getJobOnId1(jobId);
					String jsp="ViewStudentProfileByAdmin2";
					ModelAndView mAndV=new ModelAndView();
					mAndV.addObject("courseList", courseList);
					mAndV.addObject("student", student);
					mAndV.addObject(job);
					mAndV.setViewName(jsp);
					return mAndV;
					
				}
				}
		
		
			@RequestMapping(path="/adminlogout.hr")
			public String adminLogout(){
				return "AdminLogout";
			}
		
			@RequestMapping(path="/adminlogout1.hr")
			public String adminLogout1(){
				return "Home";
			}
		

}
	
