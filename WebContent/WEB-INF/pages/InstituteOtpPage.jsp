<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en"
xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta charset="ISO-8859-1">
<title>OTP VERIFICATION</title>
<base href="/OnlinePortal/">
<link href="resources/CSS/student-registration.css" rel="stylesheet">
<script src="resources/jquery-3.4.1.js"></script>

<script type="text/javascript">
	window.history.forward();
	function noBack() { window.history.forward(); }
</script>

<script>
	
	
	
	<%
	String clock = request.getParameter("clock");
		if(clock==null) clock="31";
	%>
	
	var timeout = <%=clock%>
	function timer()
    {
	if( --timeout > 0 )
		{
		document.forma.clock.value = timeout;
		window.setTimeout( "timer()", 1000 )
		}
	else
		{
		document.forma.clock.value = "Time Over";
		document.forma.action = "home.hr";
		}
	
    }	
	
	
	
	
	
	
	</script>
</head>
<body onload="noBack();" 
	onpageshow="if (event.persisted) noBack();" onunload="">
<div class="header">
		<img src="resources/images/logo.jpg"/>
	</div>
<form action="instituteOtp.hr" method="post" name="forma" >
	
	<h2 align="center">OTP VERIFICATION</h2><br/>
	Time Remaining: <input type="text" name="clock" value="<%=clock%>" style="width: 200px;">
<div class="card-layout">
Time Remaining: <input type="text" align="center" name="clock" value="<%=clock%>" style="width: 200px;">
<br/><br/>
			<table id="table1" ; cellspacing="5px" cellpadding="5%"
				; align="center">
				
				<br/><br/>
				<tr>
					<td align="center">Enter OTP:</td>
					<td><input type="number" style="width: 200px;"
						name="instituteOtp" id="otp"  required></td>
				</tr>
				</table>
				<br/><br/><br/><br/>
				<div class="button-layout" align="center">
				<button id="submit" type="submit" align="center">Submit</button>
				</div>  </div>
				
				</form>
				
	<script>
	timer();
	</script>
			

</body>
</html>>