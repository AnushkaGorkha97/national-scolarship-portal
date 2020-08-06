package com.lti.web.controllers;
import java.io.File;
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
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.lti.core.entities.*;
import com.lti.core.exceptions.ScholarException;
import com.lti.core.services.InstituteService;
import com.lti.core.services.MailService;
import com.lti.core.services.StudentService;
import com.ram.configuration.AppConfig;




// THIS IS FOR ONLINE PORTAL
@Controller
public class InstituteController {
	@Lazy
	@Autowired
	private MailService mailService;
	@Autowired
	private InstituteService instituteService;
	@Autowired
    private JavaMailSender mailSender;
	@Autowired
	private StudentService studentService;
	
	
	
	
	/// INSTITUTE REGISTRATION
    //gives institute registration page
	@RequestMapping(path="/instituteRegistration.hr", method=RequestMethod.GET)
	public String instituteRegistration(){
		return "InstituteRegistration";
	}
	
	// mails otp to institute
	@RequestMapping(path="/instituteRegistration.hr", method=RequestMethod.POST)
	public String addNewInstitute(HttpSession session, Institute institute){
		 String numbers = "0123456789";
	        Random rndm_method = new Random(); 
	          char[] otp = new char[4];
	            for (int i = 0; i < 4; i++) 
	            { 
	               otp[i]=numbers.charAt(rndm_method.nextInt(numbers.length()));
	            }
	            String otps = new String(otp);
	            
	            session.setAttribute("instuserid", institute.getInstituteCode());
	            session.setAttribute("institutes", institute);
	            session.setAttribute("otpinst", otps);
		
	            AbstractApplicationContext context = new AnnotationConfigApplicationContext(
						AppConfig.class);


				String senderEmailId = "NationalScholarshipPortal1234@gmail.com";
				String receiverEmailId = institute.getInstituteEmail();
				String subject = "OTP VERIFICATION!";
				String message = otps;

				mailService.sendEmail(senderEmailId, receiverEmailId, subject, message);
				context.close();            
			     
		        return "InstituteOtpPage";
		
		
		
	}
	
	//Checking otp match and inserting records into database for institute
	@RequestMapping(path="/instituteOtp.hr", method=RequestMethod.POST)
	public String instituteOtpVerification(HttpSession session,@RequestParam("instituteOtp") String instituteOtp) {
		System.out.println(instituteOtp);
		String otp = (String) session.getAttribute("otpinst");
		
		
		try {
			if(otp.equals(instituteOtp)) {

Institute institute = (Institute)session.getAttribute("institutes");
boolean result = instituteService.insertNewInstitute1(institute);
if(result) {
			  System.out.println("Institute Data Successfully Entered. ");
return "InstituteSetPass";
			} else {
			return "Home";	
			}
} else {
			return "Home";}
		} catch (Exception e) {
			return "InstituteFailedRegistration";
		}
	}
	
////INSTITUTE SET PASSWORD
	
			@RequestMapping(path="/instituteSetPassword.hr", method=RequestMethod.POST)
			public String studentSetPass(HttpSession session,@RequestParam("institutePassword") String institutePassword) {
				String instituteCode =(String)session.getAttribute("instuserid");
				String institutePasswordCrypt = BCrypt.hashpw(institutePassword, BCrypt.gensalt());
				
			
			boolean passResult = instituteService.setPassForInstitute1(instituteCode, institutePasswordCrypt);
			session.removeAttribute("instuserid");
			session.removeAttribute("otpinst");
			session.removeAttribute("institutes");
		    session.invalidate();
            return "InstituteLogin";			
			
			}
	
	//INSTITUTE FORGOT PASS
			
	 //gives student registration page
			@RequestMapping(path="/instituteforgotpass.hr", method=RequestMethod.GET)
			public String forgotPass1(){
				return "EnterInstituteLoginId";
			}
	
