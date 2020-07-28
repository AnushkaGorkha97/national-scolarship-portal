<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<base href="/OnlinePortal/">
<link href="resources/CSS/student-registration.css" rel="stylesheet">
<script src="resources/jquery-3.4.1.js"></script>

</head>
<body>
<div class="header">
		<img src="resources/images/logo.jpg" />
	</div>
	
<form action="uploadcourselink.hr" enctype="multipart/form-data" method="post">
		<h2 align="center">INSTITUTE ADD COURSE</h2>
		<div class="card-layout">
	
            <table id="table1" ; cellspacing="5px" cellpadding="5%"
				; align="center">
				<h3 align="center">Course Upload Section</h3>
                <tr>
					<td align="right">Course Video:</td>
					<td><input id="video" type="file" value="Upload" 
						name="courseLink" style="width: 200px;" accept="videos/mp4"  required></td>
				</tr> <!-- accept="images/jpg" -->
				
            </table>
            <table id="table1" ; cellspacing="5px" cellpadding="5%"
				; align="center">
				<tr>
					<td align="right"><input type="checkbox" value="confirm" required>
					</td>
					<td><h5>ALL THE INFORMATION FURNISHED BY ME IS TRUE TO
						BEST OF MY KNOWLEDGE. IF ANY MISTAKES ARE FOUND THEN I MAY BE DISQUALIFIED FOR SCHOLARSHIP SCHEME ANNOUNCED BY GOVERNMENT OF INDIA OR MY STATE GOVERNMENT.</h5>
					</td>
				</tr>
            </table>
		<table id="table1" ; cellspacing="5px" cellpadding="5%"
				; align="center">
			<div align="center" class="button-layout">
				<button id="submit"  type="submit">Submit</button>
				
			</div>
		</table>
		</div>

	</form>
	
	
	
</body>
</html>