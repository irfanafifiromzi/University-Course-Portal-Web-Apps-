<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<!-- IBRAHIM -->
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CoursePortal</title>
<!-- CSS -->
<style>
     <%@ include file="../Css/register.css"%>
</style>
<!-- FONT -->
<link href="https://fonts.googleapis.com/css2?family=Ubuntu:wght@300&display=swap" rel="stylesheet">
<!-- FUNCTION JS TO GIVE NOTIFICATION ABOUT PASSWORD REQUIREMENT ALERT -->
<script> 
function validate()
{ 
     var password = document.form.password.value;
     var conpassword= document.form.conpassword.value;
      
     if(password.length<6)
     { 
     alert("Password must be at least 6 characters long."); 
     return false; 
     } 
     else if (password!=conpassword)
     { 
     alert("Confirm Password should match with the Password"); 
     return false;
     }
     else{
    	 alert("Registration Successful"); 
     }

 } 
</script> 
</head>
<body>

<div class="main-body" align="center"> <!-- BACKGROUND -->
 	<div class="card" align="center">

	    <br><h1>Create New Account</h1> <!-- TITLE -->
	    
	    <!-- REGISTRATION FORM -->
	    <form name="form" action="StuRegisterServlet" method="post" onsubmit="return validate()">
	    	<div class="registerform" align="center">
	    		<br><label for="gender">First Name</label><br>
				<input type="text" name="firstname" placeholder="First Name"/>
				<br><label for="gender">Last Name</label><br>
		        <input type="text" name="lastname" placeholder="Last Name"/>
		        <br><label for="gender">Age</label><br>
		        <input type="text" name="age" placeholder="Age"/>

		        <br><label for="gender">Gender</label><br>
		        <select id="gender" name="gender">
	    			<option value="Male">Male</option>
	    			<option value="Female">Female</option>
	  			</select>
	  			<br><label for="gender">Email</label><br>
		        <input type="text" name="email" placeholder="Email"/>
		        <br><label for="gender">Username</label><br>
		        <input type="text" name="username" placeholder="Username"/>
		        <br><label for="gender">Password</label><br>
		        <input type="password" name="password" placeholder="Password" />
		        <br><label for="gender">Confirm Password</label><br>
		        <input type="password" name="conpassword" placeholder="Confirm Password"/>
		        <br><span style="color:red"><%=(request.getAttribute("errMessage") == null) ? ""
			         : request.getAttribute("errMessage")%></span>
				<br><br><input class="btn" type="submit" value="Create"></input><br>
		         <b><a href="userLogin.jsp">Login</a></b>
		    </div>
	    </form>
	    
    </div>
</div>    
</body>
</html>