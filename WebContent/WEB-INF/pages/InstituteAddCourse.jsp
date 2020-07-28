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

<script type="text/javascript">


function checkAns() {
var ansone = document.getElementById("Q1A1").value;
var anstwo = document.getElementById("Q1A2").value;
var ans = document.getElementById("Q1A").value;

if(ansone == ans && anstwo != ans) {
	document.getElementById("confirmError").innerHTML= "Data entered correctly";
	document.getElementById("confirmError").style.color = "#74D611";
	document.getElementById("submit").disabled = true;

} else if(anstwo==ans && ansone != ans) {
	
	document.getElementById("confirmError").innerHTML= "Data entered correctly";
	document.getElementById("confirmError").style.color = "#74D611";
	document.getElementById("submit").disabled = true;
	}
	else {
		document.getElementById("confirmError").innerHTML="Your Answer Should Match With Only One Option";
		document.getElementById("confirmError").style.color="#FA0101";
		document.getElementById("submit").disabled=false;
	}
}
	
	
function onecheckAnss() {
	var anstto = document.getElementById("Q2A1").value;
	var ansttt = document.getElementById("Q2A2").value;
	var ansss = document.getElementById("Q2A").value;

	if(anstto == ansss && ansttt != ansss) {
		document.getElementById("confirmErrorr").innerHTML= "Data entered correctly";
		document.getElementById("confirmErrorr").style.color = "#74D611";
		document.getElementById("submit").disabled = true;

	} else if(ansttt==ansss && anstto != ansss) {
		
		document.getElementById("confirmErrorr").innerHTML= "Data entered correctly";
		document.getElementById("confirmErrorr").style.color = "#74D611";
		document.getElementById("submit").disabled = true;
		}
		else {
			document.getElementById("confirmErrorr").innerHTML="Your Answer Should Match With Only One Option";
			document.getElementById("confirmErrorr").style.color="#FA0101";
			document.getElementById("submit").disabled=false;
		}
}
	
	
	function twocheckAnsss() {
		var ansto = document.getElementById("Q3A1").value;
		var anstt = document.getElementById("Q3A2").value;
		var anss = document.getElementById("Q3A").value;

		if(ansto == anss && anstt != anss) {
			document.getElementById("confirmErrorrr").innerHTML= "Data entered correctly";
			document.getElementById("confirmErrorrr").style.color = "#74D611";
			document.getElementById("submit").disabled = false;

		} else if(anstt==anss && ansto != anss) {
			
			document.getElementById("confirmErrorrr").innerHTML= "Data entered correctly";
			document.getElementById("confirmErrorrr").style.color = "#74D611";
			document.getElementById("submit").disabled = false;
			}
			else {
				document.getElementById("confirmErrorrr").innerHTML="Your Answer Should Match With Only One Option";
				document.getElementById("confirmErrorrr").style.color="#FA0101";
				document.getElementById("submit").disabled=true;
			}
	    }





</script>

</head>
<body>
<div class="header">
		<img src="resources/images/logo.jpg" />
	</div>
	<nav id="navbar"> 
		<a href="returninstitutedashboard.hr" class="menu">HOME</a> 
		<a href="instituteeditprofile.hr" class="menu">EDIT PROFILE</a> 
		<a href="institutechangepass.hr" class="menu">CHANGE PASS</a> 
	    <a href="institutelogout.hr" class="menu">LOGOUT</a> 
	</nav>
	
	<form action="addcourse.hr" method="post">
		
		<h2 align="center">INSTITUTE ADD COURSE</h2>
		<div class="card-layout">
			<table id="table1" ; cellspacing="5px" cellpadding="5%"
				; align="center">
				
				 <tr>
					<td align="right">Course Name:</td>
					<td><input id="name" type="text" 
						name="courseName"  required></td>
				</tr>
				
				
				 <tr>
					<td align="right">Course Description:</td>
					<td><input id="courseDesc" type="text" 
						name="courseDescription"  required></td>
				</tr>
				 <tr>
					<td align="right">Q1:</td>
					<td><input id="Q1" type="text" 
						name="courseQ1"  required></td>
				</tr>
				 <tr>
					<td align="right">Option1:</td>
					<td><input id="Q1A1" type="text" 
						name="courseQ1A1"  required></td>
						</tr>
						<tr>
						<td align="right">Option2:</td>
					<td><input id="Q1A2" type="text" 
						name="courseQ1A2"  required></td>
				</tr>
				<tr>
					<td align="right">Ans:</td>
					<td><input id="Q1A" type="text" 
						name="courseQ1A"  onkeyup="checkAns();" 
						onchange="checkAns();" required></td>
				</tr>
				<tr>
					
					<td align="right">Answer Validation: </td>
					<td align="right"><p id="confirmError"></p></td>
					
				
				</tr>
				<tr>
					<td align="right">Q2:</td>
					<td><input id="Q2" type="text" 
						name="courseQ2"  required></td>
				</tr>
				 <tr>
					<td align="right">Option1:</td>
					<td><input id="Q2A1" type="text" 
						name="courseQ2A1"  required></td>
						</tr>
						<tr>
						<td align="right">Option2:</td>
					<td><input id="Q2A2" type="text" 
						name="courseQ2A2"  required></td>
				</tr>
				<tr>
					<td align="right">Ans:</td>
					<td><input id="Q2A" type="text"  onkeyup="onecheckAnss();" 
						onchange="onecheckAnss();" name="courseQ2A"  required></td>
				</tr>
				<tr>
					
					<td align="right">Answer Validation: </td>
					<td align="right"><p id="confirmErrorr"></p></td>
					
				
				</tr>
				<tr>
					<td align="right">Q3:</td>
					<td><input id="Q3" type="text" 
						name="courseQ3"  required></td>
				</tr>
				 <tr>
					<td align="right">Option1:</td>
					<td><input id="Q3A1" type="text" 
						name="courseQ3A1"  required></td>
						</tr>
						<tr>
						<td align="right">Option2:</td>
					<td><input id="Q3A2" type="text" 
						name="courseQ3A2"  required></td>
				</tr>
				<tr>
					<td align="right">Ans:</td>
					<td><input id="Q3A" type="text" onkeyup="twocheckAnsss();" 
						onchange="twocheckAnsss();" name="courseQ3A"  required></td>
				</tr>
				
				<tr>
					
					<td align="right">Answer Validation: </td>
					<td align="right"><p id="confirmErrorrr"></p></td>
					
				
				</tr>
				
				
				
				
				
				
				
			</table>
			<div class="button-layout">
				<button id="submit" type="submit">Submit</button>
				<button id="reset" type="reset">Reset</button>
			</div>
		</div>

	</form>
		
				
				
			
				
				
</body>
</html>