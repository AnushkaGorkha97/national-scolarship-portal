<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

     <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student JOB APPL STATUS</title>
<base href="/OnlinePortal/">
<link href="resources/CSS/StudentDashboard.css" rel="stylesheet">
<script src="resources/jquery-3.4.1.js"></script>
</head>
<body>
<div class="header">
		<img src="resources/images/logo.jpg" />
</div>

	<nav id="navbar"> 
	<a href="returnstudentdashboard.hr" class="menu">HOME</a> 
	
	<a href="studentlogout.hr" class="menu">LOGOUT</a>
	</nav>
<h3 align="center"> JOB APPLY STATUS</h3>
<div class="container">	

<c:forEach items="${jobapplyList}" var="std">
<table>	
<c:set var = "appstd" scope = "session" value = "${std.appByStudent}"/>
   <c:set var = "appindus" scope = "session" value = "${std.appByIndustry}"/>
   <c:set var = "accindus" scope = "session" value = "${std.appAccByIndustry}"/>
   
   <c:if test = "${appstd == 0 && appindus== 1 && accindus == 1}">
   
   
   <tr align="center"><p style="color:green"> JOB SENT BY INDUSTRY</p></tr>
<tr>
<td aligh="left">JOB NAME:</td> <td align="right">${std.appJobName}</td>
</tr>	
	<tr>
<td aligh="left">JOB DESCRIPTION:</td> <td align="right">${std.appJobDescription}</td>
</tr>

<tr>
<td aligh="left">VIEW JOB DETAILS:</td> <td align="right"><a href="viewjobdetails.hr?jobId=${std.appJobId}">View</a></td>
</tr>

<tr>
<td aligh="left"><a href="accjobbystudent.hr?jobId=${std.appJobId}">ACCEPT</a></td> <td align="right"><a href="rejjobbystudent.hr?jobId=${std.appJobId}">REJECT</a></td>
</tr>
</c:if>
<c:if test = "${appstd == 1 && appindus== 0 && accindus == 1}">
   <tr align="center"><p style="color:blue"> JOB APPLICATION ACCEPTED BY INDUSTRY</p></tr>
<tr>
<td aligh="left">JOB NAME:</td> <td align="right">${std.appJobName}</td>
</tr>	
	<tr>
<td aligh="left">JOB DESCRIPTION:</td> <td align="right">${std.appJobDescription}</td>
</tr>

<tr>
<td aligh="left">VIEW JOB DETAILS:</td> <td align="right"><a href="viewjobdetails.hr?jobId=${std.appJobId}">View</a></td>
</tr>

<tr>
<td aligh="left"><a href="accjobbystudent.hr?jobId=${std.appJobId}">ACCEPT</a></td> <td align="right"><a href="rejjobbystudent.hr?jobId=${std.appJobId}">REJECT</a></td>
</tr>
</c:if>
<c:if test = "${appstd == 1 && appindus== 0 && accindus == 3}">
  <tr align="center"><p style="color:red"> JOB APPLICATION REJECTED BY INDUSTRY</p></tr>
<tr>
<td aligh="left">JOB NAME:</td> <td align="right">${std.appJobName}</td>
</tr>	
	<tr>
<td aligh="left">JOB DESCRIPTION:</td> <td align="right">${std.appJobDescription}</td>
</tr>
</c:if>

<c:if test = "${appstd == 1 && appindus== 0 && accindus == 0}">

 <tr align="center"> <p style="color:pink">JOB APPLICATION WAITING FOR APPROVAL BY INDUSTRY</p></tr>
<tr>
<td aligh="left">JOB NAME:</td> <td align="right">${std.appJobName}</td>
</tr>	
	<tr>
<td aligh="left">JOB DESCRIPTION:</td> <td align="right">${std.appJobDescription}</td>
</tr>
</c:if>
</table>
<br/><br/>
</c:forEach>

</div>


	
</body>
</html>