<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

     <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
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
	<a href="returninstitutedashboard.hr" class="menu">HOME</a> 
	
	<a href="institutelogout.hr" class="menu">LOGOUT</a>
	</nav>
	
<h3 align="center">All Pending Courses</h3>
<div class="container">

<c:forEach items="${courseStatusList}" var="std">
<table>
<tr>
<td aligh="left">COURSE NAME:</td> <td>${std.courseName}</td>
</tr>
<tr>
<td aligh="left">COURSE DESCRIPTION:</td> <td>${std.courseDescription}</td>  
</tr>

<tr>
<c:set var = "cstatus" scope = "session" value = "${std.courseAR}"/>

    <c:if test = "${cstatus == 0}">
         <p style="color:green"> WAITING FOR APPROVAL BY ADMIN </p>
   </c:if> 
 
    <c:if test = "${cstatus == 1}">
         <p style="color:blue"> APPROVED BY ADMIN </p>
   </c:if> 
 
    <c:if test = "${cstatus == 3}">
         <p style="color:red"> REJECTED BY ADMIN </p>
   </c:if> 
</tr>

</table>
<br/><br/><br/>
</c:forEach>
<form action="updatecoursestatusbyinstitute.hr">
<button type="submit"> OK </button>
</form>


</body>


</html>