<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
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
		<a href="returnindustrydashboard.hr" class="menu">HOME</a> 
		<a href="industryeditprofile.hr" class="menu">EDIT PROFILE</a> 
		<a href="industrychangepass.hr" class="menu">CHANGE PASS</a> 
	    <a href="industrylogout.hr" class="menu">LOGOUT</a> 
	</nav>
	
	<form action="addjob.hr" method="post">
	<h2 align="center">INDUSTRY ADD JOB </h2>
		<div class="card-layout">
			<table id="table1" ; cellspacing="5px" cellpadding="5%"
				; align="center">
				
				 <tr>
					<td align="right">JOB Name:</td>
					<td><input id="name" type="text" 
						name="jobName"  required></td>
				</tr>
				
				
				 <tr>
					<td align="right">Job Description:</td>
					<td><input id="courseDesc" type="text" 
						name="jobDescription"  required></td>
				</tr>
				<tr>
					<td align="right">Job Salary:</td>
					<td><input id="courseDesc" type="text" 
						name="jobSalary"  required></td>
				</tr>
				</table>
			<div class="button-layout">
				<button id="submit" type="submit">Submit</button>
				<button id="reset" type="reset">Reset</button>
			</div>
		</div>

	</form>
</body>
</html>