	//directs to Otp page
			@RequestMapping(path="/instituteforgotpass.hr", method=RequestMethod.POST)
			public String forgotPass2(HttpSession session,@RequestParam("id") String instituteCode) {
				
				try {
					Institute institute1 = instituteService.instituteLogin1(instituteCode);
					
					if(institute1!=null) {
						 String numbers = "0123456789";
					        Random rndm_method = new Random(); 
					          char[] otp = new char[4];
					            for (int i = 0; i < 4; i++) 
					            { 
					               otp[i]=numbers.charAt(rndm_method.nextInt(numbers.length()));
					            }
					            String otps = new String(otp);
					            
								 session.setAttribute("instuserid", institute1.getInstituteCode());
								 
								 session.setAttribute("otpinst", otps); 
								  
					           AbstractApplicationContext context = new AnnotationConfigApplicationContext(
											AppConfig.class);


									String senderEmailId = "NationalScholarshipPortal1234@gmail.com";
									String receiverEmailId = institute1.getInstituteEmail();
									String subject = "OTP VERIFICATION!";
									String message = otps;

									mailService.sendEmail(senderEmailId, receiverEmailId, subject, message);
									context.close();            
								     
							        return "InstituteOtpPage2";
					} else {
					return "Home";
					}
				} catch (Exception e) {
					return "Home";
				}
			}
			
			
// Directs student to SET PASS PAGE
		@RequestMapping(path="/instituteotpforforgotpass.hr", method=RequestMethod.POST)
		public String studentOtpVerificationForgotPass(HttpSession session,@RequestParam("instituteOtp") String instituteOtp) throws ScholarException{
				System.out.println(instituteOtp);
				String otp = (String) session.getAttribute("otpinst");
							
							
					if(otp.equals(instituteOtp)) {
						session.removeAttribute("otpinst");
					 return "InstituteSetPass";
			       } else {
			    	   session.removeAttribute("otpinst");
					 return "Home";	
					}
						
			}
						
			
//Change pass
@RequestMapping(path="/institutechangepass.hr", method=RequestMethod.GET)
public String instituteChangePass(){
return "InstituteSetPass";				
				
}
			
