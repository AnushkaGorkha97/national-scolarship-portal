<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
  <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Monitor Institutes</title>
<link href="resources/CSS/StudentDashboard.css" rel="stylesheet">
</head>
<body>
<div class="header">
		<img src="resources/images/logo.jpg" />
</div>

	<nav id="navbar"> 
	<a href="admindashboard.hr" class="menu">HOME</a> 
	
	<a href="adminlogout.hr" class="menu">LOGOUT</a>
	</nav>
	
<h3 align="center">All Institutes</h3>
<div class="container">
<c:if test="${fn:length(instituteList) < 1}">
<h4>No Registered Institutes Yet</h4>
</c:if>
<c:forEach items="${instituteList}" var="std">
<table>
<tr>

<td aligh="right">Institute Code:</td> <td align="left">${std.instituteCode}</td>
</tr>
<tr>
<td aligh="right">Institute Name:</td> <td align="left">${std.instituteName}</td>  
</tr>
<tr>
<td aligh="right">View Institute Profile:</td> <td align="left"><a href="viewinstituteprofile.hr?instituteCode=${std.instituteCode}">View</a></td>
</tr>
<br/>
</table>
<br/><br/><br/>
</c:forEach>



</body>


</html>