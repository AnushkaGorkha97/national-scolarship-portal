<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
     <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student View Archive Courses</title>
<base href="/OnlinePortal/">
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
	
	
	
	<h3 align="center">All Completed Courses Courses</h3>
<c:choose>
<c:when test="${fn:length(courseList) < 1}">
<div class="container">
<h4>No Courses Completed</h4>
</div>
</c:when>
 <c:otherwise>
 
<div class="container">

<c:forEach items="${courseList}" var="std">

<table>

<tr>
<td aligh="left">COURSE NAME:</td> <td>${std.compName}</td>
</tr>

<tr>
<td aligh="left">View Course:</td> <td><a href="archivecourselink.hr?courseId=${std.compCourseId}">View</a></td>  
</tr>
<br/>
<br/>
</table>
</c:forEach>
</div>
</c:otherwise>
</c:choose>	
	
	
	
	
</body>
</html>