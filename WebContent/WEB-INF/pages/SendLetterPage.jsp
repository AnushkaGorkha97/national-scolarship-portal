<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>OTP VERIFICATION</title>
<base href="/OnlinePortal/">
<link href="resources/CSS/student-registration.css" rel="stylesheet">
</head>
<body>
<div class="header">
		<img src="resources/images/logo.jpg"/>
	</div>
	
	<br><br><br><br><br><br><br><br>
	<form method="post" action="emailempletter.hr?" enctype="multipart/form-data">
	<table>
	
	 <tr>
       <td>Attach Employment Letter:</td>
       <td><input align="right" type="file" name="attachFile" size="60" required/></td>
     </tr> 
     <br/><br/>
     <tr> 
     <td>  
	<div class="button-layout">
				<button id="submit" type="submit" align="center">Send</button>
	</div>
	</td> 
	</tr>
	</table>
	</form>
</body>
</html>