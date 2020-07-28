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
<!--script src="resources/JS/student-registration.js"></script-->
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
		<a href="home.hr" class="menu">HOME</a> 
		<a href="home.hr" class="menu">ABOUT US</a> 
		<a href="home.hr" class="menu">CONTACT US</a> 
	</nav>



	<form action="studentRegistration.hr" method="post">
		
		<h2 align="center">Fresh Student Registration Form</h2>
		<div class="card-layout">
			<table id="table1" ; cellspacing="5px" cellpadding="5%"
				; align="center">
				
				
				<tr>
					<td align="right">Aadhar Number:</td>
					<td><input type="text" style="width: 200px;" placeholder="####"
						name="studentAadharNo" id="aadhar_no" title="Format: (e.g. #### digits)" pattern="^\d{4}$"  required></td>
				</tr>
				<tr>
					<td align="right">Name:</td>
					<td><input id="name" type="text" placeholder="AS IN MARKSHEET"
						name="studentName" title="Format: (e.g. Ankit Sharma)" autofocus autocomplete="off" required pattern="^\w+\s\w+$" style="width: 200px;"></td>
				</tr>
			    <tr>
					<td align="right">Email:</td>
					<td><input type="email" name="studentEmail"
						style="width: 200px;" id="contact_email" title="Format: (e.g. name@gmail.com)" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$" required /></td>
				</tr>
				
                <tr>
					<td align="right" >Date Of Birth:</td>
					<td><input type="date"  name="studentDob" placeholder="DD/MM/YY"
					style="width: 200px;" id="dob" onblur="ageCount()" required></td>
				</tr>
				
				<tr>
					<td align="right">Age.:</td>
					<td><input id="ageId" type="number"
						name="studentAge" style="width: 200px;" required></td>
				</tr>
				
				<tr>
					<td align="right">Loacation:</td>
					<td><select id="address" 
						name="studentAddress" onchange="optionCheck()" required>
						<option value="">------------Choose------------</option>
						    <option value="Chennai">CHENNAI</option>
						    <option value="Delhi">DELHI</option>
							<option value="Mumbai">MUMBAI</option>
							<option value="Pune">PUNE</option>
							<option value="Thane">THANE</option>
							<option value="Satara">SATARA</option>
							</select>
							
						</td>
				</tr>
				<tr>
				    <td align="right">Gender :</td>
					<td><select id="input" name="studentGender"
						onchange="optionCheck()" required>
							<option value="">------------Choose------------</option>
							<option value="male">Male</option>
							<option value="female">Female</option>
					</select></td>
				</tr>
					<tr>
					<td align="right">Mobile No.:</td>
					<td><input id="mobno" type="text"
						name="studentMobile" style="width: 200px;" title="Format: (e.g. 10 digits)" pattern="^\d{10}$" required></td>
				</tr>
				<tr>
					<td align="right">Employed?:</td>
					<td><select id="JobId" 
						name="jobId" onchange="optionCheck()" required>
						<option value="">------------Choose------------</option>
						    <option value="1">YES</option>
						    <option value="0">NO</option>
							
							</select>
							
						</td>
				</tr>
				<table id="table1" ; cellspacing="5px" cellpadding="5%"
				; align="center">
				<h3 align="center">10th Class</h3>
				<tr>
					<td align="right">Passing Year:</td>
					<td><input id="passx" type="Number" placeholder="YYYY"
						name="student10thYear" style="width: 200px;" title="Format: (e.g. YYYY )" pattern="^\d{4}$" required></td>
				</tr>
				<tr>
					<td align="right">Passing %:</td>
					<td><input id="perx" type="text"
						name="student10thPercentage" style="width: 200px;" required></td>
				</tr>
			</table>
			            <table id="table1" ; cellspacing="5px" cellpadding="5%"
				; align="center">
				<h3 align="center">12th Class</h3>
				
				<tr>
					<td align="right">Passing Year:</td>
					<td><input id="passxii" type="text" placeholder="YYYY"
						name="student12thYear" style="width: 200px;" title="Format: (e.g. YYYY )" pattern="^\d{4}$" required></td>
				</tr>
				<tr>
					<td align="right">Passing %:</td>
					<td><input id="perxii" type="Number"
						name="student12thPercentage" style="width: 200px;" required></td>
				</tr>
			</table>
				
			
				
				<!-- <tr>
					<td align="right">Set your Password:</td>
					<td><input type="password" style="width: 200px;"
						name="studentPassword" id="set_pass" pattern="(?=^.{8,}$)(?=.*[a-z])(?=.*[A-Z])(?!.*\s).*$" title="Password min 8 characters. At least one UPPERCASE and one lowercase letter" required /></td>
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
					
				
				</tr> -->
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