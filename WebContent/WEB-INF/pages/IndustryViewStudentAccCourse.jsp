<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
      <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Institute View Course Status</title>
<base href="/OnlinePortal/">
<link href="resources/CSS/StudentDashboard.css" rel="stylesheet">

</head>
<body>
<div class="header">
		<img src="resources/images/logo.jpg" />
</div>

	<nav id="navbar"> 
	<a href="returnindustrydashboard.hr" class="menu">HOME</a> 
	<a href="viewcoursestohire.hr" class="menu">GO BACK TO COURSE LIST</a>
	<a href="industrylogout.hr" class="menu">LOGOUT</a>
	</nav>
	
<h3 align="center">All  STUDENTS </h3>
<div class="container">
<c:if test="${fn:length(stdList) < 1}">
<h4>No Students Completing The Course</h4>
</c:if>
<c:forEach items="${stdList}" var="std">


 

<table>

<tr>

<td aligh="left">STUDENT AADHAR NO:</td> <td>${std.studentid.studentAadharNo}</td>
</tr>
<tr>
<td aligh="right">STUDENT NAME:</td> <td>${std.studentid.studentName}</td>  
</tr>
<tr>
<td aligh="right">COURSE SCORE:</td> <td>${std.compScore}</td>
</tr>

<tr>
<td><a href="viewstudentprofile.hr?studentAadharNo=${std.studentid.studentAadharNo}&courseId=${std.compCourseId}"> View Profile</a></td>

</tr>


<br/>
</table>

</c:forEach>
</body>


</html>