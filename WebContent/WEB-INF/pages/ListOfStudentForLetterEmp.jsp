<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
	<a href="sendofferletter.hr" class="menu">GO BACK TO JOBLIST</a> 
	<a href="industrylogout.hr" class="menu">LOGOUT</a>
	</nav>
	
<h3 align="center"> Job Posts</h3>
<div class="container">

<c:forEach items="${jobapplyList}" var="std">
<table>
<tr>
<td aligh="left">STUDENT AADHAR NO:</td> <td>${std.studentjid.studentAadharNo}</td>
</tr>
<tr>
<td aligh="left">STUDENT NAME:</td> <td>${std.studentjid.studentName}</td>
</tr>

<tr>
<td>Send Job Employment Letter</td><td><a href="sendstudentjobletter.hr?studentAadharNo=${std.studentjid.studentAadharNo}&jobId=${std.appJobId}">Send</a></td>
</tr>

<br/><br/>

</table>
</c:forEach>
<br/><br/><br/>

</body>
</html>