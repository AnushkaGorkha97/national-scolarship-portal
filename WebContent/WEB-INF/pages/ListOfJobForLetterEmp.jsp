<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
      <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>JOB LIST</title>
<base href="/OnlinePortal/">
<link href="resources/CSS/StudentDashboard.css" rel="stylesheet">
</head>
<body>
<div class="header">
		<img src="resources/images/logo.jpg" />
</div>

	<nav id="navbar"> 
	<a href="returnindustrydashboard.hr" class="menu">HOME</a> 
	
	<a href="industrylogout.hr" class="menu">LOGOUT</a>
	</nav>
	
<h3 align="center"> Job Posts</h3>
<div class="container">
<c:if test="${fn:length(jobList) < 1}">
<h4>No Jobs Added</h4>
</c:if>
<c:forEach items="${jobList}" var="std">
<table>
<c:set var = "cstatus" scope = "session" value = "${std.jobAR}"/>
 <c:if test = "${cstatus == 1}">
<tr>
<td aligh="left">JOB NAME:</td> <td>${std.jobName}</td>
</tr>
<tr>
<td aligh="left">JOB DESCRIPTION:</td> <td>${std.jobDescription}</td>  
</tr>
<tr>
<td aligh="left">JOB SALARY:</td> <td>${std.jobSalary}</td>  
</tr>
<tr>
<td>View Students Hired For This Job</td><td><a href="viewstudenthiredjob.hr?jobId=${std.jobId}">View</a></td>
</tr>
</c:if>


</table>
<br/><br/><br/>
</c:forEach>
</body>
</html>