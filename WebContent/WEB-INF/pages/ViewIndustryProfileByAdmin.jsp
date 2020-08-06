<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<base href="/OnlinePortal/">
<link href="resources/CSS/student-registration.css" rel="stylesheet">
<script src="resources/jquery-3.4.1.js"></script>
</head>
<body>
<div class="header">
		<img src="resources/images/logo.jpg" />
	</div>
	<nav id="navbar"> 
		<a href="admindashboard.hr" class="menu">HOME</a> 
		<a href="monitorindustry.hr" class="menu">GO BACK TO INSTITUTE LIST</a>
		<a href="adminlogout.hr" class="menu">LOGOUT</a> 
	</nav>
	
	
	
	
	
		
		<h2 align="center"> Industry  Profile</h2>
		<div class="card-layout">
			<table id="table1" ; cellspacing="5px" cellpadding="5%"
				; align="center">
				<tr><h4>Industry  Details</h4></tr>
				<tr>
					<td align="right">Industry Code:</td>
					<td>
						${industry.industryCode}
					</td>
				</tr>
	
	          <tr>
					<td align="right">Industry Name:</td>
					<td>
						${industry.industryName}
					</td>
				</tr>
	        <tr>
					<td align="right">Industry Email:</td>
					<td>
						${industry.industryEmail}
					</td>
				</tr>
				
				<tr>
					<td align="right">Industry Location:</td>
					<td>
						${industry.industryAddress}
					</td>
				</tr>
				
				<tr>
					<td align="right">Industry Mobile:</td>
					<td>
						${industry.industryMob}
					</td>
				</tr></table>
	  
	  
	  
	  <table id="table1" ; cellspacing="5px" cellpadding="5%"
				; align="center">
	  <tr><h4>Institute Provided Job:</h4></tr>
	  <tr><td align="right">Job Name</td>
	  <td>Job Description</td>
	  </tr>
	 <c:forEach items="${jobList}" var="std">
	  <tr>
	  <td align="right">${std.jobName} :</td>
	  <td>${std.jobDescription}</td>
	  </tr>
	  </c:forEach>
	  </table>
	  </div>
				
</body>
</html>