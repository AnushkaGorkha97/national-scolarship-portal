<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
     <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin View Courses</title>
<link href="resources/CSS/StudentDashboard.css" rel="stylesheet">

<script type="text/javascript">
	window.history.forward();
	function noBack() { window.history.forward(); }
</script>

</head>
<body onload="noBack();" 
	onpageshow="if (event.persisted) noBack();" onunload="">
<div class="header">
		<img src="resources/images/logo.jpg" />
</div>

	<nav id="navbar"> 
	<a href="admindashboard.hr" class="menu">HOME</a> 
	
	<a href="adminlogout.hr" class="menu">LOGOUT</a>
	</nav>
	
<h3 align="center">All Pending Student Requests For Applying To Courses</h3>
<div class="container">
<c:if test="${fn:length(studentList) < 1}">
<h4>No New Student Requests For Courses To Accept/Reject</h4>
</c:if>
<c:forEach items="${studentList}" var="std">
<table>
<tr>

<td aligh="left">STUDENT AADHAR NO.:</td> <td>${std.studentAadharNo}</td>
</tr>
<tr>
<td aligh="left">STUDENT NAME:</td> <td>${std.studentName}</td>  
</tr>
<tr>
<td aligh="left">REQUESTED COURSE NAME:</td> <td>${std.studentCourseName}</td>
</tr>

<tr>
<td><a href="acceptstudentbyadmin.hr?studentAadharNo=${std.studentAadharNo}"> ACCEPT </td>
<td><a href="rejectstudentbyadmin.hr?studentAadharNo=${std.studentAadharNo}"> REJECT </td>
</tr>
 
</table>
<br/><br/><br/>
</c:forEach>



</body>


</html>