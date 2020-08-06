<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
     <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Institute View Course Status</title>
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
	<a href="returninstitutedashboard.hr" class="menu">HOME</a> 
	
	<a href="institutelogout.hr" class="menu">LOGOUT</a>
	</nav>
	
<h3 align="center">All Pending Courses</h3>
<c:choose>
<c:when test="${fn:length(courseStatusList) < 1}">
<div class="container">
<h4>No Courses Added</h4>
</div>
</c:when>
 <c:otherwise>
 
<div class="container">
<h4>Courses Approved By Admin</h4>
<c:forEach items="${courseStatusList}" var="std">
<c:set var = "cstatus" scope = "session" value = "${std.courseAR}"/>
<table>
<c:if test = "${cstatus == 1}">
<tr>
<td aligh="left">COURSE NAME:</td> <td>${std.courseName}</td>
</tr>
<tr>
<td aligh="left">COURSE DESCRIPTION:</td> <td>${std.courseDescription}</td>  
</tr> <br/>
</c:if>
</table>
</c:forEach>
</div>
<br/><br/>
<div class="container">
<h4>Courses Waiting For Approval</h4>
<c:forEach items="${courseStatusList}" var="std">
<c:set var = "cstatus" scope = "session" value = "${std.courseAR}"/>
<table>
<c:if test = "${cstatus == 0}">
<tr>
<td aligh="left">COURSE NAME:</td> <td>${std.courseName}</td>
</tr>
<tr>
<td aligh="left">COURSE DESCRIPTION:</td> <td>${std.courseDescription}</td>  
</tr> <br/>
</c:if>
</table>
</c:forEach>
</div>
<br/><br/>
<div class="container">
<h4>Courses Rejected By Admin</h4>
<c:forEach items="${courseStatusList}" var="std">
<c:set var = "cstatus" scope = "session" value = "${std.courseAR}"/>
<table>
<c:if test = "${cstatus == 3}">
<tr>
<td aligh="left">COURSE NAME:</td> <td>${std.courseName}</td>
</tr>
<tr>
<td aligh="left">COURSE DESCRIPTION:</td> <td>${std.courseDescription}</td>  
</tr> <br/>
</c:if>
</table>
</c:forEach>
</div>
<br/><br/>
</c:otherwise></c:choose>
<br/><br/>
<form action="updatecoursestatusbyinstitute.hr">
<div class="button-layout" align="center" >
				<button id="submit" align="right" type="submit">OK</button>
				
			</div>
</form>

</body>


</html>