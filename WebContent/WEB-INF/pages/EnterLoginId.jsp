<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<base href="/OnlinePortal/">
<link href="resources/CSS/student-registration.css" rel="stylesheet">
<script src="resources/jquery-3.4.1.js"></script>
<script>
finction validate() {
	onsole.log("HELLO")
	var forgotid = document.getElementBId("ids").value;
	if (forgotid == '') {
		document.getElementById('error-id').innerHTML = "This field cannot be blank!!";
		return false
	} else {
		return true
	} }

</script>

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
	
	<form action="studentforgotpass.hr" method="post"
	onsubmit="return (validate()) ">

	<h2 align="center">ENTER YOUR ID.</h2>
		<div class="card-layout">
			<table id="table1" ; cellspacing="5px" cellpadding="5%"
				; align="center">
				
				
				<<tr>
					<td align="right">ID:</td>
					<td><input type="number" style="width: 200px;"
						name="id" id="ids"  required /></td>
				</tr> </table>
				<div class="button-layout">
				<button id="submit" type="submit" align="center">Submit</button>
				</div> </div></form>


</body>
</html>