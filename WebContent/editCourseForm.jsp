<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ page import="java.net.URLEncoder" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<!-- IBRAHIM -->
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>EditCourseForm</title>
<!-- FONT -->
<link href="https://fonts.googleapis.com/css2?family=Ubuntu:wght@300&display=swap" rel="stylesheet">
<!-- CSS -->
<style>
     <%@ include file="../Css/editCourse.css"%>
</style>

</head>
<body>
<div class="main-body" align="center"> <!-- BACKGROUND -->
 
 <div class="card" align="center"> <!-- WHITE BACKGROUND ON main-body -->
   <br>
    <h1>Edit Course Details<br>for<br><%=(request.getAttribute("coursename") == null) ? "": request.getAttribute("coursename")%></h1> <!-- TITLE -->

    <form name="form" action="CourseEditDetailsServlet" method="post"  onsubmit="return validate()"> <!-- COURSE FORM AND POST THE INPUT TO SERVLET-->
    
    	<div class="courseform" align="center"> <!-- TAKE INPUT FROM USER -->
    	
    		<br><label>Subject Taught</label><br>
    		<textarea class="textarea" cols="100" rows="7" name="subject" placeholder="e.g : English" required></textarea>
    		<br><label>Course Duration</label><br>
    		<input id="ye" type="text" name="duration" placeholder="e.g: 36 Months" required/>
    		<br><label>Employment Opportunities</label><br>
    		<textarea class="textarea" cols="100" rows="7" name="employment" placeholder="e.g : Engineer,Education" required></textarea>
    		<br><label>Scope of Further Studies</label><br>
    		<textarea class="textarea" cols="100" rows="7" name="scope" placeholder="e.g : Bachelor in Civil Engineering" required></textarea>
    		<br><label>Scholarship Available</label><br>
    		<textarea class="textarea" cols="100" rows="7" name="scholarship" placeholder="e.g : YTP Scholarship" required></textarea>
    		<br><label>Fee Structure</label><br>
			<input id="ye" type="text" name="fee" placeholder="e.g : RM3xxxxx" required/>
    		<br><label>Requirements</label><br>
			<input id="ye" type="text" name="requirements" placeholder="e.g : 3.00 above / 11A" required/>			
	        <input type="hidden" name="coursename" value=<%=URLEncoder.encode((String)request.getAttribute("coursename"), "ISO-8859-1") %>>
	        <input type="hidden" name="username" value=<%=(request.getAttribute("username") == null) ? "": request.getAttribute("username")%>>
			<input type="hidden" name="password" value=<%=(request.getAttribute("password") == null) ? "": request.getAttribute("password")%>>
	        <br>
	        <span style="color:red"><%=(request.getAttribute("errMessage") == null) ? ""
		         : request.getAttribute("errMessage")%></span>
			<br><input class="btn" type="submit" value="Save"></input> <!-- SUBMIT BUTTON -->
			
	    </div>
    </form>
    	
    	<!-- BACK BUTTON -->
		<form action="${pageContext.request.contextPath}/CourseViewDetailsServlet" method="post">
					<input type="hidden" name="username" value=<%=(request.getAttribute("username") == null) ? "": request.getAttribute("username")%>>
					<input type="hidden" name="password" value=<%=(request.getAttribute("password") == null) ? "": request.getAttribute("password")%>>
					<input class=backb type="submit" value="Back">
		</form>	
  </div>
</div>    


</body>
</html>