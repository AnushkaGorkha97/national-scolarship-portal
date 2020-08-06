<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
      <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student Certification</title>
<base href="/OnlinePortal/">
<link href="resources/CSS/StudentDashboard.css" rel="stylesheet">
</head>
<body>
<div class="header">
		<img src="resources/images/logo.jpg" />
</div>

	<nav id="navbar"> 
	<a href="returnindustrydashboard.hr" class="menu">HOME</a> 
	<a href="viewstudentappliedforjobaccjobpost.hr" class="menu" method="get">GO BACK TO JOB LIST</a>
	<a href="industrylogout.hr" class="menu">LOGOUT</a>
	</nav>
	
<h3 align="center">Students Applied For This Job Post</h3>
<div class="container">
<c:if test="${fn:length(jobapplyList) < 1}">
<h4>No Students Applied For The Jobs</h4>
</c:if>
<c:forEach items="${jobapplyList}" var="std">
<table>
<tr>
<td aligh="left">STUDENT AADHAR:</td> <td>${std.studentjid.studentAadharNo}</td>
</tr>

<tr>
<td aligh="left">STUDENT NAME:</td> <td>${std.studentjid.studentName}</td>
</tr>

<tr>
<td>View Student Profile</td><td><a href="viewstudentprofilejobapply.hr?jobId=${std.appJobId}&studentAadharNo=${std.studentjid.studentAadharNo}">View</a></td>
</tr>



</table>
<br/><br/><br/>
</c:forEach>
</body>
</html>