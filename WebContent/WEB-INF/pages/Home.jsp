<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" content="width=device-width, initial-scale=1.0">


<title>NATIONAL SCHOLARSHIP PORTAL</title>



<base href="/OnlinePortal/">
<link href="resources/CSS/main.css" rel="stylesheet">
<script src="resources/jquery-3.4.1.js"></script>
<script src="resources/main.js"></script >




<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
.fa {
  padding: 10px;
  font-size: 20px;
  width: 20px;
  text-align: center;
  text-decoration: none;
  margin: 5px 2px;
}

.fa:hover {
    opacity: 0.7;
    font-size: 25px;
}

.fa-facebook {
  background: #3B5998;
  color: white;
}

.fa-twitter {
  background: #55ACEE;
  color: white;
}
.fa-linkedin {
  background: #007bb5;
  color: white;
}
/*.fa-instagram {
  background: #125688;
  color: white;
}*/
</style>
</head>
<body>
	<div class="header">
		<img src="resources/images/logo.jpg"/>
	</div>
	<nav id="navbar"> 
	<a href="home.hr" class="menu">HOME</a> 
	
	<a id = "registration" href="#"  class="menu">REGISTRATION</a> 
	<a id = "login" href="#" class="menu">LOGIN</a> 
	<a id = "forgotpass" href="#" class="menu">FORGOT PASS</a> 
	</nav>
	<div id="dropdown" class = "dropdown-layout">
		<div id="dropdown-content" class="dropdown-content">
			<a id="studentregistration" href = "studentRegistration.hr">STUDENT</a>
			<a id="instituteregistration" href = "instituteRegistration.hr">INSTITUTE</a>
			<a id="industryregistration" href = "industryRegistration.hr">INDUSTRY</a>
		</div>
		<div id="dropdown-content1" class="dropdown-content1">
			<a id="studentlogin" href = "studentlogin.hr">STUDENT</a>
			<a id="institutelogin" href = "institutelogin.hr">INSTITUTE</a>
			<a id="industrylogin" href = "industrylogin.hr">INDUSTRY</a>
			<a id="adminlogin" href = "adminlogin.hr">ADMIN</a>
		</div>
		<div id="dropdown-content2" class="dropdown-content">
			<a id="studentforgotpass" href = "studentforgotpass.hr">STUDENT</a>
			<a id="instituteforgotpass" href = "instituteforgotpass.hr">INSTITUTE</a>
			<a id="industryforgotpass" href = "industryforgotpass.hr">INDUSTRY</a>
		</div>
	</div>
	
	<div>
		<p></p>
	</div>
	<div class="layout">
        <marquee id="alert"  width="100%" direction="left" height="30%">
             This is to inform you that Government of Maharashtra has introduced new Scholarship Schemes. <U>Improve Your skills and get employed!!</U>.
        </marquee>
		<div class="updates">
			<div class="marquee1">
				<h4>
					<img src="resources/images/bell.jpg"
						height="27px" width="27px"/><span>LATEST UPDATES</span>

				</h4>
				<h3>LATEST UPDATES</h3>
				<p style="background-color: #FFFFB5">Apply for the latest Scholarship Schemes,<u> here</u>.</p>
				<p style="background-color: #EBA9FE">Scholarship for girls,<U> check it</U>.</p>
				<p style="background-color: #FFD3B5">Merit based scholarship, find out the eligibility criteria, <U>here</U>.</p>
				<p style="background-color: #CCFFA3">Ministry is going to introduce new Scholarship Schemes under <U>Pradhan Mantri Scholarship Scheme(PMSS) 2020</U>.</p>
				<p style="background-color: #B5FFFE">Check out the <u>list</u> of all Scholarships provided by Government.</U>.</p>
			</div>
		</div>

		<div class="description">
			<div class="marquee1">
				 <h3 id="heading" align="center"><span>Welcome to National Scholarship Portal</span>
				 </h3>
				 <p><left>National Scholarship portal is an education related portal. National Scholarship portal is a project developed with the main aim of providing an easy and efficient way for learning new courses and getting employed for students in need of it.The main aim of this Portal is to help students improve their skill set and gain employment.We aim to eradicate unemployment.
				 </left></p>
                 <h3>Benefits available at our Portal:</h3>
                 <p>Online Courses<br>
                    Applying for Jobs at Various Industries<br>
                    Certification for completed courses<br>
				 </p>
			</div>
		</div>

		<div class="slogin">
			<div class="marquee1">
				<h4>
					<img src="resources/images/helpdesk.jpg"
						height="27px" width="27px"/><span>HELPDESK</span>

				</h4>
				<h3>HELPDESK</h3>
				<p style="background-color: #FFFF00">Get in touch with our 24x7 Helpline, <u>here</u></p>
				<p><font color="#2B6CF9">For any Queries regarding latest Scholarships, Contact us on toll free number <u>1800 2700 2700</u> or e-mail us at <u>NationalScholarshipPortal123@gmail.com</u></font></p>
				<a href="http://www.facebook.com" target="_blank" class="fa fa-facebook" title="facebook"></a>
                <a href="http://www.twitter.com" target="_blank" class="fa fa-twitter" title="twitter"></a>
                <a href="http://www.linkedin.com" target="_blank" class="fa fa-linkedin" title="linkedIn"></a>
                <!-- <a href="http://www.instagram.com" target="_blank" class="fa fa-instagram"></a> -->
                <p style="background-color: #D4FFA8">Riase your request <u>here</u> at our helpdesk. We will revert soon.</p>
			</div>
		</div>

	</div>
</body>
</html>