<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>OTP VERIFICATION</title>
<base href="/OnlinePortal/">
<link href="resources/CSS/student-registration.css" rel="stylesheet">
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
	<form method="post" action="emailempletter.hr?" enctype="multipart/form-data">
	<table align="center">
	
	 <tr align="center">
       <td align="center">Attach Employment Letter:</td>
       <td align="center"><input align="right" type="file" name="attachFile" size="60" required/></td>
     </tr> 
     <br/><br/>
     <tr align="center"> 
     <td align="center" align="center">  
	<div class="button-layout">
				<button id="submit" type="submit" align="center">Send</button>
	</div>
	</td> 
	</tr>
	</table>
	</form>
</body>
</html>