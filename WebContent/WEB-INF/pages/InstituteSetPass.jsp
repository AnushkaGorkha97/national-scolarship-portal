<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Institute Set Pass</title>
<base href="/OnlinePortal/">
<link href="resources/CSS/student-registration.css" rel="stylesheet">
<script src="resources/jquery-3.4.1.js"></script>

<script type="text/javascript">


function validate() {
	console.log("HELLO")
	var setPassword = document.getElementById('set_pass').value;
		var confPassword = document.getElementById('conf_pass').value;
	
		if (setPassword == '') {
			document.getElementById('error-studentPassword').innerHTML = "Set Password cannot be blank";
			return false
		} else if (confPassword == '') {
			document.getElementById('error-confpassword').innerHTML = "Confirm Password cannot be blank";
			return false
		} else {
			return true
		} }

function confirmpasswordFunction() {
	var password = document.getElementById("set_pass").value;
	var confpassword = document.getElementById("conf_pass").value;

	if(confpassword==password)
	{
		document.getElementById("confirmError").innerHTML= "Password Matched";
		document.getElementById("confirmError").style.color = "#74D611";
		document.getElementById("submit").disabled = false;

	}
	else if(confpassword != password){
		document.getElementById("confirmError").innerHTML="Password not matched";
		document.getElementById("confirmError").style.color="#FA0101";
		document.getElementById("submit").disabled=true;
	}
    }


</script>

</head>
<body>
<div class="header">
		<img src="resources/images/logo.jpg" />
	</div>
	
	
	<form action="instituteSetPassword.hr" method="post"
	onsubmit="return (validate() && checkPassword())">
	
	<h2 align="center">SET PASSWORD FOR INSTITUTE</h2>
		<div class="card-layout">
			<table id="table1" ; cellspacing="5px" cellpadding="5%"
				; align="center">
				
				
				<<tr>
					<td align="right">Set your Password:</td>
					<td><input type="password" style="width: 200px;"
						name="institutePassword" id="set_pass" pattern="(?=^.{8,}$)(?=.*[a-z])(?=.*[A-Z])(?!.*\s).*$" title="Password min 8 characters. At least one UPPERCASE and one lowercase letter" required /></td>
				</tr>
				
				<tr>
					<td align="right">Confirm your Password:</td>
					<td><input type="password" style="width: 200px;"
						name="confpassword" id="conf_pass" onkeyup="confirmpasswordFunction();" 
						onchange="confirmpasswordFunction();" required />
				</tr> 
				
				<tr>
					
					<td align="right">Password Validation: </td>
					<td align="right"><p id="confirmError"></p></td>
					
				
				</tr>
				
				
				</table>
				<div class="button-layout">
				<button id="submit" type="submit">Submit</button>
				<button id="reset" type="reset">Reset</button>
			</div> </div></form>
	
	
</body>
</html>