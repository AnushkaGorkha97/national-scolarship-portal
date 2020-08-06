<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
     <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Industry View Job Status</title>
<base href="/OnlinePortal/">
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
	<a href="returnindustrydashboard.hr" class="menu">HOME</a> 
	
	<a href="industrylogout.hr" class="menu">LOGOUT</a>
	</nav>
	
<h3 align="center">All Job Posts Status</h3>
<c:choose>
<c:when test="${fn:length(jobStatusList) < 1}">
<div class="container">
<h4>No Job Posts Added</h4>
</div>
</c:when>
 <c:otherwise>
 
<div class="container">
<h4>Job Posts Accepted By Admin</h4>
<c:forEach items="${jobStatusList}" var="std">
<c:set var = "cstatus" scope = "session" value = "${std.jobAR}"/>
<table>
<c:if test = "${cstatus == 1}">
<tr>
<td aligh="left">JOB NAME:</td> <td>${std.jobName}</td>
</tr>
<tr>
<td aligh="left">JOB DESCRIPTION:</td> <td>${std.jobDescription}</td>  
</tr>
<br/>
</c:if>
</table>
</c:forEach>
</div>
<br/><br/>
<div class="container">
<h4>Job Posts Waiting For Approval</h4>
<c:forEach items="${jobStatusList}" var="std">
<c:set var = "cstatus" scope = "session" value = "${std.jobAR}"/>
<table>
<c:if test = "${cstatus == 0}">
<tr>
<td aligh="left">JOB NAME:</td> <td>${std.jobName}</td>
</tr>
<tr>
<td aligh="left">JOB DESCRIPTION:</td> <td>${std.jobDescription}</td>  
</tr>
<br/>
</c:if>
</table>
</c:forEach>
</div>
<br/><br/>
<div class="container">
<h4>Job Posts Rejected By Admin</h4>
<c:forEach items="${jobStatusList}" var="std">
<c:set var = "cstatus" scope = "session" value = "${std.jobAR}"/>
<table>
<c:if test = "${cstatus == 3}">
<tr>
<td aligh="left">JOB NAME:</td> <td>${std.jobName}</td>
</tr>
<tr>
<td aligh="left">JOB DESCRIPTION:</td> <td>${std.jobDescription}</td>  
</tr>
<br/>
</c:if>
</table>
</c:forEach>
</div>
<br/><br/>
</c:otherwise>
</c:choose>
<br/><br/>
<form action="updatejobstatusbyindustry.hr">
<div class="button-layout" align="center" >
				<button id="submit" align="right" type="submit">OK</button>
				
			</div>
</form>





</body>


</html>