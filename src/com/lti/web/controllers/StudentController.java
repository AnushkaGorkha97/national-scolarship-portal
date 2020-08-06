package com.lti.web.controllers;

import com.lti.core.entities.*;
import com.lti.core.exceptions.ScholarException;
import com.lti.core.services.StudentService;


import java.io.File;
import java.io.IOException;
import java.io.BufferedInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;

import org.apache.catalina.session.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamSource;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.support.AbstractApplicationContext;

import com.ram.configuration.AppConfig;
import com.lti.core.services.AdminService;
import com.lti.core.services.IndustryService;
import com.lti.core.services.MailService;
import com.lti.core.services.MailServiceImpl;






//this is for ONLINE PORTAL
@Controller
public class StudentController {
	@Lazy
	@Autowired
	private MailService mailService;
	@Autowired
	private StudentService studentService;
	@Autowired
	private AdminService adminService;
	@Autowired
	private IndustryService industryService;
	
	/// STUDENT REGISTRATION
	        //gives student registration page
			@RequestMapping(path="/studentRegistration.hr", method=RequestMethod.GET)
			public String studentRegistration(){
				return "StudentRegistration";
			}
	
	       // mails otp after student fill details in student registration form
			@RequestMapping(path="/studentRegistration.hr", method=RequestMethod.POST)
			public String addNewStudent(Student student, HttpSession session, HttpServletRequest request) {
				
				
				 String numbers = "0123456789";
			        Random rndm_method = new Random(); 
			          char[] otp = new char[4];
			            for (int i = 0; i < 4; i++) 
			            { 
			               otp[i]=numbers.charAt(rndm_method.nextInt(numbers.length()));
			            }
			            String otps = new String(otp);
			           
						 session.setAttribute("userid", student.getStudentAadharNo());
						 session.setAttribute("students", student);  
						 session.setAttribute("otpstd", otps); 
						  
		               AbstractApplicationContext context = new AnnotationConfigApplicationContext(
									AppConfig.class);

	
							String senderEmailId = "NationalScholarshipPortal1234@gmail.com";
							String receiverEmailId = student.getStudentEmail();
							String subject = "OTP VERIFICATION!";
							String message = otps;

							mailService.sendEmail(senderEmailId, receiverEmailId, subject, message);
							context.close();            
						     
					        return "OtpPage";
		
			}
			
	       //Checking otp match and inserting records into database
			@RequestMapping(path="/studentOtp.hr", method=RequestMethod.POST)
			public String studentOtpVerification(HttpSession session,@RequestParam("studentOtp") String studentOtp) {
				System.out.println(studentOtp);
				String otp = (String) session.getAttribute("otpstd");
				
				
				try {
					if(otp.equals(studentOtp)) {
  Student student = (Student)session.getAttribute("students");
  boolean result =studentService.insertNewStudent1(student);
  if(result) {
					  System.out.println("Student Data Successfully Entered. ");
 return "StudentSetPass";
					} else {
					return "Home";	
					}
} else {
					return "Home";}
				} catch (Exception e) {
					return "FailedRegistration";
				}
			}
			
			
		////STUDENT SET PASSWORD
			
			@RequestMapping(path="/studentSetPassword.hr", method=RequestMethod.POST)
			public String studentSetPass(HttpSession session,@RequestParam("studentPassword") String studentPassword) {
				String studentAadharNo =(String)session.getAttribute("userid");
				String studentPasswordCrypt = BCrypt.hashpw(studentPassword, BCrypt.gensalt());
				
			boolean passResult = studentService.setPassForStudent1(studentAadharNo, studentPasswordCrypt);
			
			session.removeAttribute("userid");
			session.removeAttribute("otpstd");
			session.removeAttribute("students");
		    session.invalidate();
            return "StudentLogin";			
			
			}
		//STUDENT FORGOT PASS
			 //gives student registration page
			@RequestMapping(path="/studentforgotpass.hr", method=RequestMethod.GET)
			public String forgotPass1(){
				return "EnterLoginId";
			}
			//directs to Otp page
			@RequestMapping(path="/studentforgotpass.hr", method=RequestMethod.POST)
			public String forgotPass2(HttpSession session,@RequestParam("id") String studentAadharNo) {
				
				try {
					Student student1 = studentService.studentLogin1(studentAadharNo);
					if(student1!=null) {
						 String numbers = "0123456789";
					        Random rndm_method = new Random(); 
					          char[] otp = new char[4];
					            for (int i = 0; i < 4; i++) 
					            { 
					               otp[i]=numbers.charAt(rndm_method.nextInt(numbers.length()));
					            }
					            String otps = new String(otp);
					            
								 session.setAttribute("userid", student1.getStudentAadharNo());
								 
								 session.setAttribute("otpstd", otps); 
								  
					           AbstractApplicationContext context = new AnnotationConfigApplicationContext(
											AppConfig.class);


									String senderEmailId = "NationalScholarshipPortal1234@gmail.com";
									String receiverEmailId = student1.getStudentEmail();
									String subject = "OTP VERIFICATION!";
									String message = otps;

									mailService.sendEmail(senderEmailId, receiverEmailId, subject, message);
									context.close();            
								     
							        return "StudentOtp2";
					} else {
					return "Home";
					}
				} catch (Exception e) {
					return "Home";
				}
			}
			
			
			// Directs student to SET PASS PAGE
			@RequestMapping(path="/studentotpforforgotpass.hr", method=RequestMethod.POST)
			public String studentOtpVerificationForgotPass(HttpSession session,@RequestParam("studentOtp") String studentOtp) {
				System.out.println(studentOtp);
				String otp = (String) session.getAttribute("otpstd");
				
				
				if(otp.equals(studentOtp)) {
			 
			 return "StudentSetPass";
				} else {
				return "Home";	
				}
			
			}
			
