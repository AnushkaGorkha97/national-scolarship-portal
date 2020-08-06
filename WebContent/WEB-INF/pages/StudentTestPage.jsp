<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<base href="/OnlinePortal/">
<link href="resources/CSS/student-registration.css" rel="stylesheet">
<script src="resources/jquery-3.4.1.js"></script>



<script type="text/javascript">
	window.history.forward();
	function noBack() { window.history.forward(); }
</script>
</head>
</head>
<body onload="noBack();" 
	onpageshow="if (event.persisted) noBack();" onunload="">
<div class="header">
		<img src="resources/images/logo.jpg" />
	</div>
	
	<form action="studenttestresult.hr" method="post">
		
		<h2 align="center">Fresh Student Registration Form</h2>
		<div class="card-layout">
			<table id="table1" ; cellspacing="5px" cellpadding="5%" align="center">
			
	<tr> 
	<td>Q1:</td><td>${course.courseQ1}</td>
	</tr>
	<tr>
	<td align="right">Answer:</td>
					<td><select id="ans1" 
						name="courseQ1A"  required>
						<option value="">------------Choose------------</option>
						    <option value="${course.courseQ1A1}">${course.courseQ1A1}</option>
						    <option value="${course.courseQ1A2}">${course.courseQ1A2}</option>
							</select>
							</td>
				</tr>
	
	<br/> <br/><br/>
	
	<tr> 
	<td>Q2:</td><td>${course.courseQ2}</td>
	</tr>
	<tr>
	<td align="right">Answer:</td>
					<td><select id="ans2" 
						name="courseQ2A"  required>
						<option value="">------------Choose------------</option>
						    <option value="${course.courseQ2A1}">${course.courseQ2A1}</option>
						    <option value="${course.courseQ2A2}">${course.courseQ2A2}</option>
							</select>
							</td>
				</tr>
	
	<br/> <br/><br/>
	
	<tr> 
	<td>Q3:</td><td>${course.courseQ3}</td>
	</tr>
	<tr>
	<td align="right">Answer:</td>
					<td><select id="ans3" 
						name="courseQ3A"  required>
						<option value="">------------Choose------------</option>
						    <option value="${course.courseQ3A1}">${course.courseQ3A1}</option>
						    <option value="${course.courseQ3A2}">${course.courseQ3A2}</option>
							</select>
							</td>
				</tr>
	
	
</table>
<div class="button-layout">
				<button id="submit" type="submit">Submit</button>
				<button id="reset" type="reset">Reset</button>
			</div>	
	
	</div></form>
</body>
</html>