package com.lti.web.controllers;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Random;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.core.io.InputStreamSource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.lti.core.services.IndustryService;
import com.lti.core.services.MailService;
import com.lti.core.services.StudentService;
import com.ram.configuration.AppConfig;
import com.lti.core.entities.*;
import com.lti.core.exceptions.ScholarException;









@Controller
public class IndustryController {

	@Lazy
	@Autowired
	private MailService mailService;
	@Autowired
	private IndustryService industryService;
	@Autowired
	private StudentService studentService;
	@Autowired
    private JavaMailSender mailSender;
	
	
	/// INDUSTRY REGISTRATION
    //gives industry registration page
	@RequestMapping(path="/industryRegistration.hr", method=RequestMethod.GET)
	public String industryRegistration(){
		return "IndustryRegistration";
	}
	
	// mails otp to industry
		@RequestMapping(path="/industryRegistration.hr", method=RequestMethod.POST)
		public String addNewIndustry(HttpSession session, Industry industry){
			 String numbers = "0123456789";
		        Random rndm_method = new Random(); 
		          char[] otp = new char[4];
		            for (int i = 0; i < 4; i++) 
		            { 
		               otp[i]=numbers.charAt(rndm_method.nextInt(numbers.length()));
		            }
		            String otps = new String(otp);
		            
		            session.setAttribute("indususerid", industry.getIndustryCode());
		            session.setAttribute("industryy", industry);
		            session.setAttribute("otpindus", otps);
			
		            AbstractApplicationContext context = new AnnotationConfigApplicationContext(
							AppConfig.class);


					String senderEmailId = "NationalScholarshipPortal1234@gmail.com";
					String receiverEmailId = industry.getIndustryEmail();
					String subject = "OTP VERIFICATION!";
					String message = otps;

					mailService.sendEmail(senderEmailId, receiverEmailId, subject, message);
					context.close();            
				     
			        return "IndustryOtpPage";
			}
	
		//Checking otp match and inserting records into database for industry
		@RequestMapping(path="/industryOtp.hr", method=RequestMethod.POST)
		public String industryOtpVerification(HttpSession session,@RequestParam("industryOtp") String industryOtp) {
			System.out.println(industryOtp);
			String otp = (String) session.getAttribute("otpindus");
			
			
			try {
				if(otp.equals(industryOtp)) {
    Industry industry = (Industry)session.getAttribute("industryy");
	boolean result = industryService.insertNewIndustry1(industry);
	
	if(result) {
				  System.out.println("Industry Data Successfully Entered. ");
	return "IndustrySetPass";
				} else {
				return "Home";	
				}
	} else {
				return "Home";}
			} catch (Exception e) {
				return "IndustryFailedRegistration";
			}
		}
	
	////INDUSTRY SET PASSWORD
		
				@RequestMapping(path="/industrySetPassword.hr", method=RequestMethod.POST)
				public String studentSetPass(HttpSession session,@RequestParam("industryPassword") String industryPassword) {
					String industryCode =(String)session.getAttribute("indususerid");
					String industryPasswordCrypt = BCrypt.hashpw(industryPassword, BCrypt.gensalt());
					
				boolean passResult = industryService.setPassForIndustry1(industryCode, industryPasswordCrypt);
				
				session.removeAttribute("indususerid");
				session.removeAttribute("otpindus");
				session.removeAttribute("industryy");
			    session.invalidate();
	            return "IndustryLogin";			
				
				}
		
		
//INDUSTRY FORGOT PASS 
				
//gives enter Id Page
		@RequestMapping(path="/industryforgotpass.hr", method=RequestMethod.GET)
		public String forgotPass1(){
		return "EnterIndustryLoginId";
		}
				
