 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page errorPage="errorPage.jsp"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student Dashboard</title>
<link href="resources/CSS/StudentDashboard.css" rel="stylesheet">
</head>
<body>
<div class="header">
		<img src="resources/images/logo.jpg" />
</div>

	<nav id="navbar"> 
	<a href="returnstudentdashboard.hr" class="menu">HOME</a> 
	<a href="studenteditprofile.hr" class="menu">EDIT PROFILE</a> 
	<a href="studentchangepass.hr" class="menu">CHANGE PASS</a>
	<a href="studentlogout.hr" class="menu">LOGOUT</a>
	</nav>
<h1 align="center">Welcome Student ${student.studentName}</h1>
<div class="container">
<h3 align="center">My Profile</h3>
 <table id="table1" ; cellspacing="5px" cellpadding="5%" align="center">
                <tr>
				<form action="viewcoursebystudent.hr">
	            <div align="center" class="button-layout">
				<button id="submit" type="submit" >View Course</button>
				</div>
				</form>
				</tr>      
				<br/><br/>
				<tr>
				<form action="viewcurrentcoursebystudent.hr">
	            <div align="center" class="button-layout">
				<button id="submit" type="submit" >View Applied Course</button>
				</div>
				</form>
				<br/><br/>
				</tr>   
				<tr>
				<form action="searchjobbystudent.hr">
	            <div align="center" class="button-layout">
				<button id="submit" type="submit" >Search For Jobs</button>
				</div>
				</form>
				</tr> 
					<br/><br/>   
				<tr>
				<form action="viewemployment.hr">
	            <div align="center" class="button-layout">
				<button id="submit" type="submit" >View Emploment Status</button>
				</div>
				</form>
				</tr> 
				
				        
</table>

</div>
</body>
</html>