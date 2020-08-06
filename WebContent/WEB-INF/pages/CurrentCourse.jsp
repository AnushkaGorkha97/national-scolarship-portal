<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Current Course</title>
<base href="/OnlinePortal/">
<link href="resources/CSS/student-registration.css" rel="stylesheet">
<script src="resources/jquery-3.4.1.js"></script>
</head>
<body>
<nav id="navbar"> 
	<a href="returnstudentdashboard.hr" class="menu">HOME</a> 
	
	<a href="studentlogout.hr" class="menu">LOGOUT</a>
	</nav>
	
	<table>
	<tr><td>Course Name:</td><td>${course.courseName}</td></tr>
	<tr><td>Course Description:</td><td>${course.courseName}</td></tr><br/><br/>
	
	
	</table>
	 </table>
            <table id="table1" ; cellspacing="5px" cellpadding="5%"
				; align="center">
				<h3 align="center">Course Video:</h3>
                <tr>
					
					<td>
					<video src="uploads/${course.courseLink}" type="video/mp4"  controls/>
					</td>
				</tr>
            </table>
            <a href="givetest.hr?courseId=${course.courseId}"> GIVE TEST</a>
				
</body>
</html>