 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page errorPage="errorPage.jsp"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Institute Dashboard</title>
<link href="resources/CSS/StudentDashboard.css" rel="stylesheet">



</head>
<body>
<div class="header">
		<img src="resources/images/logo.jpg" />
</div>

	<nav id="navbar"> 
	<a href="returninstitutedashboard.hr" class="menu">HOME</a> 
	<a href="instituteeditprofile.hr" class="menu">EDIT PROFILE</a> 
	<a href="institutechangepass.hr" class="menu">CHANGE PASS</a>
	<a href="institutelogout.hr" class="menu">LOGOUT</a>
	</nav>
<h1 align="center">Welcome Institute ${institute.instituteName} </h1>
<div class="container">
<h3 align="center">My Profile</h3>
                <table id="table1" ; cellspacing="5px" cellpadding="5%"
				; align="center">
                <tr>
				
				<form action="addcourse.hr">
	            <div align="center" class="button-layout">
				<button id="submit" type="submit" >ADD COURSE
				</button>
				</div>
				</form>
				 </tr>
				 
                <br/> <br/>
                
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
				
				
			</table>
</div>


</div>
</body>
</html>