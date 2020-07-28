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
function ageCount() {
    var date1 = new Date();
    var dob = document.getElementById("dob").value;
    var date2 = new Date(dob);
    var pattern = /^\d{1,2}\/\d{1,2}\/\d{4}$/;
    //Regex to validate date format (dd/mm/yyyy)       
    if (pattern.test(dob)) {
        var y1 = date1.getFullYear();
        //getting current year            
        var y2 = date2.getFullYear();
        //getting dob year            
        var age = y1 - y2;
        //calculating age   
        if (age>=18 && age<=80) {
        document.getElementById("ageId").value = age;
        doucment.getElementById("ageId").focus ();
        return true;}
        else {
        	alert("You Should be between 18-80 Years of Age");
        	return false;
        }
    } else {
        alert("Invalid date format. Please Input in (dd/mm/yyyy) format!");
        return false;
    }

}
</script>
</head>
<body>
<div class="header">
		<img src="resources/images/logo.jpg" />
	</div>
	<nav id="navbar"> 
		<a href="returnstudentdashboard.hr" class="menu">HOME</a> 
		<a href="studenteditprofile.hr" class="menu">EDIT PROFILE</a> 
		<a href="studentchangepass.hr" class="menu">CHANGE PASS</a> 
		<a href="studentlogout.hr" class="menu">LOGOUT</a> 
	</nav>


<form action="studenteditprofile.hr" method="post">
	
		
		<h2 align="center"> Student Edit Profile</h2>
		<div class="card-layout">
			<table id="table1" ; cellspacing="5px" cellpadding="5%"
				; align="center">
				<tr>
					<td align="right">Aadhar Number:</td>
					<td>
						${student.studentAadharNo}
					</td>
				</tr>
				<tr>
					<td align="right">Name:</td>
					<td><input id="name" type="text" placeholder="AS IN MARKSHEET"
						name="studentName" value="${student.studentName}"
						title="Format: (e.g. Ankit Sharma)" autofocus autocomplete="off" required pattern="^\w+\s\w+$" style="width: 200px;"></td>
				</tr>
				<tr>
					<td align="right">Email:</td>
					<td><input type="email" name="studentEmail" value="${student.studentEmail}"
						style="width: 200px;" id="contact_email" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$" required /></td>
				</tr>
				
                <tr>
					<td align="right">Date Of Birth:</td>
					<td><input type="date"  name="studentDob" value="${student.studentDob}"
					style="width: 200px;" id="dob" onblur="ageCount()" required></td>
				</tr>
				<tr>
					<td align="right">Age.:</td>
					<td><input id="ageId" type="number" value="${student.studentAge}"
						name="studentAge" style="width: 200px;" required></td>
				</tr>
				<tr>
					<td align="right">Location:</td>
					<td><input id="address" type="text" value="${student.studentAddress}"
						name="studentAddress" style="width: 200px;" required></td>
				</tr>
				<tr>
				    <td align="right">Gender :</td>
					<td><select id="input" name="studentGender" value="${student.studentGender}"
						onchange="optionCheck()" required>
							<option value="">------------Choose------------</option>
							<option value="male">Male</option>
							<option value="female">Female</option>
					</select></td>
				</tr>
					<tr>
					<td align="right">Mobile No.:</td>
					<td><input id="mobno" type="number" value="${student.studentMobile}"
						name="studentMobile" style="width: 200px;" required></td>
				</tr>
				<tr>
					<td align="right">Employed?:</td>
					<td><select id="JobId" value="${student.jobId }"
						name="jobId" onchange="optionCheck()" required>
						<option value="">------------Choose------------</option>
						    <option value="1">YES</option>
						    <option value="0">NO</option>
							
							</select>
							
						</td>
				</tr>
				</table>
				
				<table id="table1" ; cellspacing="5px" cellpadding="5%"
				; align="center">
				<h3 align="center">10th Class</h3>
				<tr>
					<td align="right">Passing Year:</td>
					<td><input id="passx" type="Number" value="${student.student10thYear}"
						name="student10thYear" style="width: 200px;" required></td>
				</tr>
				<tr>
					<td align="right">Passing %:</td>
					<td><input id="perx" type="Number" value="${student.student10thPercentage}"
						name="student10thPercentage" style="width: 200px;" required></td>
				</tr>
			</table>
			            <table id="table1" ; cellspacing="5px" cellpadding="5%"
				; align="center">
				<h3 align="center">12th Class</h3>
				
				<tr>
					<td align="right">Passing Year:</td>
					<td><input id="passxii" type="Number" value="${student.student12thYear}"
						name="student12thYear" style="width: 200px;" required></td>
				</tr>
				<tr>
					<td align="right">Passing %:</td>
					<td><input id="perxii" type="Number" value="${student.student12thPercentage}"
						name="student12thPercentage" style="width: 200px;" required></td>
				</tr>
				<tr>
					<td align="right"><input type="checkbox" value="confirm" required>
					</td>
					<td>ALL THE INFORMATION FURNISHED BY ME <br> IS TRUE TO
						BEST OF MY KNOWLEDGE.
					</td>
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