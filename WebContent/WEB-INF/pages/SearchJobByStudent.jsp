<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
     <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student View Courses</title>
<link href="resources/CSS/StudentDashboard.css" rel="stylesheet">
</head>
<body>
<div class="header">
		<img src="resources/images/logo.jpg" />
</div>

	<nav id="navbar"> 
	<a href="returnstudentdashboard.hr" class="menu">HOME</a> 
	
	<a href="studentlogout.hr" class="menu">LOGOUT</a>
	</nav>
	
<h3 align="center">All  Job Posts</h3>
<div class="container">
<c:if test="${fn:length(jobList) < 1}">
<h4>No Jobs Available</h4>
</c:if>
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
<td aligh="left">LOCATION:</td> <td>${std.industryid.industryAddress}</td>
</tr>
<tr>
<td><a href="applyjobbystudent.hr?jobId=${std.jobId}"> APPLY</td>

</tr>
 
</table>
<br/><br/><br/>
</c:forEach>

</div>	
	
	
	
</body>
</html>