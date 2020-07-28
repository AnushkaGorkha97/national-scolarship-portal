 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page errorPage="errorPage.jsp"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Industry Dashboard</title>
<link href="resources/CSS/StudentDashboard.css" rel="stylesheet">
</head>
<body>
<div class="header">
		<img src="resources/images/logo.jpg" />
</div>

	<nav id="navbar"> 
	<a href="returnindustrydashboard.hr" class="menu">HOME</a> 
	<a href="industryeditprofile.hr" class="menu">EDIT PROFILE</a> 
	<a href="industrychangepass.hr" class="menu">CHANGE PASS</a>
	<a href="industrylogout.hr" class="menu">LOGOUT</a>
	</nav>
<h1 align="center">Welcome Industry ${industry.industryName} </h1>
<div class="container">
<h3 align="center">My Profile</h3>
                <table id="table1" ; cellspacing="5px" cellpadding="5%"
				; align="center">
                <tr>
				
				<form action="addjob.hr">
	            <div align="center" class="button-layout">
				<button id="submit" type="submit" >ADD JOB POST
				</button>
				</div>
				</form>
				 </tr>
				 <br/> <br/>
                <tr>
			    <form action="industryviewjobstatus.hr">
	            <div align="center" class="button-layout">
				<button id="submit" type="submit" >VIEW JOB STATUS
				</button>
				</div>
				</form>
				</tr>
                <br/> <br/>
                <tr>
			    <form action="viewcoursestohire.hr">
	            <div align="center" class="button-layout">
				<button id="submit" type="submit" >VIEW COURSES TO HIRE
				</button>
				</div>
				</form>
				</tr>
				
				<br/> <br/>
                <tr>
			    <form action="viewstudentappliedforjobaccjobpost.hr">
	            <div align="center" class="button-layout">
				<button id="submit" type="submit" >VIEW STUDENTS APPLYING FOR JOB POSTS 
				</button>
				</div>
				</form>
				</tr>
				
				
					<br/><br/>   
				<tr>
				<form action="sendofferletter.hr">
	            <div align="center" class="button-layout">
				<button id="submit" type="submit" >Send OFFER LETTER TO HIRED STUDENTS</button>
				</div>
				</form>
				</tr>   
               <!--
                <tr>
			    <form action="viewcoursestatus.hr">
	            <div align="center" class="button-layout">
				<button id="submit" type="submit" >VIEW COURSE STATUS
				</button>
				</div>
				</form>
				</tr>
				
				<br/> <br/>
				
				<tr>
			    <form action="studentcertification.hr">
	            <div align="center" class="button-layout">
				<button id="submit" type="submit" >STUDENT CERTIFICATION
				</button>
				</div>
				</form>
				</tr>
				
				-->
			</table> 
</div>


</div>
</body>
</html>