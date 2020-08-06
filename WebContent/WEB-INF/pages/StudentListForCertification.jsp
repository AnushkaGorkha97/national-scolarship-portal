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
	<a href="studentcertification.hr" class="menu">GO BACK TO COURSE LIST</a> 
	<a href="institutelogout.hr" class="menu">LOGOUT</a>
	</nav>
	
<h3 align="center"> Student List For Certification</h3>
<div class="container">
<c:if test="${fn:length(studentList) < 1}">
<h4>No Students For Certification</h4>
</c:if>
<c:forEach items="${studentList}" var="std">
<table>

 <tr>
<td aligh="left">STUDENT AADHAR NO:</td> <td>${std.studentid.studentAadharNo}</td>
</tr>
<tr>
<td aligh="left">STUDENT NAME:</td> <td>${std.studentid.studentName}</td>
</tr>
<tr>
<td aligh="left">COURSE NAME:</td> <td>${std.compName}</td>  
</tr>
<tr>
<td aligh="left">COURSE SCORE:</td> <td>${std.compScore}</td>  
</tr>
<tr>
<td>Certify?:</td><td><a href="certifystudent.hr?compId=${std.compCourseId}&studentAadharNo=${std.studentid.studentAadharNo}">Certify</a></td>
</tr>


</table>
<br/><br/><br/>
</c:forEach>



</body>


</html>