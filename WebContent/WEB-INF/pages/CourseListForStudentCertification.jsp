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
	<a href="returninstitutedashboard.hr" class="menu">HOME</a> 
	
	<a href="institutelogout.hr" class="menu">LOGOUT</a>
	</nav>
<div class="container">	
<h2 align="center"> Courses</h2>

<c:if test="${fn:length(courseList) < 1}">
<h4>No Students Registered Yet</h4>
</c:if>

<c:forEach items="${courseList}" var="std">
<table>
<c:set var = "cstatus" scope = "session" value = "${std.courseAR}"/>
 <c:if test = "${cstatus == 1}">
<tr>
<td aligh="left">COURSE NAME:</td> <td>${std.courseName}</td>
</tr>
<tr>
<td aligh="left">COURSE DESCRIPTION:</td> <td>${std.courseDescription}</td>  
</tr>
<tr>
<td>View Students</td><td><a href="viewstudentsforcertification.hr?compId=${std.courseId}">View</a></td>
</tr>
</c:if>


</table>
<br/><br/><br/>
</c:forEach>


</body>


</html>