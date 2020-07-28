<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

     <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Industry View Job Status</title>
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
	
<h3 align="center">All Pending Courses</h3>
<div class="container">

<c:forEach items="${jobStatusList}" var="std">
<table>
<tr>
<td aligh="left">JOB NAME:</td> <td>${std.jobName}</td>
</tr>
<tr>
<td aligh="left">JOB DESCRIPTION:</td> <td>${std.jobDescription}</td>  
</tr>

<tr>
<c:set var = "cstatus" scope = "session" value = "${std.jobAR}"/>

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
<form action="updatejobstatusbyindustry.hr">
<button type="submit"> OK </button>
</form>


</body>


</html>