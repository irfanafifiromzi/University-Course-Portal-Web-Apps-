<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
         <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<!-- IMRAN MIKHAIL -->
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>facultyHome</title>
<!-- FONT -->
<link href="https://fonts.googleapis.com/css2?family=Ubuntu:wght@300&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=ZCOOL+XiaoWei&display=swap" rel="stylesheet">
<!-- CSS -->
<style>
     <%@ include file="../Css/facultyHome.css"%>
</style>
</head>
<body>

<div class="main-body" align="center"> <!-- BACKGROUND -->
<div class="Home" align="center">
	<div class="header" align="center">
	  <br><h1>Faculty Administrator</h1> <!-- TITLE -->
	</div>	
		
		   <div class="position" align="center">					
			<div class="position" align="left">	

			  <div class="card" align="center"> 
				<img src="https://cdn-icons-png.flaticon.com/512/3220/3220404.png" alt="Admin" class="rounded-circle" width="120"> <!-- IMAGE -->

				<h4><%=(request.getAttribute("facName") == null) ? "": request.getAttribute("facName")%></h4> <!-- FACULTY NAME -->

				
					<div class="allbtn" align="center"> <!-- ALL BUTTON -->
					<form action="${pageContext.request.contextPath}/FacViewCourseServlet" method="post">
						<input type="hidden" name="username" value=<%=(request.getAttribute("username") == null) ? "": request.getAttribute("username")%>>
						<input type="hidden" name="password" value=<%=(request.getAttribute("password") == null) ? "": request.getAttribute("password")%>>
						<input class=btn type="submit" value="Manage Courses">
					</form>	
					<form action="${pageContext.request.contextPath}/FacManageStuBridgeServlet" method="post">
						<input type="hidden" name="username" value=<%=(request.getAttribute("username") == null) ? "": request.getAttribute("username")%>>
						<input type="hidden" name="password" value=<%=(request.getAttribute("password") == null) ? "": request.getAttribute("password")%>>
						<input class=btn type="submit" value="Manage Students">
					</form>
					<form action="${pageContext.request.contextPath}/UserLogOutServlet" method="get">
						<input type="hidden" name="username" value=<%=(request.getAttribute("username") == null) ? "": request.getAttribute("username")%>>
						<input type="hidden" name="password" value=<%=(request.getAttribute("password") == null) ? "": request.getAttribute("password")%>>
						<input class="btn" type="submit" value="Log Out">
					</form>

					</div>
			  </div>	  
			</div>	
		</div>

</div>
</div>


</body>
</html>