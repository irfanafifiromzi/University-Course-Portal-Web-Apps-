<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<!-- MUEEZ EIMAN -->
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CoursePortal</title>
<!-- CSS -->
<style>
     <%@ include file="../Css/newCourse.css"%>
</style>
<!-- FONT -->
<link href="https://fonts.googleapis.com/css2?family=Ubuntu:wght@300&display=swap" rel="stylesheet">
</head>
<body>

<div class="main-body" align="center"> <!-- BACKGROUND -->
  <div class="card" align="center"><br> <!-- WHITE BACKGROUND ON main-body -->
    <h1>Add Course<br>for Faculty<br><%=(request.getAttribute("username") == null) ? "": request.getAttribute("username")%></h1> <!-- TITLE -->
    	
    <form name="form" action="FacAddCourseServlet" method="post"  onsubmit="return validate()"> <!-- ADD COURSE FORM -->
    	<div class="courseform" align="center">
    		<br><label>Course Id</label><br>
    		<input type="text" name="courseid" placeholder="e.g : FOE1112 ">
    		<br><label>Course Name</label><br>
			<input type="text" name="coursename" placeholder="e.g : Foundation of ..."/>
			<br>
	        <br><label>Course Level</label><br>
	        <select id="courselevel" name="courselevel">
    			<option value="Diploma">Diploma</option>
    			<option value="Degree">Degree</option>
    			<option value="Master">Master</option>
    			<option value="PHD">PhD</option>
  			</select>
  			<br><label>Password</label><br>
  			<input type="password" name="cpassword" placeholder="At least 6 characters" />
  			<br><label>Confirm Password</label><br>
	        <input type="password" name="conpassword" placeholder="Confirm Password"/>
	        <input type="hidden" name="facultyid" value=<%=(request.getAttribute("username") == null) ? "": request.getAttribute("username")%>>
	        <input type="hidden" name="username" value=<%=(request.getAttribute("username") == null) ? "": request.getAttribute("username")%>>
			<input type="hidden" name="password" value=<%=(request.getAttribute("password") == null) ? "": request.getAttribute("password")%>>
	        <br>
	        <span style="color:red"><%=(request.getAttribute("errMessage") == null) ? ""
		         : request.getAttribute("errMessage")%></span>
			<br><input class="btn" type="submit" value="Create"></input>
	    </div>
    </form>
    
    			<!-- BACK BUTTON -->
    	    	<form action="FacViewCourseServlet" method="post">
					<input type="hidden" name="username" value=<%=(request.getAttribute("username") == null) ? "": request.getAttribute("username")%>>
					<input type="hidden" name="password" value=<%=(request.getAttribute("password") == null) ? "": request.getAttribute("password")%>>
					<input class="btn" type="submit" value="Back">
				</form>
 </div> 
</div>   
</body>
</html>