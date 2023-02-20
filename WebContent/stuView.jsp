<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
     <%@ page import="java.net.URLEncoder" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<!-- IRFAN AFIFI -->
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>stuViewCourses</title>
<!-- FONT -->
<link href="https://fonts.googleapis.com/css2?family=Ubuntu:wght@300&display=swap" rel="stylesheet">
<!-- CSS -->
<style>
     <%@ include file="../Css/stuView.css"%>
</style>
<!-- INNER CSS -->
<style>
.dropbtn {
  font-family: 'Ubuntu', sans-serif;
  box-shadow: 0 3px 10px rgb(0 0 0 / 0.3);
  background-color: #166DBF;
  color: white;
  padding: 16px;
  font-size: 16px;
  border: none;
  cursor: pointer;
  width : 100%;
  border-radius: .25rem;
}

.button {
  font-family: 'Ubuntu', sans-serif;
  box-shadow: 0 3px 10px rgb(0 0 0 / 0.3);
  background-color: #164672;
  color: white;
  padding: 16px;
  font-size: 16px;
  border: none;
  cursor: pointer;
  width : 100%;
  border-radius: .25rem;
}

.dropdown {
  position: relative;
  display: inline-block;
  width:100%;
}

.dropdown-content {
  display: none;
  position: absolute;
  background-color: #f9f9f9;
  min-height:250px;
  box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
  border-radius: .25rem;
  z-index: 1;
}

.dropdown-content p {
  font-family: 'Ubuntu', sans-serif;
  color: black;
  padding: 12px 16px;
  text-decoration: none;
  display: block;
}

.dropdown-content {
  right: 0;
}

.dropdown-content p:hover {background-color: #f1f1f1}

.dropdown:hover .dropdown-content {
  display: block;
}

.dropdown:hover .dropbtn {
  background-color: #096F9D;
}

.button:hover {
	background-color: #143D64;
}

#list-items,#list-items2, #list-items3, #list-items4{
    display: none;
}

}
</style>

<!-- FUNCTION JS DROPDOWN LIST WHEN ONCLICK -->
<script>
      //show and hide dropdown list item on button click
      function show_hide() {
         var click = document.getElementById("list-items");
         if(click.style.display ==="none") {
            click.style.display ="block";
         } else {
            click.style.display ="none";
         } 
      }
      
      function show_hide2() {
          var click = document.getElementById("list-items2");
          if(click.style.display ==="none") {
             click.style.display ="block";
          } else {
             click.style.display ="none";
          } 
       }
      
      
      function show_hide3() {
          var click = document.getElementById("list-items3");
          if(click.style.display ==="none") {
             click.style.display ="block";
          } else {
             click.style.display ="none";
          } 
       }
      
      function show_hide4() {
          var click = document.getElementById("list-items4");
          if(click.style.display ==="none") {
             click.style.display ="block";
          } else {
             click.style.display ="none";
          } 
       }
</script>

</head>
<body>