	//directs to Otp page
	@RequestMapping(path="/industryforgotpass.hr", method=RequestMethod.POST)
	public String forgotPass2(HttpSession session,@RequestParam("id") String industryCode) {
							
		try {
	Industry industry1=industryService.industryLogin1(industryCode);
								
		if(industry1!=null) {
		 String numbers = "0123456789";
	  Random rndm_method = new Random(); 
	  char[] otp = new char[4];
	  for (int i = 0; i < 4; i++) 
   { 
      otp[i]=numbers.charAt(rndm_method.nextInt(numbers.length()));
     }
		 String otps = new String(otp);
								            
	 session.setAttribute("indususerid", industry1.getIndustryCode());
											 
	session.setAttribute("otpindus", otps); 
											  
	 AbstractApplicationContext context = new AnnotationConfigApplicationContext(
			AppConfig.class);


		String senderEmailId = "NationalScholarshipPortal1234@gmail.com";
	    String receiverEmailId = industry1.getIndustryEmail();
		String subject = "OTP VERIFICATION!";
		String message = otps;

		mailService.sendEmail(senderEmailId, receiverEmailId, subject, message);
				context.close();            
											     
	return "IndustryOtpPage2";
	} else {
		return "Home";
	}
} catch (Exception e) {
		return "Home";
		}
	}
						
						
	// Directs industry to SET PASS PAGE
		@RequestMapping(path="/industryotpforforgotpass.hr", method=RequestMethod.POST)
		public String industryOtpVerificationForgotPass(HttpSession session,@RequestParam("industryOtp") String industryOtp){
		System.out.println(industryOtp);
		String otp = (String) session.getAttribute("otpindus");
										
			if(otp.equals(industryOtp)) {
				session.removeAttribute("otpindus");
			 return "IndustrySetPass";
			} else {
				session.removeAttribute("otpindus");
			 return "Home";	
				}
									
		}
		
