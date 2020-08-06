<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page errorPage="errorPage.jsp"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Dashboard</title>
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
<h1 align="center">Welcome Admin</h1>
<div class="container">
<h3 align="center">My Profile</h3>
                <table id="table1" ; cellspacing="5px" cellpadding="5%" align="center">
                <tr>
				
				<form action="viewcourse.hr">
	            <div align="center" class="button-layout">
				<button id="submit" type="submit" >View Course Request
				</button>
				</div>
				</form>
				</tr>
				<br/><br/>
				<tr>
				
				<form action="studentaccrej.hr">
	            <div align="center" class="button-layout">
				<button id="submit" type="submit" >View Student Requests
				</button>
				</div>
				</form>
				</tr>
				<br/><br/>
				 <tr>
				 <tr>
				
				<form action="viewjob.hr">
	            <div align="center" class="button-layout">
				<button id="submit" type="submit" >View Job Post Request
				</button>
				</div>
				</form>
				</tr>
				<br/><br/>
				<tr>
				
				<form action="monitorinstitutes.hr">
	            <div align="center" class="button-layout">
				<button id="submit" type="submit" >Monitor Institutes
				</button>
				</div>
				</form>
				</tr>
				<br/><br/>
				<tr>
				
				<form action="monitorindustry.hr">
	            <div align="center" class="button-layout">
				<button id="submit" type="submit" >Monitor Industries
				</button>
				</div>
				</form>
				</tr>
				<br/><br/>
				<tr>
				
				<form action="monitorstudent.hr">
	            <div align="center" class="button-layout">
				<button id="submit" type="submit" >Monitor Students
				</button>
				</div>
				</form>
				</tr>
			</table>

</body>
</html>