			//Change pass
			@RequestMapping(path="/studentchangepass.hr", method=RequestMethod.GET)
			public String studentChangePass(){
				return "StudentSetPass";
			}
			
			
			
			
	// Student Login
			@RequestMapping(path="/studentlogin.hr", method=RequestMethod.GET)
			public String studentLoginPage(){
				return "StudentLogin";
			}
	
			
			@RequestMapping(path="/studentdashboard.hr", method=RequestMethod.POST)
			public ModelAndView studentLogin(HttpSession session,@RequestParam("studentPassword") String studentPassword, @RequestParam("studentAadharNo") String studentAadharNo) {
				try {
					Student student = studentService.studentLogin1(studentAadharNo);
					if(BCrypt.checkpw(studentPassword, student.getStudentPassword()))
					{
						
						 session.setAttribute("userid", student.getStudentAadharNo());
						 String jspName=  "StudentDashboard";
						 ModelAndView mAndV=new ModelAndView();
							mAndV.addObject("student",student);
							mAndV.setViewName(jspName);
							return mAndV;
					} else {
						 ModelAndView mAndV=new ModelAndView();
						 String jspName=  "Home";
							mAndV.setViewName(jspName);
							return mAndV;
					}
				} catch (Exception e) {
					 ModelAndView mAndV=new ModelAndView();
					 String jspName=  "Home";
						mAndV.setViewName(jspName);
						return mAndV;
				}
			
			}
			
			// STUDENT EDIT PROFILE
			@RequestMapping(path="/studenteditprofile.hr", method=RequestMethod.GET)
			public ModelAndView studentEditProfile(Model model, HttpSession session){
				String studentAadharNo = (String) session.getAttribute("userid");
				Student student = studentService.studentLogin1(studentAadharNo);
				System.out.println(student);
                String jspName= "StudentEditProfile";
				
				ModelAndView mAndV=new ModelAndView();
				mAndV.addObject("student",student);
				mAndV.setViewName(jspName);
				return mAndV;
	
			}
			
			@RequestMapping(path="/studenteditprofile.hr", method=RequestMethod.POST)
			public String studentEditProfile1(Model model, HttpSession session, Student student) {
			System.out.println(student);
			String studentAadharNo=(String)session.getAttribute("userid");
			Student student1=studentService.studentLogin1(studentAadharNo);
			String studentEmail=student1.getStudentEmail();
			String studentPassword=student1.getStudentPassword();
			String studentCourseId=student1.getStudentCourseId();
			String studentCourseStatus=student1.getStudentCourseStatus();
			String studentCourseName=student1.getStudentCourseName();
			if(student.getJobId()=="")
			{String jobId=student1.getJobId();
			student.setJobId(jobId);
				System.out.println("nulllllll"+jobId);
			}
				
		
			
			student.setStudentPassword(studentPassword);
		 student.setStudentAadharNo(studentAadharNo);
		 student.setStudentEmail(studentEmail);
		 student.setStudentCourseId(studentCourseId);
		 student.setStudentCourseStatus(studentCourseStatus);
		
		 student.setStudentCourseName(studentCourseName);
			boolean editResult1 = studentService.editProfileForStudent1(student);
			if(editResult1)
			return "StudentDashboard";
			else
				return "StudentEditProfile";
			}
			
