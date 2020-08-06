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
	<a href="returnindustrydashboard.hr" class="menu">HOME</a> 
	
	<a href="industrylogout.hr" class="menu">LOGOUT</a>
	</nav>
	
<h3 align="center">All  Courses</h3>
<div class="container">
<c:if test="${fn:length(courseList) < 1}">
<h4>No Courses Added By any Institutes Yet</h4>
</c:if>
<c:forEach items="${courseList}" var="std">
<table>
<tr>

<td aligh="left">COURSE NAME:</td> <td>${std.courseName}</td>
</tr>
<tr>
<td aligh="right">COURSE DESCRIPTION:</td> <td>${std.courseDescription}</td>  
</tr>
<tr>
<td aligh="right">INSTITUTE CODE:</td> <td>${std.instituteid.instituteCode}</td>
</tr>
<tr> 
<td aligh="left">INSTITUTE NAME:</td> <td>${std.instituteid.instituteName}</td>
</tr>
<tr>
<td><a href="viewstudentcertifiedcourse.hr?courseId=${std.courseId}"> View Students Completing the Course</a></td>

</tr>
 
</table>
<br/><br/><br/>
</c:forEach>



</body>


</html>