<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

     <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin View Jobs</title>
<link href="resources/CSS/StudentDashboard.css" rel="stylesheet">
</head>
<body>
<div class="header">
		<img src="resources/images/logo.jpg" />
</div>

	<nav id="navbar"> 
	<a href="admindashboard.hr" class="menu">HOME</a> 
	
	<a href="home.hr" class="menu">LOGOUT</a>
	</nav>
	
<h3 align="center">All Pending Job Posts</h3>
<div class="container">

<c:forEach items="${jobList}" var="std">
<table>
<tr>

<td aligh="left">JOB NAME:</td> <td>${std.jobName}</td>
</tr>
<tr>
<td aligh="right">JOB DESCRIPTION:</td> <td>${std.jobDescription}</td>  
</tr>
<tr>
<td aligh="right">JOB SALARY:</td> <td>${std.jobSalary}</td>  
</tr>
<tr>
<td aligh="right">INDUSTRY CODE:</td> <td>${std.industryid.industryCode}</td>
</tr>
<tr> 
<td aligh="left">INDUSTRY NAME:</td> <td>${std.industryid.industryName}</td>
</tr>
<tr>
<td><a href="acceptjobbyadmin.hr?jobId=${std.jobId}"> ACCEPT </a></td>
<td><a href="rejectjobbyadmin.hr?jobId=${std.jobId}"> REJECT </a></td>
</tr>
 
</table>
<br/><br/><br/>
</c:forEach>



</body>
</html>