			///VIEW COURSE BY STUDENT
			@RequestMapping(path="/viewcoursebystudent.hr", method=RequestMethod.GET)
			public ModelAndView studentViewCourse(HttpSession session){
				
				try {
					List<Course> courseList=studentService.viewCourseByStudent1();
					String jsp="StudentViewCourse";
					
					ModelAndView mAndV = new ModelAndView();
					mAndV.addObject("courseList", courseList);
					mAndV.setViewName(jsp);
					return mAndV;
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
                   String jsp="StudentDashboard";
					String studentAadharNo=(String)session.getAttribute("userid");
					Student student=studentService.studentLogin1(studentAadharNo);
					ModelAndView mAndV = new ModelAndView();
					mAndV.addObject("student", student);
					mAndV.setViewName(jsp);
					return mAndV;
				}
			}	
			
			//Apply Course By Student
			
			@RequestMapping(path="/applycoursebystudent.hr")
			public String studentApplyCourse(HttpSession session, @RequestParam("courseId") String studentCourseId){
				String studentAadharNo =(String)session.getAttribute("userid"); 
				String compCourseId=studentCourseId;
				Student studentid=studentService.studentLogin1(studentAadharNo);
				
				String courseId=studentCourseId;
				Student student=studentService.studentLogin1(studentAadharNo);
			    String id="0";
				if(student.getStudentCourseId().contentEquals(id))
				{ 
					
		try {
			Completedcourse check=studentService.CheckStudentapplyingSameCourse1(compCourseId, studentid);
			return "StudentCourseCantApply2";
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Course course=studentService.returnCourseOnId1(courseId);
			String studentCourseName=course.getCourseName();
				int app=studentService.applyForCourse1(studentCourseId, studentAadharNo, studentCourseName);
				return "StudentCourseApplied";
		}
					
				}
				else {
					return "StudentCourseCantApply";
				}
				
				
			}
			
//VIEW APPLIED COURSE BY STUDENT
			
