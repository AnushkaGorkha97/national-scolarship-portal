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
	<nav id="navbar"> 
		<a href="returninstitutedashboard.hr" class="menu">HOME</a> 
		<a href="instituteeditprofile.hr" class="menu">EDIT PROFILE</a> 
		<a href="institutechangepass.hr" class="menu">CHANGE PASS</a> 
	    <a href="institutelogout.hr" class="menu">LOGOUT</a> 
	</nav>
	
	<form action="instituteeditprofile.hr" method="post">
		
		<h2 align="center">Institute Edit Profile</h2>
		<div class="card-layout">
			<table id="table1" ; cellspacing="5px" cellpadding="5%"
				; align="center">
	           <tr>
					<td align="right">Institute Code:</td>
					<td>
					${institute.instituteCode} 
					</td>
					</tr>
	            
	            <tr>
					<td align="right">Institute Name:</td>
					<td><input id="name" type="text" value="${institute.instituteName}"
						name="instituteName"  required></td>
				</tr>
	            <tr>
					<td align="right">Email:</td>
					<td><input type="email" name="instituteEmail" value="${institute.instituteEmail}"
						style="width: 200px;" id="contact_email" title="Format: (e.g. name@gmail.com)" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$" required /></td>
				</tr>
				<tr>
						<td align="right">University Contact Number:</td>
						<td><input id="insititueMob" type="text" name="instituteMobile" value="${institute.instituteMobile}"
							style="width: 200px;" title="Format: (e.g. 10 digits)" pattern="^\d{10}$"  required></td>
					</tr>
	            <tr>
					<td align="right">Location:</td>
					<td><select id="address" 
						name="instituteAddress" onchange="optionCheck()" value="${institute.instituteAddress}" required>
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
					<td align="right">Institute Type:</td>
					<td><select id="insttype" value="${institute.instituteType}"
						name="instituteType" onchange="optionCheck()" required>
						<option value="">------------Choose------------</option>
						    <option value="Autonomous">Autonomous</option>
						    <option value="Non-Autonomous">Non-Autonomous</option>
							<option value="Others">Others</option>
	                     </select>
	                     </td>
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