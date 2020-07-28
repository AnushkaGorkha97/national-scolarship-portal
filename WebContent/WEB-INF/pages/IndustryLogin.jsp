<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Institute Login</title>

<link href="resources/CSS/login.css" rel="stylesheet">
</head>
<body>
<div class="header">
		<img src="resources/images/logo.jpg" />
	</div>
	<nav id="navbar"> 
	<a href="home.hr" class="menu">HOME</a> 
	<a href="home.hr" class="menu">ABOUT US</a> 
	<a href="home.hr" class="menu">CONTACT US</a> 
	</nav>
	<div class="container">
		<h1 align="center">INDUSTRY LOGIN</h1>
		<form action="industrydashboard.hr" method="post">
			<table id="table1" cellspacing="5px" cellpadding="5%" align="center">
				<tr>
					<td align="right">Enter your username:</td>
					<td align="right"><input type="text" name="industryCode" /></td>
				</tr>
				<tr>
					<td align="right">Enter your password:</td>
					<td align="right"><input type="password" name="industryPassword" /></td>
				</tr>
			</table>
							<div class="button-layout">
					<button id="submit" type="submit">LOGIN</button>
					
				</div>
		</form>
	</div>

</body>
</html>