			@RequestMapping(path="/viewcurrentcoursebystudent.hr", method=RequestMethod.GET)
			public ModelAndView studentCurrentCourse(HttpSession session){
				String studentAadharNo=(String)session.getAttribute("userid");
				Student student=studentService.studentLogin1(studentAadharNo);
				String zero="0";
				String studentCourseId=student.getStudentCourseId();
				String studentCourseStatus=student.getStudentCourseStatus();
				if(studentCourseId.contentEquals(zero)) {
					String jsp="NoAppliedCourse";
					ModelAndView mAndV=new ModelAndView();
					mAndV.setViewName(jsp);
					return mAndV;
				} else if(studentCourseStatus.contentEquals(zero)) {
					String jsp="WaitingForAccCourse";
					ModelAndView mAndV=new ModelAndView();
					mAndV.setViewName(jsp);
					return mAndV;
				} else {
					String courseId=studentCourseId;
					Course course=studentService.returnCourseOnId1(courseId);
					String jsp="CurrentCourse";
					ModelAndView mAndV=new ModelAndView();
					mAndV.addObject("course", course);
					mAndV.setViewName(jsp);
					return mAndV;
				}
				
			}		
			
			
			//directing student to test page
			@RequestMapping(path="/givetest.hr", method=RequestMethod.GET)
			public ModelAndView studentGivesTest(HttpSession session, @RequestParam("courseId") String courseId){
			Course course=studentService.returnCourseOnId1(courseId);
			String jsp="StudentTestPage";
			ModelAndView mAndV=new ModelAndView();
			mAndV.addObject("course", course);
			mAndV.setViewName(jsp);
			return mAndV;
			}
			
			
			//after student gives test
			@RequestMapping(path="/studenttestresult.hr", method=RequestMethod.POST)
			public String studenttestresult(HttpSession session,@RequestParam("courseQ1A") String courseQ1A, @RequestParam("courseQ2A") String courseQ2A, @RequestParam("courseQ3A") String courseQ3A) {
			    
				String studentAadharNo=(String)session.getAttribute("userid");
				Student student=studentService.studentLogin1(studentAadharNo);
				String courseId=student.getStudentCourseId();
				Course course=studentService.returnCourseOnId1(courseId);
				String courseName=course.getCourseName();
				
				int c=0;
				if(courseQ1A.contentEquals(course.getCourseQ1A()))
					c++;
				if(courseQ2A.contentEquals(course.getCourseQ2A()))
					c++;
				if(courseQ3A.contentEquals(course.getCourseQ3A()))
					c++;
				if(c<2) {
					return "StudentNotPass";
				} else {
					String compScore=Integer.toString(c);
					Student studentid=studentService.studentLogin1(studentAadharNo);
					Completedcourse completedcourse=new Completedcourse();
					
					completedcourse.setCompStdId(studentAadharNo);
					completedcourse.setCompCourseId(courseId);
					completedcourse.setCompName(courseName);
					completedcourse.setStudentid(studentid);
					completedcourse.setCompScore(compScore);
					int result=studentService.addCompletedCourse0(completedcourse);
					int result1=adminService.rejStudentReqByAdmin1(studentAadharNo);
					return "StudentPass";
					}				
			}
			
			
		//students view job to apply
			@RequestMapping(path="/searchjobbystudent.hr", method=RequestMethod.GET)
			public ModelAndView studentSearchJob(HttpSession session){
				String studentAadharNo=(String)session.getAttribute("userid");
				Student student=studentService.studentLogin1(studentAadharNo);
				if(student.getJobId().contentEquals("0")) {
				List<Job> jobList=studentService.searchJobByStudent1();
				
				String jsp="SearchJobByStudent";
				ModelAndView mAndV=new ModelAndView();
				mAndV.addObject(jobList);
				mAndV.setViewName(jsp);
				return mAndV;
				} else if(student.getJobId().contentEquals("1")) {
					String jsp="EmpFromOut";
					ModelAndView mAndV=new ModelAndView();
					mAndV.setViewName(jsp);
			        return mAndV;	
				} else {
				String jsp="AlreadyEmployed";
				ModelAndView mAndV=new ModelAndView();
				mAndV.setViewName(jsp);
				return mAndV;
					
				}
				}
			//student Applies for job
			@RequestMapping(path="/applyjobbystudent.hr", method=RequestMethod.GET)
			public ModelAndView studentApplyJob(HttpSession session, @RequestParam("jobId") String jobId){
				
				String appJobId=jobId;
				String studentAadharNo=(String)session.getAttribute("userid");
				Student studentjid=studentService.studentLogin1(studentAadharNo);
				Job job=industryService.getJobOnId1(jobId);
				String appJobName=job.getJobName();
				String appJobDescription=job.getJobDescription();
				try {
					Jobapply jobapp=industryService.returnsduplicatedJobapply1(studentjid, appJobId);
					
					String jsp="AlreadyAppliedJob";
					ModelAndView mAndV=new ModelAndView();
					mAndV.addObject("jobId", jobId);
					mAndV.setViewName(jsp);
					return mAndV;
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					Jobapply jobapply=new Jobapply();
					jobapply.setAppJobId(jobId);
					jobapply.setStudentjid(studentjid);
					jobapply.setAppByStudent("1");
					jobapply.setAppByIndustry("0");
					jobapply.setAppAccByIndustry("0");
					jobapply.setAppAccByStudent("0");
					jobapply.setAppJobName(appJobName);
					jobapply.setAppJobDescription(appJobDescription);
					int appResult=industryService.addApplicationOfJob1(jobapply);
					String jsp="JobAppliedSuccessfully";
					ModelAndView mAndV=new ModelAndView();
					mAndV.addObject("jobId", jobId);
					mAndV.setViewName(jsp);
			        return mAndV;
				}
				
				
				}
	// STUDENT VIEW EMPLOYMENT
			
