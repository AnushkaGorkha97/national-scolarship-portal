<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Job Details</title>
<link href="resources/CSS/StudentDashboard.css" rel="stylesheet">
</head>
<body>
<div class="header">
		<img src="resources/images/logo.jpg" />
</div>

	<nav id="navbar"> 
	<a href="returnstudentdashboard.hr" class="menu">HOME</a> 
<a href="viewemployment.hr" class="menu">GO BACK TO JOB STATUS LIST</a>
	<a href="studentlogout.hr" class="menu">LOGOUT</a>
	</nav>
	
	<h1 align="center">JOB DETAILS</h1>
	<table align="center">
	<tr>
	<td align="right">INDUSTR NAME:</td>  <td align="left">${job.industryid.industryName}</td>
	</tr> <br/>
	<tr>
	<td align="right">JOB NAME:</td>  <td align="left">${job.jobName}</td>
	</tr> <br/>
	<tr>
	<td align="right">JOB DESCRIPTION:</td>  <td align="left">${job.jobDescription}</td>
	</tr> <br/>
	<tr>
	<td align="right">JOB SALARY:</td>  <td align="left">${job.jobSalary}</td>
	</tr> <br/>
	<tr>
	<td align="right">LOCATION:</td>  <td align="left">${job.industryid.industryAddress}</td>
	</tr> <br/>
	
	
	</table>
	
	
	
	
	
	
	
	
	
	
	
</body>
</html>