		//Change pass
		@RequestMapping(path="/industrychangepass.hr", method=RequestMethod.GET)
		public String industryChangePass(){
		return "IndustrySetPass";				
						
		}	
		
		
		// Industry Login
				@RequestMapping(path="/industrylogin.hr", method=RequestMethod.GET)
				public String studentLoginPage(){
					return "IndustryLogin";
				}
		
				
				@RequestMapping(path="/industrydashboard.hr", method=RequestMethod.POST)
				public ModelAndView instituteLogin(Model model,HttpSession session,@RequestParam("industryPassword") String industryPassword, @RequestParam("industryCode") String industryCode) {
					
					try {
						
						Industry industry = industryService.industryLogin1(industryCode);
						if(BCrypt.checkpw(industryPassword, industry.getIndustryPassword()))
						{
							session.setAttribute("loggedindustry", industry);
							 session.setAttribute("indususerid", industry.getIndustryCode());
							 String jspName=  "IndustryDashboard";
							 ModelAndView mAndV=new ModelAndView();
								mAndV.addObject("industry",industry);
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
		
		
	// Institute EDIT PROFILE
	@RequestMapping(path="/industryeditprofile.hr", method=RequestMethod.GET)
	  public ModelAndView industryEditProfile(Model model, HttpSession session) {
					
					 
		 String industryCode = (String)session.getAttribute("indususerid");
		 Industry industry = industryService.industryLogin1(industryCode);
		
			System.out.println(industry);
					     
			String jspName= "IndustryEditProfile";
			ModelAndView mAndV=new ModelAndView();
			mAndV.addObject("industry",industry);
			mAndV.setViewName(jspName);
			return mAndV;
						
			}	
				
				@RequestMapping(path="/industryeditprofile.hr", method=RequestMethod.POST)
				public String industryEditProfile1(Model model, HttpSession session, Industry industry) {
				System.out.println(industry);
				
				String industryCode=(String)session.getAttribute("indususerid");
				industry.setIndustryCode(industryCode);
			 
				boolean editResult1 = industryService.editProfileForIndustry1(industry);
				if(editResult1)
				return "IndustryDashboard";
				else
					return "IndustryEditProfile";
				}	
		
		
				
		//INDUSTRY ADD JOB
				//gives add job page
				@RequestMapping(path="/addjob.hr", method=RequestMethod.GET)
				public String addJob1(){
				return "AddJob";
				}	
			
				@RequestMapping(path="/addjob.hr", method=RequestMethod.POST)
				public ModelAndView addJob2(Job job, HttpSession session){
				String industryCode=(String)session.getAttribute("indususerid");
				Industry industryid=industryService.industryLogin1(industryCode);
				boolean result=industryService.insertNewJob1(job, industryid);
				Industry industry=industryid;
				String jsp="IndustryDashboard";
				ModelAndView mAndV=new ModelAndView();
				mAndV.addObject("industry", industry);
				mAndV.setViewName(jsp);
				return mAndV;
				}			
				
		//Industry View Job Status
				
				@RequestMapping(path="/industryviewjobstatus.hr", method=RequestMethod.GET)
				public ModelAndView industryViewJobStatus(HttpSession session){
					try {
						String industryCode=(String)session.getAttribute("indususerid");
						Industry industryid=industryService.industryLogin1(industryCode);
						List<Job> jobStatusList=industryService.viewJobStatus1(industryid);
						
						String jspName="ViewAddJobStatus";
						ModelAndView mAndV=new ModelAndView();
						mAndV.addObject("jobStatusList", jobStatusList);
						mAndV.setViewName(jspName);
						return mAndV;
					} catch (Exception e) {
						e.printStackTrace();
						String jspName="NoPostedJobs";
						ModelAndView mAndV=new ModelAndView();
						mAndV.setViewName(jspName);
						return mAndV;
					}
				}	
				
				///update job status by Industry
				@RequestMapping(path="/updatejobstatusbyindustry.hr")
				public ModelAndView updateJobStatusByInstitute(HttpSession session) {
					String industryCode=(String)session.getAttribute("indususerid");
					try {
						
						Industry industryid=industryService.industryLogin1(industryCode);
						Industry industry = industryid;
						int ress=industryService.updateJobStatusByIndustry1(industryid);
						
							String jspName= "IndustryDashboard";
							ModelAndView mAndV=new ModelAndView();
							mAndV.addObject("industry",industry);
							mAndV.setViewName(jspName);
							return mAndV;
					} catch (Exception e) {
					
						e.printStackTrace();
						Industry industry=industryService.industryLogin1(industryCode);
						
						String jspName= "IndustryDashboard";
						ModelAndView mAndV=new ModelAndView();
						mAndV.addObject("industry",industry);
						mAndV.setViewName(jspName);
						return mAndV;
					}
				}
				
				
				///View Courses To Hire
				//returns course list
				@RequestMapping(path="/viewcoursestohire.hr", method=RequestMethod.GET)
				public ModelAndView industryViewCourses(HttpSession session){
					
					try {
						List<Course> courseList=studentService.viewCourseByStudent1();
						String jsp="IndustryViewCourse";
						
						ModelAndView mAndV = new ModelAndView();
						mAndV.addObject("courseList", courseList);
						mAndV.setViewName(jsp);
						return mAndV;
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
	                   String jsp="IndustryDashboard";
	                   String industryCode=(String)session.getAttribute("indusuderid");
						Industry industry=industryService.industryLogin1(industryCode);
						ModelAndView mAndV = new ModelAndView();
						mAndV.addObject("industry", industry);
						mAndV.setViewName(jsp);
						return mAndV;
					}
				}	
				
				//returns student list certified in the course
				@RequestMapping(path="/viewstudentcertifiedcourse.hr", method=RequestMethod.GET)
				public ModelAndView industryRegistration(@RequestParam("courseId") String courseId, HttpSession session){
					String compCourseId=courseId;
					try {
						List<Completedcourse> stdList=industryService.returnsStudentList1(compCourseId);
						String jsp="IndustryViewStudentAccCourse";
						ModelAndView mAndV=new ModelAndView();
						mAndV.addObject("stdList", stdList);
						mAndV.setViewName(jsp);
						return mAndV;
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						String industryCode=(String)session.getAttribute("indusuderid");
						Industry industry=industryService.industryLogin1(industryCode);
						String jsp="IndustryDashboard";
						ModelAndView mAndV=new ModelAndView();
						mAndV.addObject("industry", industry);
						mAndV.setViewName(jsp);
						return mAndV;
						
						
						
					}
					
				}		
				
				
				
				
	
	  //returns student profile
	  
	  @RequestMapping(path="/viewstudentprofile.hr", method=RequestMethod.GET)
	  public ModelAndView industryRegistration(HttpSession session, @RequestParam("studentAadharNo") String studentAadharNo, @RequestParam("courseId") String courseId){ 
	
		  Student studentid=studentService.studentLogin1(studentAadharNo);
		  List<Completedcourse> courseList=industryService.sendCompletedCourseByStudent1(studentid);
		  
		  Student student=studentid;
		  
		  String industryCode=(String)session.getAttribute("indususerid");
		  Industry industryid=industryService.industryLogin1(industryCode);
		  List<Job> jobList=industryService.ViewAccJob1(industryid);
		  
		  String jsp="ViewStudentProfile";
		  
		  
		  ModelAndView mAndV=new ModelAndView();
		  mAndV.addObject("courseId", courseId);
		  mAndV.addObject(jobList);
		  mAndV.addObject("courseList", courseList);
		  mAndV.addObject(student);
		  mAndV.setViewName(jsp);
	      return mAndV;
	  
	  }
	 
				
		//sends  job to student		
	  @RequestMapping(path="/industrysendjob.hr", method=RequestMethod.POST)			
		public ModelAndView industrySendjob(@RequestParam("studentAadharNo") String studentAadharNo,@RequestParam("jobId") String jobId, @RequestParam("courseId") String courseId)  {
		System.out.println(studentAadharNo); 
		System.out.println(jobId);
		Job job=industryService.getJobOnId1(jobId);
		String appJobName=job.getJobName();
		String appJobDescription=job.getJobDescription();
		Student studentjid=studentService.studentLogin1(studentAadharNo);
		String appJobId=jobId;
		
		try {
			Jobapply jobapp=industryService.returnsduplicatedJobapply1(studentjid, appJobId);
			
			String jsp="AlreadySent";
			ModelAndView mAndV=new ModelAndView();
			mAndV.addObject("courseId", courseId);
			mAndV.setViewName(jsp);
			return mAndV;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Jobapply jobapply=new Jobapply();
			jobapply.setAppJobId(jobId);
			jobapply.setStudentjid(studentjid);
			jobapply.setAppByStudent("0");
			jobapply.setAppByIndustry("1");
			jobapply.setAppAccByIndustry("1");
			jobapply.setAppAccByStudent("0");
			jobapply.setAppJobName(appJobName);
			jobapply.setAppJobDescription(appJobDescription);
			int appResult=industryService.addApplicationOfJob1(jobapply);
			String jsp="JobSentSuccessfully";
			ModelAndView mAndV=new ModelAndView();
			mAndV.addObject("courseId", courseId);
			mAndV.setViewName(jsp);
	        return mAndV;
		}
		
		
		
		
	  }		
				
		//industry view students applying for job posts		
	  @RequestMapping(path="/viewstudentappliedforjobaccjobpost.hr", method=RequestMethod.GET)
		public ModelAndView industryViewStudentApplyingForJobAccJob(HttpSession session){
		  String industryCode=(String)session.getAttribute("indususerid");
		  Industry industryid=industryService.industryLogin1(industryCode);
		  List<Job> jobList=industryService.ViewAccJob1(industryid);
		  
		  String jsp="JobListForIndustry";
		  ModelAndView mAndV=new ModelAndView();
		  mAndV.addObject(jobList);
		  mAndV.setViewName(jsp);
		  return mAndV;
		  
		}		
				
				
	  @RequestMapping(path="/viewstudentsappliedjob.hr")
		public ModelAndView industryViewStudentApplyingForJob(HttpSession session, @RequestParam("jobId") String jobId){
		 
		  String appJobId=jobId;
		  List<Jobapply> jobapplyList=industryService.returnsStudentAppliedJob1(appJobId);
		  
		  
		  
		  String jsp="StudentAppliedJobListForIndustry";
		  ModelAndView mAndV=new ModelAndView();
		  mAndV.addObject(jobapplyList);
		  mAndV.setViewName(jsp);
		  return mAndV;
		  
		}			
				
		
//industry views student profile who applied for job post		
@RequestMapping(path="/viewstudentprofilejobapply.hr")
	public ModelAndView industryViewStudentProfileApplyingForJob(HttpSession session, @RequestParam("jobId") String jobId, @RequestParam("studentAadharNo") String studentAadharNo){
	 
	  Student student=studentService.studentLogin1(studentAadharNo);
	  
	  Student studentid=studentService.studentLogin1(studentAadharNo);
	  List<Completedcourse> courseList=industryService.sendCompletedCourseByStudent1(studentid);
	  
	  String jsp="ViewStudentProfile2";
	  ModelAndView mAndV=new ModelAndView();
	  mAndV.addObject(student);
	  mAndV.addObject("courseList", courseList);
	  mAndV.addObject("jobId", jobId);
	  mAndV.setViewName(jsp);
	  return mAndV;
	  
	}		
		
		
//Industry Accepts student		
@RequestMapping(path="/accstudentapplyjob.hr")
public ModelAndView industryAccStudentApplyingForJob(HttpSession session, @RequestParam("jobId") String jobId, @RequestParam("studentAadharNo") String studentAadharNo){
 
  Student studentjid=studentService.studentLogin1(studentAadharNo);
  String appJobId=jobId;
  
  int acc=industryService.accStudentByIndustry1(studentjid, appJobId);
  
  
  List<Jobapply> jobapplyList=industryService.returnsStudentAppliedJob1(appJobId);
  
  
  
  String jsp="StudentAppliedJobListForIndustry";
  ModelAndView mAndV=new ModelAndView();
  mAndV.addObject(jobapplyList);
  mAndV.setViewName(jsp);
  return mAndV;
  
}		
// industr rejects students
@RequestMapping(path="/rejstudentapplyjob.hr")
public ModelAndView industryRejStudentApplyingForJob(HttpSession session, @RequestParam("jobId") String jobId, @RequestParam("studentAadharNo") String studentAadharNo){
 
  Student studentjid=studentService.studentLogin1(studentAadharNo);
  String appJobId=jobId;
  
  int rej=industryService.rejStudentByIndustry1(studentjid, appJobId);
  
  List<Jobapply> jobapplyList=industryService.returnsStudentAppliedJob1(appJobId);
  
  
  
  String jsp="StudentAppliedJobListForIndustry";
  ModelAndView mAndV=new ModelAndView();
  mAndV.addObject(jobapplyList);
  mAndV.setViewName(jsp);
  return mAndV;
  
}				
		
	//industry send letter of employment to Hired Students
@RequestMapping(path="/sendofferletter.hr")
public ModelAndView industryViewsJobToSendOFFER(HttpSession session){
	String industryCode=(String)session.getAttribute("indususerid");
	Industry industryid=industryService.industryLogin1(industryCode);
	List<Job> jobList=industryService.ViewAccJob1(industryid);

	  String jsp="ListOfJobForLetterEmp";
	  ModelAndView mAndV=new ModelAndView();
	  mAndV.addObject(jobList);
	  mAndV.setViewName(jsp);
	  return mAndV;
}
//list of hired students
@RequestMapping(path="/viewstudenthiredjob.hr")
public ModelAndView industryViewHiredStdAcctoJob(HttpSession session, @RequestParam("jobId") String jobId){
	
	List<Jobapply> jobapplyList=industryService.returnStudentHiredAccJob1(jobId);

	  String jsp="ListOfStudentForLetterEmp";
	  ModelAndView mAndV=new ModelAndView();
	  mAndV.addObject(jobapplyList);
	  mAndV.setViewName(jsp);
	  return mAndV;
}	
		
		
	


@RequestMapping(path="/sendstudentjobletter.hr")
public ModelAndView certifiesStudent(HttpSession session, @RequestParam("studentAadharNo") String studentAadharNo, @RequestParam("jobId") String jobId) {
	
	Student studentid=studentService.studentLogin1(studentAadharNo);
	session.setAttribute("studentid", studentid);
	session.setAttribute("jobId", jobId);
	
	ModelAndView mAndV=new ModelAndView();
	String jsp="SendLetterPage";
	mAndV.setViewName(jsp);
	return mAndV;
	
} 
//mailing Attachment
@RequestMapping(path="/emailempletter.hr", method = RequestMethod.POST)
public ModelAndView sendAttachment(HttpSession session, HttpServletRequest request, @RequestParam("attachFile") CommonsMultipartFile attachFile) {
	
	Student studentid=(Student)session.getAttribute("studentid");
	String jobId=(String)session.getAttribute("jobId");
	
	try {
		String emailTo=studentid.getStudentEmail();
		String subject ="Employyment Letter";
		String message ="Congratulations getting Hired!!";

// for logging
		System.out.println("emailTo: " + emailTo);
		System.out.println("subject: " + subject);
		System.out.println("message: " + message);
		System.out.println("attachFile: " + attachFile.getOriginalFilename());

		
		mailSender.send(new MimeMessagePreparator() {
			 
		
		    public void prepare(MimeMessage mimeMessage) throws Exception {
		        MimeMessageHelper messageHelper = new MimeMessageHelper(
		                mimeMessage, true, "UTF-8");
		        messageHelper.setTo(emailTo);
		        messageHelper.setSubject(subject);
		        messageHelper.setText(message);
		         
		        // determines if there is an upload file, attach it to the e-mail
		        String attachName = attachFile.getOriginalFilename();
		        if (!attachFile.equals("")) {

		            messageHelper.addAttachment(attachName, new InputStreamSource() {
		                 
		                public InputStream getInputStream() throws IOException {
		                    return attachFile.getInputStream();
		                }
		            });
		        }
		         
		    }

		});
		;
		
		
	} catch (Exception e) {
		e.printStackTrace();
		
	}
	Student studentjid=studentid;
	//deleting record Database
	int del=industryService.delfinalFromJobapply1(studentjid);
	//returning students left for letter
	List<Jobapply> jobapplyList=industryService.returnStudentHiredAccJob1(jobId);
	
	session.removeAttribute(jobId);
	session.removeAttribute("studentid");

	  String jsp="ListOfStudentForLetterEmp";
	  ModelAndView mAndV=new ModelAndView();
	 mAndV.addObject("jobapplyList", jobapplyList);
	  mAndV.setViewName(jsp);
	  return mAndV;
	
}





















		
		
		
		
		
		
		
				/// Industry LOGOUT
				@RequestMapping(path="/industrylogout.hr", method=RequestMethod.GET)
				public String industryLogout(HttpSession session){
					session.removeAttribute("indususerid");
				    session.removeAttribute("loggedindustry");
			        session.invalidate();
					return "Home";

				}	
				
				//RETURNING INSTITUTE DASHBOARD

				@RequestMapping(path="/returnindustrydashboard.hr")
				public ModelAndView returnIndustryDashboard(HttpSession session) {
					
					String industryCode=(String)session.getAttribute("indususerid");
					    Industry industry=industryService.industryLogin1(industryCode);
						String jspName= "IndustryDashboard";
						ModelAndView mAndV=new ModelAndView();
						mAndV.addObject("industry",industry);
						mAndV.setViewName(jspName);
						return mAndV;
				}	
		
		
		
		
}
