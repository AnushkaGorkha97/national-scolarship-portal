<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Institute Logout</title>
<link href="resources/CSS/StudentDashboard.css" rel="stylesheet">


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
	
	<h1 align="center">${institute.instituteName} are you sure you want to logout?</h1>
	
	<br/><br/.
	<table>
	
	<tr>
	
	<td>
	<form action="returninstitutedashboard.hr">
	<div align="left" class="button-layout">
				<button id="submit" align="center" type="submit" >  NO  
				</button>
				</div>
	
	</form>
	</td>
	
	<td>
	<form action="institutelogout1.hr">
	<div align="right" class="button-layout">
				<button id="submit" align="center" type="submit" >  YES  
				</button>
				</div>
	
	</form>
	</td>
	
	
	</tr>
	
	</table>
	
	
	
	
	
</body>
</html>