<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en"
xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>OTP VERIFICATION</title>
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
		<img src="resources/images/logo.jpg"/>
	</div>
	
	<br><br><br><br><br><br><br><br>
	<form method="post" action="emailattachment.hr" enctype="multipart/form-data">
	<table align="center">
	
	 <tr align="center">
       <td align="center">Attach Certificate:</td>
       <td align="center"><input  align="center" type="file" name="attachFile" size="60" required/></td>
     </tr> 
     <br/><br/>
     <tr align="center"> 
     <td align="center">  
	<div class="button-layout" align="center">
				<button id="submit" type="submit" align="center">Send  </button>
				</div>
	</td> 
	</tr>
	</table>
	</form>
</body>
</html>