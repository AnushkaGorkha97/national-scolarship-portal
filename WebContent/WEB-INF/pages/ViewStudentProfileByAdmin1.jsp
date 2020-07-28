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
		<a href="monitorstudent.hr" class="menu">GO BACK TO STUDENT LIST</a> 
		<a href="home.hr" class="menu">LOGOUT</a> 
	</nav>
	
	
	
	<form >
	
		
		<h2 align="center"> Student  Profile</h2>
		<div class="card-layout">
			<table id="table1" ; cellspacing="5px" cellpadding="5%"
				; align="center">
				<tr><h4>Student Personal Details</h4></tr>
				<tr>
					<td align="right">Student Aadhar Number:</td>
					<td>
						${student.studentAadharNo}
					</td>
				</tr>
	
	          <tr>
					<td align="right">Student Name:</td>
					<td>
						${student.studentName}
					</td>
				</tr>
	        <tr>
					<td align="right">Student Email:</td>
					<td>
						${student.studentEmail}
					</td>
				</tr>
				<tr>
					<td align="right">Student DOB:</td>
					<td>
						${student.studentDob}
					</td>
				</tr>
				<tr>
					<td align="right">Student Age:</td>
					<td>
						${student.studentAge}
					</td>
				</tr>
				<tr>
					<td align="right">Student Location:</td>
					<td>
						${student.studentAddress}
					</td>
				</tr>
				<tr>
					<td align="right">Student Email:</td>
					<td>
						${student.studentEmail}
					</td>
				</tr>
				<tr>
					<td align="right">Student Gender:</td>
					<td>
						${student.studentGender}
					</td>
				</tr>
				<tr>
					<td align="right">Student Mobile:</td>
					<td>
						${student.studentMobile}
					</td>
				</tr></table>
	  
	  <table id="table1" ; cellspacing="5px" cellpadding="5%"
				; align="center">
	  <tr><h4>Student Qualifications:</h4></tr>
	  <tr>
	  <td align="right">Student 10th Pass Year:</td>
		<td>
		${student.student10thYear}
		</td>
	  </tr>
	  <tr>
	  <td align="right">Student 10th Percentage:</td>
		<td>
		${student.student10thPercentage}
		</td>
	  </tr>
	   
	  <tr>
	  <td align="right">Student 12th Pass Year:</td>
		<td>
		${student.student12thYear}
		</td>
	  </tr>
	  <tr>
	  <td align="right">Student 12th Percentage:</td>
		<td>
		${student.student12thPercentage}
		</td>
	  </tr>
	  </table>
	  <br/><br/><br/>
	  <table id="table1" ; cellspacing="5px" cellpadding="5%"
				; align="center">
			
			<tr>
	<c:set var = "cstatus" scope = "session" value = "${student.jobId}"/>

    <c:if test = "${cstatus == 0}">		
	<p> Employment:  Not Employeed</p>
	</c:if>		
	<c:if test = "${cstatus == 1}">			
	<p> Employment:   Employed Outside Portal</p>
	</c:if>	
			</tr>
			
				
	</table>			
	  
	  <table id="table1" ; cellspacing="5px" cellpadding="5%"
				; align="center">
	  <tr><h4>Student Certified Courses:</h4></tr>
	  <tr><td align="right">Course Name</td>
	  <td>Course Score</td>
	  </tr>
	 <c:forEach items="${courseList}" var="std">
	  <tr>
	  <td align="right">${std.compName} :</td>
	  <td>${std.compScore}</td>
	  </tr>
	  </c:forEach>
	  </table>
	   <br/><br/>
	  
	  
	
				</div>
				
				</form>
	  
	  
	  
	  
	  
</body>
</html>