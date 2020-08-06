<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
     <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student JOB APPL STATUS</title>
<base href="/OnlinePortal/">
<link href="resources/CSS/StudentDashboard.css" rel="stylesheet">
<script src="resources/jquery-3.4.1.js"></script>

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
	<a href="returnstudentdashboard.hr" class="menu">HOME</a> 
	
	<a href="studentlogout.hr" class="menu">LOGOUT</a>
	</nav>
<h3 align="center"> JOB APPLY STATUS</h3>
	
<c:choose>
<c:when test="${fn:length(jobapplyList) < 1}">
<div class="container">
<h4>No Jobs Applied And Sent</h4>
</div>
</c:when>
 <c:otherwise>
 <div class="container">
<h4>Jobs Accepted By Industry</h4>
<c:forEach items="${jobapplyList}" var="std">
<c:set var = "appstd" scope = "session" value = "${std.appByStudent}"/>
   <c:set var = "appindus" scope = "session" value = "${std.appByIndustry}"/>
   <c:set var = "accindus" scope = "session" value = "${std.appAccByIndustry}"/>
<table>
<c:if test = "${appstd == 1 && appindus== 0 && accindus == 1}">
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
<br/>
</c:if>
</table>
</c:forEach>
</div>
<br/><br/>


<div class="container">	
<h4>Jobs Sent By Industry</h4>
<c:forEach items="${jobapplyList}" var="std">
<c:set var = "appstd" scope = "session" value = "${std.appByStudent}"/>
   <c:set var = "appindus" scope = "session" value = "${std.appByIndustry}"/>
   <c:set var = "accindus" scope = "session" value = "${std.appAccByIndustry}"/>
<table>
<c:if test = "${appstd == 0 && appindus== 1 && accindus == 1}">
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
<br/>
</c:if>
</table>
</c:forEach>
</div>
<br/><br/>


<div class="container">
<h4>Jobs Applications in Waiting</h4>
<c:forEach items="${jobapplyList}" var="std">
<c:set var = "appstd" scope = "session" value = "${std.appByStudent}"/>
   <c:set var = "appindus" scope = "session" value = "${std.appByIndustry}"/>
   <c:set var = "accindus" scope = "session" value = "${std.appAccByIndustry}"/>
<table>
<c:if test = "${appstd == 1 && appindus== 0 && accindus == 0}">
<tr>
<td aligh="left">JOB NAME:</td> <td align="right">${std.appJobName}</td>
</tr>	
	<tr>
<td aligh="left">JOB DESCRIPTION:</td> <td align="right">${std.appJobDescription}</td>
</tr>
<br/>
</c:if>
</table>
</c:forEach>
</div>
<br/><br/>


<div class="container">
<h4>Jobs Applications Rejected</h4>
<c:forEach items="${jobapplyList}" var="std">
<c:set var = "appstd" scope = "session" value = "${std.appByStudent}"/>
   <c:set var = "appindus" scope = "session" value = "${std.appByIndustry}"/>
   <c:set var = "accindus" scope = "session" value = "${std.appAccByIndustry}"/>
<table>
<c:if test = "${appstd == 1 && appindus== 0 && accindus == 3}">
<tr>
<td aligh="left">JOB NAME:</td> <td align="right">${std.appJobName}</td>
</tr>	
	<tr>
<td aligh="left">JOB DESCRIPTION:</td> <td align="right">${std.appJobDescription}</td>
</tr>
<br/>
</c:if>
</table>
</c:forEach>
</div>
</c:otherwise></c:choose>	
</body>
</html>