			// Institute Login
					@RequestMapping(path="/institutelogin.hr", method=RequestMethod.GET)
					public String studentLoginPage(){
						return "InstituteLogin";
					}
			
					
					@RequestMapping(path="/institutedashboard.hr", method=RequestMethod.POST)
					public ModelAndView instituteLogin(Model model,HttpSession session,@RequestParam("institutePassword") String institutePassword, @RequestParam("instituteCode") String instituteCode) {
						
						try {
							Institute institute = instituteService.instituteLogin1(instituteCode);
							if(BCrypt.checkpw(institutePassword, institute.getInstitutePassword()))
							{
								session.setAttribute("loggedinstitute", institute);
								 session.setAttribute("instuserid", institute.getInstituteCode());
								 String jspName=  "InstituteDashboard";
								 ModelAndView mAndV=new ModelAndView();
									mAndV.addObject("institute",institute);
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
	@RequestMapping(path="/instituteeditprofile.hr", method=RequestMethod.GET)
	  public ModelAndView instituteEditProfile(Model model, HttpSession session) throws ScholarException{
		
		 
		 String instituteCode = (String)session.getAttribute("instuserid");
		 Institute institute = instituteService.instituteLogin1(instituteCode);
		
		System.out.println(institute);
		     
		String jspName= "InstituteEditProfile";
		ModelAndView mAndV=new ModelAndView();
		mAndV.addObject("institute",institute);
		mAndV.setViewName(jspName);
		return mAndV;
			
		}	
	
	@RequestMapping(path="/instituteeditprofile.hr", method=RequestMethod.POST)
	public String instituteEditProfile1(Model model, HttpSession session, Institute institute) throws ScholarException{
	System.out.println(institute);
	
	String instituteCode=(String)session.getAttribute("instuserid");
	Institute institute1=instituteService.instituteLogin1(instituteCode);
	String institutePassword=institute1.getInstitutePassword();
	institute.setInstitutePassword(institutePassword);
	institute.setInstituteCode(instituteCode);
 
	boolean editResult1 = instituteService.editProfileForInstitute1(institute);
	if(editResult1)
	return "InstituteDashboard";
	else
		return "InstituteEditProfile";
	}
						
						
						
						
		
	
	
	
	//ADDING COURSE BYY INSTITUTE
	
	// directs institute to adding course page
	@RequestMapping(path="/addcourse.hr", method=RequestMethod.GET)
	public String addCoursePage(){
		return "InstituteAddCourse";
	}

	
	@RequestMapping(path="/addcourse.hr", method=RequestMethod.POST)
	public String addingCourse(HttpSession session, Course course)throws ScholarException{
		/*
		 * String instituteCode=(String)session.getAttribute("instuserid"); Institute
		 * instituteid= instituteService.instituteLogin1(instituteCode); boolean
		 * addcourseresult=instituteService.insertNewCourse1(course, instituteid);
		 */
		session.setAttribute("course1", course);
		return "InstituteAddCourseLink";
	}

	
	@RequestMapping(path="/uploadcourselink.hr", method=RequestMethod.POST)
	public ModelAndView uplodingdom(@RequestParam("courseLink") MultipartFile domi, HttpSession session) throws Exception {
	String path=session.getServletContext().getRealPath("uploads/");
	String finalpath = path + domi.getOriginalFilename();
/*	String studentAadhar =(String) session.getAttribute("loggedInStudent");*/

	Course course=(Course)session.getAttribute("course1");

	

		try {
			domi.transferTo(new File(finalpath));


		} catch (Exception e) {
			
			e.printStackTrace();
		}
		course.setCourseLink(domi.getOriginalFilename());
		String instituteCode=(String)session.getAttribute("instuserid");
		Institute instituteid= instituteService.instituteLogin1(instituteCode);
		boolean addcourseresult=instituteService.insertNewCourse1(course, instituteid);
	
	Institute institute=instituteService.instituteLogin1(instituteCode);
		/* session.removeAttribute("course1"); */
	String jsp="InstituteDashboard";
	ModelAndView mAndV=new ModelAndView();
	mAndV.addObject("institute", institute);
	mAndV.setViewName(jsp);
	return mAndV;
	
			
		}
	
	///View course status by institute
	@RequestMapping(path="/viewcoursestatus.hr", method=RequestMethod.GET)
	public ModelAndView viewCourseStatus(HttpSession session){
		try {
			String instituteCode=(String)session.getAttribute("instuserid");
			Institute instituteid=instituteService.instituteLogin1(instituteCode);
			List<Course> courseStatusList=instituteService.viewCourseStatus1(instituteid);
			String jspName="ViewAddCourseStatus";
			ModelAndView mAndV=new ModelAndView();
			mAndV.addObject("courseStatusList", courseStatusList);
			mAndV.setViewName(jspName);
			return mAndV;
		} catch (Exception e) {
			e.printStackTrace();
			String jspName="NoCoursesAddedInstitute";
			ModelAndView mAndV=new ModelAndView();
			mAndV.setViewName(jspName);
			return mAndV;
		}
	}
	
	
	@RequestMapping(path="/updatecoursestatusbyinstitute.hr")
	public ModelAndView updateCourseStatusByInstitute(HttpSession session) {
		String instituteCode=(String)session.getAttribute("instuserid");
		try {
			
			Institute instituteid=instituteService.instituteLogin1(instituteCode);
			Institute institute=instituteid;
			int ress=instituteService.updateCourseStatusByInstitute1(instituteid);
			
				
				String jspName= "InstituteDashboard";
				ModelAndView mAndV=new ModelAndView();
				mAndV.addObject("institute",institute);
				mAndV.setViewName(jspName);
				return mAndV;
		} catch (Exception e) {
		
			e.printStackTrace();
			Institute institute=instituteService.instituteLogin1(instituteCode);
			String jspName= "InstituteDashboard";
			ModelAndView mAndV=new ModelAndView();
			mAndV.addObject("institute",institute);
			mAndV.setViewName(jspName);
			return mAndV;
		}
	}
	
	
	
	//STUDENT CERTIFICATION
	@RequestMapping(path="/studentcertification.hr", method=RequestMethod.GET)
	public ModelAndView givesCoursesToViewStudentAcc(HttpSession session){
		try {
			String instituteCode=(String)session.getAttribute("instuserid");
			Institute instituteid=instituteService.instituteLogin1(instituteCode);
			List<Course> courseList=instituteService.getAccCoursesOnInstituteid1(instituteid);
			String jspName="CourseListForStudentCertification";
			ModelAndView mAndV=new ModelAndView();
			mAndV.addObject("courseList", courseList);
			mAndV.setViewName(jspName);
			return mAndV;
		} catch (Exception e) {
			
			e.printStackTrace();
			String jspName="NoAppliedCourse";
			ModelAndView mAndV=new ModelAndView();
			mAndV.setViewName(jspName);
			return mAndV;
		}
	}
	
	@RequestMapping(path="/viewstudentsforcertification.hr")
	public ModelAndView givesStudentsAcctoCourseForCertification(@RequestParam("compId") String compId) {
	List<Completedcourse> studentList=instituteService.viewStudentsForCertification1(compId);
	String jsp="StudentListForCertification";
	ModelAndView mAndV=new ModelAndView();
	mAndV.addObject("studentList", studentList);
	mAndV.setViewName(jsp);
	return mAndV;
		
		
	}
	
	
	@RequestMapping(path="/certifystudent.hr")
	public ModelAndView certifiesStudent(HttpSession session, @RequestParam("compId") String compId, @RequestParam("studentAadharNo") String studentAadharNo) {
		session.setAttribute("compId", compId);
		Student studentid=studentService.studentLogin1(studentAadharNo);
		session.setAttribute("studentid", studentid);
		
		
		ModelAndView mAndV=new ModelAndView();
		String jsp="CertificationPage";
		mAndV.setViewName(jsp);
		return mAndV;
		
	} 
	//mailing Attachment
	@RequestMapping(path="/emailattachment.hr", method = RequestMethod.POST)
	public ModelAndView sendAttachment(HttpSession session, HttpServletRequest request, @RequestParam("attachFile") CommonsMultipartFile attachFile) {
		String compId = (String)session.getAttribute("compId");
		Student studentid=(Student)session.getAttribute("studentid");
		
		
		try {
			String emailTo=studentid.getStudentEmail();
			String subject ="CERTIFICATION";
			String message ="Congratulations on Completing the Course!!";
 
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
		
		//Changing To certified in Database
		int certiResult=instituteService.instituteCertifiesStudent1(compId, studentid);
		//returning students left for certification
		List<Completedcourse> studentList=instituteService.viewStudentsForCertification1(compId);
		String jsp="StudentListForCertification";
		session.removeAttribute("compId");
		session.removeAttribute("studentid");
		ModelAndView mAndV=new ModelAndView();
		mAndV.addObject("studentList", studentList);
		mAndV.setViewName(jsp);
		return mAndV;
		
	}
	
	
	
		
	
	
	
	
	

						
						
						
						
						
						
						
	
	
	/// Institute LOGOUT
	@RequestMapping(path="/institutelogout.hr", method=RequestMethod.GET)
	public ModelAndView instituteLogout(HttpSession session){
		String instituteCode=(String)session.getAttribute("instuserid");
		
		Institute institute = instituteService.instituteLogin1(instituteCode);
		String jspName= "InstituteLogout";
		ModelAndView mAndV=new ModelAndView();
		mAndV.addObject("institute",institute);
		mAndV.setViewName(jspName);
		return mAndV;

	}	
	@RequestMapping(path="/institutelogout1.hr", method=RequestMethod.GET)
	public String instituteLogout1(HttpSession session){
		session.removeAttribute("instuserid");
	    session.removeAttribute("loggedinstitute");
        session.invalidate();
		return "Home";

	}	
	
	//RETURNING INSTITUTE DASHBOARD

	@RequestMapping(path="/returninstitutedashboard.hr")
	public ModelAndView returnInstituteDashboard(HttpSession session) {
		
		String instituteCode=(String)session.getAttribute("instuserid");
		
			Institute institute = instituteService.instituteLogin1(instituteCode);
			String jspName= "InstituteDashboard";
			ModelAndView mAndV=new ModelAndView();
			mAndV.addObject("institute",institute);
			mAndV.setViewName(jspName);
			return mAndV;
	}

	
	
}