			@RequestMapping(path="/viewemployment.hr")
			public ModelAndView studentViewEmployment(HttpSession session){
				String studentAadharNo=(String)session.getAttribute("userid");
				Student student=studentService.studentLogin1(studentAadharNo);
				String jobId=student.getJobId();
				String emp="1";
				String empo="0";
				if(jobId.contentEquals(emp)) {
					String jsp="EmpFromOut";
					ModelAndView mAndV=new ModelAndView();
					mAndV.setViewName(jsp);
			        return mAndV;	
					
				} else if(jobId.contentEquals(empo)) {
					
					Student studentjid=studentService.studentLogin1(studentAadharNo);
					List<Jobapply> jobapplyList=studentService.returnStudentStatusOfApplyjob1(studentjid);
					String jsp="JobApplyStatus";
					ModelAndView mAndV=new ModelAndView();
					mAndV.addObject(jobapplyList);
					mAndV.setViewName(jsp);
			        return mAndV;
					
				
					
				} else {
					
					Job job=industryService.getJobOnId1(jobId);
					String jsp="EmpStatus";
					ModelAndView mAndV=new ModelAndView();
					mAndV.addObject("job", job);
					mAndV.setViewName(jsp);
			        return mAndV;
					
				}
				
				
			}	
			//student view Job Details
			@RequestMapping(path="/viewjobdetails.hr")
			public ModelAndView studentViewJobDetails(HttpSession session, @RequestParam("jobId") String jobId){
				Job job= industryService.getJobOnId1(jobId);
				String jsp="StudentViewJobDetails";
						ModelAndView mAndV=new ModelAndView();
				       mAndV.addObject("job", job);
				       mAndV.setViewName(jsp);
		                return mAndV;
	
			}	
			
			
			//student rejects job
			@RequestMapping(path="/rejjobbystudent.hr")
			public String studentRejectJob(HttpSession session, @RequestParam("jobId") String jobId){
				String appJobId=jobId;
				String studentAadharNo=(String)session.getAttribute("userid");
				Student studentjid=studentService.studentLogin1(studentAadharNo);
				int rej=studentService.rejJobByStudent1(appJobId, studentjid);
				return "StudentRejJob";
	
			}	
			//student accepts job
			@RequestMapping(path="/accjobbystudent.hr")
			public ModelAndView studentAcceptJob(HttpSession session, @RequestParam("jobId") String jobIdd){
				
				String appJobId=jobIdd;
				String studentAadharNo=(String)session.getAttribute("userid");
				Student studentjid=studentService.studentLogin1(studentAadharNo);
				
				int acc=studentService.accJobByStudent1(studentjid, appJobId);
	            int acc1=studentService.accJobByStudentB1(studentAadharNo, appJobId);
	            
				try {
					int acc0=studentService.accJobByStudentA1(studentjid);
					Student student=studentService.studentLogin1(studentAadharNo);
					String jobId=student.getJobId();
					Job job=industryService.getJobOnId1(jobId);
					String jsp="EmpStatus";
					ModelAndView mAndV=new ModelAndView();
					mAndV.addObject("job", job);
					mAndV.setViewName(jsp);
					return mAndV;
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					Student student=studentService.studentLogin1(studentAadharNo);
					String jobId=student.getJobId();
					Job job=industryService.getJobOnId1(jobId);
					String jsp="EmpStatus";
					ModelAndView mAndV=new ModelAndView();
					mAndV.addObject("job", job);
					mAndV.setViewName(jsp);
					return mAndV;
				}
	
			}		
			
			
///Viewing Archived Courses By Student
			@RequestMapping(path="/viewarchivecoursebystudent.hr")
			public ModelAndView studentViewArchiveCourses(HttpSession session) {
            String studentAadharNo=(String)session.getAttribute("userid");
				Student studentid=studentService.studentLogin1(studentAadharNo);
				List<Completedcourse> courseList=studentService.listOfArchiveCoursesForStudent1(studentid);
				String jsp="StudentArchiveCourseList";
				ModelAndView mAndV=new ModelAndView();
				mAndV.addObject("courseList", courseList);
				mAndV.setViewName(jsp);
				return mAndV;
				
				
				
			}	
			@RequestMapping(path="/archivecourselink.hr")
			public ModelAndView studentViewArchiveCourseLink(HttpSession session, @RequestParam("courseId") String courseId) {
				
		    Course course=studentService.returnCourseOnId1(courseId);
			String jsp="ArchiveCourseVideo";
			ModelAndView mAndV=new ModelAndView();
			mAndV.addObject("course", course);
			mAndV.setViewName(jsp);
			return mAndV;
				
				
				
			}		
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			/// STUDENT LOGOUT
			@RequestMapping(path="/studentlogout.hr", method=RequestMethod.GET)
			public ModelAndView studentLogout(HttpSession session){
				
				String studentAadharNo=(String)session.getAttribute("userid");
				
				Student student=studentService.studentLogin1(studentAadharNo);
				String jspName= "StudentLogout";
				ModelAndView mAndV=new ModelAndView();
				mAndV.addObject("student",student);
				mAndV.setViewName(jspName);
				return mAndV;
	
			}
			@RequestMapping(path="/studentlogout1.hr", method=RequestMethod.GET)
			public String studentLogout1(HttpSession session){
				session.removeAttribute("userid");
				
		session.invalidate();
				return "Home";
	
			}
			
			//RETURNING STUDENT DASHBOARD

			@RequestMapping(path="/returnstudentdashboard.hr")
			public ModelAndView returnStudentDashboard(HttpSession session) throws ScholarException {
				
				String studentAadharNo=(String)session.getAttribute("userid");
				
					Student student=studentService.studentLogin1(studentAadharNo);
					String jspName= "StudentDashboard";
					ModelAndView mAndV=new ModelAndView();
					mAndV.addObject("student",student);
					mAndV.setViewName(jspName);
					return mAndV;
			}
	
}
