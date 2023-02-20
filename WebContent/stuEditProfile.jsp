<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<!-- MUEEZ EIMAN -->
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student Edit Profile</title>
<!-- CSS -->
<style>
     <%@ include file="../Css/newCourse.css"%>
</style>
<!-- FONT -->
<link href="https://fonts.googleapis.com/css2?family=Ubuntu:wght@300&display=swap" rel="stylesheet">
<!-- JS TO GIVE NOTIFICATION  -->
<script> 
function validate()
{ 
    alert("Update Saved"); 

 } 
</script> 
</head>
<body>
<body>

<div class="main-body" align="center"> <!-- BACKGROUND -->
  <div class="card" align="center"><br>
    <h1>Edit Profile</h1> <!-- TITLE -->
    	
    <form name="form" action="StuEditProfileServlet" method="post" onsubmit="return validate()"> <!-- EDIT PROFILE FORM -->
    	<div class="courseform" align="center">
    		<br><label>First Name</label><br>
    		<input type="text" name="firstname" placeholder="First Name" required>
    		<br><label>Last Name</label><br>
			<input type="text" name="lastname" placeholder="Last Name" required/>
  			<br><label>Age</label><br>
	        <input type="text" name="age" placeholder="Age" required/>
	        <input type="hidden" name="username" value=<%=(request.getAttribute("username") == null) ? "": request.getAttribute("username")%>>
			<input type="hidden" name="password" value=<%=(request.getAttribute("password") == null) ? "": request.getAttribute("password")%>>
	        <br>
	        <span style="color:red"><%=(request.getAttribute("errMessage") == null) ? ""
		         : request.getAttribute("errMessage")%></span>
			<br><input class="btn" type="submit" value="Save"></input>
	    </div>
    </form>
    			<!-- BACK BUTTON -->
    	    	<form action="StuProfileServlet" method="post">
					<input type="hidden" name="username" value=<%=(request.getAttribute("username") == null) ? "": request.getAttribute("username")%>>
					<input type="hidden" name="password" value=<%=(request.getAttribute("password") == null) ? "": request.getAttribute("password")%>>
					<input class="btn" type="submit" value="Back">
				</form>
 </div> 
</div>   
</body>
</body>
</html>