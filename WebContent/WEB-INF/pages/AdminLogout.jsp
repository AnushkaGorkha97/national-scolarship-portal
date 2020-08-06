<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Logout</title>
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
	
	<h1 align="center">Admin are you sure you want to logout?</h1>
	
	<br/><br/.
	<table>
	
	<tr>
	
	<td>
	<form action="admindashboard.hr">
	<div  class="button-layout" align="left">
				<button id="submit" align="center"  type="submit" >  NO  
				</button>
				</div>
	
	</form>
	</td>
	
	<td>
	<form action="adminlogout1.hr">
	<div  class="button-layout" align="right">
				<button id="submit" align="center" type="submit" >  YES  
				</button>
				</div>
	
	</form>
	</td>
	
	
	</tr>
	
	</table>
	
	
	
	
	
</body>
</html>