<div align="center">

   <div class="card" align="center">
    <div align="center">
       <h1>Courses Briefing</h1> <!-- VIDEO TITLE -->
		<video id="myVideo" width="500" height="300" controls>
		  <source src="vid.mp4" type="video/mp4">
		  <source src="vid.mp4" type="video/ogg">
		  Your browser does not support the video tag.
		</video><br><br>
	</div>
	<br>
   </div><br>


   <div class="card2" align="center">
   		<h1>Courses Information</h1> <!-- TITLE -->
   		
 
    <button onclick="show_hide()" class="button">Diploma </button> <!-- BUTTON DIPLOMA  -->
    
    <div  id="list-items">
	    <c:forEach var="stu" items="${dipCourse}"> <!-- DROPDOWN DIPLOMA COURSE DETAILS -->
	     
	    <div class="dropdown">       
		<button class="dropbtn"> <c:out value="${stu.courseName}" /> </button>
			<div class="dropdown-content" align="left">
			  <p>Level : <c:out value="${stu.courseLevel}" /> <br>
			  	 Subject Taught : <c:out value="${stu.subjectTaught}" /> <br>
			     Duration : <c:out value="${stu.courseDuration}" /> <br>
			     Employment Opportunities : <c:out value="${stu.employmentOpportunities}" /> <br>
			     Scope of Further Studies : <c:out value="${stu.scopeFurtherStu}" /> <br>
			     Scholarship : <c:out value="${stu.scholarship}" /> <br>
			     Fee Structure : <c:out value="${stu.fee}" /> <br>
			     Requirements : <c:out value="${stu.requirements}" /> <br>
			  </p>
			  <div align="center">
				<form action="${pageContext.request.contextPath}/StuApplyBridgeServlet" method="post">
					<input type="hidden" name="username" value=<%=(request.getAttribute("username") == null) ? "": request.getAttribute("username")%>>
					<input type="hidden" name="coursename" value="${stu.courseName}">
					<input type="hidden" name="requirement" value="${stu.requirements}">
					<input type="hidden" name="password" value=<%=(request.getAttribute("password") == null) ? "": request.getAttribute("password")%>>
					<input class=btn type="submit" value="Apply">
				</form>
				</div>
		  </div>
		</div><br> 
		
		 </c:forEach>
	 </div>
	 
	<button onclick="show_hide2()" class="button">Degree </button>  <!-- DEGREE BUTTON -->
    
    <div  id="list-items2">
	    <c:forEach var="stu" items="${degCourse}"> <!-- DROPDOWN DEGREE COURSES DETAILS -->
	     
	    <div class="dropdown">       
		<button class="dropbtn"> <c:out value="${stu.courseName}" /> </button>
			<div class="dropdown-content" align="left">
			  <p>Level : <c:out value="${stu.courseLevel}" /> <br>
			  	 Subject Taught : <c:out value="${stu.subjectTaught}" /> <br>
			     Duration : <c:out value="${stu.courseDuration}" /> <br>
			     Employment Opportunities : <c:out value="${stu.employmentOpportunities}" /> <br>
			     Scope of Further Studies : <c:out value="${stu.scopeFurtherStu}" /> <br>
			     Scholarship : <c:out value="${stu.scholarship}" /> <br>
			     Fee Structure : <c:out value="${stu.fee}" /> <br>
			     Requirements : <c:out value="${stu.requirements}" /> <br>
			  </p>
			  <div align="center">
			  	<!-- APPLY BUTTON -->
				<form action="${pageContext.request.contextPath}/StuApplyBridgeServlet" method="post">
					<input type="hidden" name="username" value=<%=(request.getAttribute("username") == null) ? "": request.getAttribute("username")%>>
					<input type="hidden" name="coursename" value="${stu.courseName}">
					<input type="hidden" name="requirement" value="${stu.requirements}">
					<input type="hidden" name="password" value=<%=(request.getAttribute("password") == null) ? "": request.getAttribute("password")%>>
					<input class=btn type="submit" value="Apply">
				</form>
				</div>
		  </div>
		</div><br> 
		
		 </c:forEach>
	 </div>
	 
	 
	 	<button onclick="show_hide3()" class="button">Master </button> <!-- MASTER BUTTON -->
    
    <div  id="list-items3">
	    <c:forEach var="stu" items="${masCourse}"> <!-- DROPDOWN MASTER COURSE DETAILS -->
	     
	    <div class="dropdown">       
		<button class="dropbtn"> <c:out value="${stu.courseName}" /> </button>
			<div class="dropdown-content" align="left">
			  <p>Level : <c:out value="${stu.courseLevel}" /> <br>
			  	 Subject Taught : <c:out value="${stu.subjectTaught}" /> <br>
			     Duration : <c:out value="${stu.courseDuration}" /> <br>
			     Employment Opportunities : <c:out value="${stu.employmentOpportunities}" /> <br>
			     Scope of Further Studies : <c:out value="${stu.scopeFurtherStu}" /> <br>
			     Scholarship : <c:out value="${stu.scholarship}" /> <br>
			     Fee Structure : <c:out value="${stu.fee}" /> <br>
			     Requirements : <c:out value="${stu.requirements}" /> <br>
			  </p>
			  <div align="center">
				<form action="${pageContext.request.contextPath}/StuApplyBridgeServlet" method="post">
					<input type="hidden" name="username" value=<%=(request.getAttribute("username") == null) ? "": request.getAttribute("username")%>>
					<input type="hidden" name="coursename" value="${stu.courseName}">
					<input type="hidden" name="requirement" value="${stu.requirements}">
					<input type="hidden" name="password" value=<%=(request.getAttribute("password") == null) ? "": request.getAttribute("password")%>>
					<input class=btn type="submit" value="Apply">
				</form>
				</div>
		  </div>
		</div><br> 
		
		 </c:forEach>
	 </div>
	 
	 
	 	<button onclick="show_hide4()" class="button">PHD</button>  <!-- PHD BUTTON -->
    
    <div  id="list-items4">
	    <c:forEach var="stu" items="${phdCourse}"> <!-- DROPDOWN PHD COURSES DETAILS -->
	     
	    <div class="dropdown">       
		<button class="dropbtn"> <c:out value="${stu.courseName}" /> </button>
			<div class="dropdown-content" align="left">
			  <p>Level : <c:out value="${stu.courseLevel}" /> <br>
			  	 Subject Taught : <c:out value="${stu.subjectTaught}" /> <br>
			     Duration : <c:out value="${stu.courseDuration}" /> <br>
			     Employment Opportunities : <c:out value="${stu.employmentOpportunities}" /> <br>
			     Scope of Further Studies : <c:out value="${stu.scopeFurtherStu}" /> <br>
			     Scholarship : <c:out value="${stu.scholarship}" /> <br>
			     Fee Structure : <c:out value="${stu.fee}" /> <br>
			     Requirements : <c:out value="${stu.requirements}" /> <br>
			  </p>
			  <div align="center">
				<form action="${pageContext.request.contextPath}/StuApplyBridgeServlet" method="post">
					<input type="hidden" name="username" value=<%=(request.getAttribute("username") == null) ? "": request.getAttribute("username")%>>
					<input type="hidden" name="coursename" value="${stu.courseName}">
					<input type="hidden" name="requirement" value="${stu.requirements}">
					<input type="hidden" name="password" value=<%=(request.getAttribute("password") == null) ? "": request.getAttribute("password")%>>
					<input class=btn type="submit" value="Apply">
				</form>
				</div>
		  </div>
		</div><br> 
		
		 </c:forEach>
	 </div>
	
	
	 
	 	<div><br> <!-- BACK BUTTON -->
			<form action="${pageContext.request.contextPath}/UserLoginServlet" method="post">
				<input type="hidden" name="username" value=<%=(request.getAttribute("username") == null) ? "": request.getAttribute("username")%>>
				<input type="hidden" name="password" value=<%=(request.getAttribute("password") == null) ? "": request.getAttribute("password")%>>
				<input class=btn type="submit" value="Back">
			</form>	
		</div>
	</div> 	
 
</div>

</body>
</html>