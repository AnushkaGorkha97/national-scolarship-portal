<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<base href="/OnlinePortal/">
<link href="resources/CSS/student-registration.css" rel="stylesheet">
<script src="resources/jquery-3.4.1.js"></script>
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
		<a href="studentlogout1.hr" class="menu">HOME</a> 
		<a href="studentlogout1.hr" class="menu">ABOUT US</a> 
		<a href="studenrlogout1.hr" class="menu">CONTACT US</a> 
	</nav>


<form action="studentlogout1.hr" method="get">
<h2 align="center">YOUR REGISTRATION IS FAILED DUE TO INVALID AADHAR NUMBER-ALREADY BEING USED!!</h2>
<h2 align="center">TRY AGAIN!!</h2>
<div class="button-layout" align="center">
				<button id="submit" align="center" type="submit">OK</button>
				
			</div>

</form>
</body>
</html>