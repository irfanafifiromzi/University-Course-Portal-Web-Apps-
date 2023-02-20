<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ page import="java.net.URLEncoder" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<!-- IBRAHIM -->
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>StudentApplyCourse</title>
<!-- FONT -->
<link href="https://fonts.googleapis.com/css2?family=Ubuntu:wght@300&display=swap" rel="stylesheet">
<!-- CSS -->
<style>
     <%@ include file="../Css/stuApply.css"%>
</style>
<!-- JS TO GIVE NOTIFICATION AFTER COURSE APPLIED -->
<script> 
function validate()
{ 
     alert("Course Applied ! Course Registration takes few days to process."); 
}
</script> 
</head>
<body>
<div align="center">
  <div class="card" align="center">
   	 <div align="center">
   	 	<h1>Apply Course</h1> <!-- TITLE -->
   	 	
	    <form name="form" action="StuApplyServlet" enctype='multipart/form-data' method="post" onsubmit="return validate()"> <!-- APPLY COURSE FORM -->
	    
			<div class="form-input py-2">
			        <div class="form-group">
			         <input type="hidden" name="username" value=<%=(request.getAttribute("username") == null) ? "": request.getAttribute("username")%>>
					 <input type="hidden" name="password" value=<%=(request.getAttribute("password") == null) ? "": request.getAttribute("password")%>>
					 <input type="hidden" name="coursename" value=<%=URLEncoder.encode((String)request.getAttribute("coursename"), "ISO-8859-1") %>>
			         <label>Course : <%=(request.getAttribute("coursename") == null) ? "": request.getAttribute("coursename")%></label><br><br>
			         <label>Requirements : <%=(request.getAttribute("requirement") == null) ? "": request.getAttribute("requirement")%></label>
	
			  		</div> <br>
			  <div class="coursemedium">
		        <label for="coursemedium">Learning Medium : </label>
		        <select id="coursemedium" name="coursemedium">
	    			<option value="Physical">Physical</option>
	    			<option value="Online">Online</option>
	  			</select><br><br></div> 
	  			
	 		<div class="current">
		        <label for="current">Current level of study related to the field : </label>
		        <select id="current" name="current">
	    			<option value="SPM">SPM</option>
	    			<option value="Foundation">Foundation</option>
	    			<option value="Diploma">Diploma</option>
	    			<option value="Degree">Degree</option>
	    			<option value="Master">Master</option>
	  			</select><br><br></div> 
	  			
	  			<div class="form-group">
	  			<label>Current CGPA/Exam Result : </label>
	  			 <input type="text" name="cgpa" placeholder=" e.g : 3.56 / 7A" required>
	  			 </div><br>
	  			                               
			        <div class="form-group" >
			          <label>Upload Academic Credentials (.pdf) : </label><br> <!-- UPLOAD PDF -->
			          <input style = "position:relative; left:80px;" type="file" name="pdfFile"
			                 class="form-control" accept=".pdf"
			                 title="Upload PDF" required/>
			        </div><br><br>
			        
			    <div class="scholarship">  <!-- SCHOLARSHIP DETAILS -->
			    <h4 align="left">
			    Scholarship MARA,TM,Petronas details : <br><br>
			    1.Diploma : SPM result 7A and above <br>
			    2.Degree : Diploma CGPA and above / <br>
			    Foundation CGPA 3.70 and above / STPM with <br>
			    CGPA 3.65 <br>
				3.Master : Degree CGPA 3.70 and above <br>
				4.PHD : A Master's Degree (Level 9 , MQF) <br><br>
				~#~ If you did not reach the scholarship <br>
				requirement, your scholarship application will be dissaprove ~#!
			    </h4>
		        <label for="scholarship">Scholarship : </label>
		        <select id="scholarship" name="scholarship">
	    			<option value="Yes">Yes</option>
	    			<option value="No">No</option>
	  			</select><br><br></div> 
			        
			        <div class="form-group">
			          <input type="submit" class="btn" name="submit" value="Apply">
			        </div>
			        
	         </div><br><br>
	      </form>
			
			<!-- BACK BUTTON -->
			<form action="${pageContext.request.contextPath}/StuViewServlet" method="post">
						<input type="hidden" name="username" value=<%=(request.getAttribute("username") == null) ? "": request.getAttribute("username")%>>
						<input type="hidden" name="password" value=<%=(request.getAttribute("password") == null) ? "": request.getAttribute("password")%>>
						<input class=backb type="submit" value="Back">
			</form>	
	   </div>
	</div>	
  </div>	
</body>
</html>