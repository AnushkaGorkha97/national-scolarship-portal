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
		<a href="monitorinstitutes.hr" class="menu">GO BACK TO INSTITUTE LIST</a>
		<a href="home.hr" class="menu">LOGOUT</a> 
	</nav>
	
	
	
	
	
		
		<h2 align="center"> Institute  Profile</h2>
		<div class="card-layout">
			<table id="table1" ; cellspacing="5px" cellpadding="5%"
				; align="center">
				<tr><h4>Institute  Details</h4></tr>
				<tr>
					<td align="right">Institute Code:</td>
					<td>
						${institute.instituteCode}
					</td>
				</tr>
	
	          <tr>
					<td align="right">Institute Name:</td>
					<td>
						${institute.instituteName}
					</td>
				</tr>
	        <tr>
					<td align="right">Institute Email:</td>
					<td>
						${institute.instituteEmail}
					</td>
				</tr>
				<tr>
					<td align="right">Institute Type:</td>
					<td>
						${institute.instituteType}
					</td>
				</tr>
				
				<tr>
					<td align="right">Institute Location:</td>
					<td>
						${institute.instituteAddress}
					</td>
				</tr>
				
				<tr>
					<td align="right">Institute Mobile:</td>
					<td>
						${institute.instituteMobile}
					</td>
				</tr></table>
	  
	  
	  
	  <table id="table1" ; cellspacing="5px" cellpadding="5%"
				; align="center">
	  <tr><h4>Institute Provided Courses:</h4></tr>
	  <tr><td align="right">Course Name</td>
	  <td>Course Description</td>
	  </tr>
	 <c:forEach items="${courseList}" var="std">
	  <tr>
	  <td align="right">${std.courseName} :</td>
	  <td>${std.courseDescription}</td>
	  </tr>
	  </c:forEach>
	  </table>
	  </div>
				
</body>
</html>