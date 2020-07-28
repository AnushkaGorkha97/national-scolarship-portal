<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student Dashboard</title>
<link href="resources/CSS/StudentDashboard.css" rel="stylesheet">
</head>
<body>
<div class="header">
		<img src="resources/images/logo.jpg" />
</div>

	<nav id="navbar"> 
	<a href="returnstudentdashboard.hr" class="menu">HOME</a> 

	<a href="studentlogout.hr" class="menu">LOGOUT</a>
	<h1>EMPLOYMENT DETAILS</h1>
	</nav>
	<table>
	<tr>
	<td align="right">EMPLOYED AT:</td>  <td align="left">${job.industryid.industryName}</td>
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