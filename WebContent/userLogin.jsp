<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<!-- MUEEZ EIMAN -->
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CoursePortal</title>
<!-- FONT -->
<link href="https://fonts.googleapis.com/css2?family=Ubuntu:wght@300&display=swap" rel="stylesheet">
<!-- CSS -->
<style>
     <%@ include file="../Css/login.css"%>
</style>
<!-- INNER CSS -->
<style>
      img.background {
      position: absolute;
      left: 0px;
      top: 0px;
      z-index: -1;
      width: 100%;
      height: 100%;
      -webkit-filter: blur(5px); /* Safari 6.0 - 9.0 */
      filter: blur(5px);

      }
</style>

</head>
<body>
<img class="background" src="https://images.unsplash.com/photo-1554034483-04fda0d3507b?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8M3x8c29mdCUyMGNvbG9yfGVufDB8fDB8fA%3D%3D&w=1000&q=80" alt="background">
    <br><br><br><br><br><br>
    <div class="login" align="center">
    
    	<img src="https://www.seekpng.com/png/detail/873-8734069_mmu-logo-multimedia-university.png" height="130" width="300" alt="loginpic">
	    
	    <!-- LOGIN FORM -->
	    <form name="form" action="UserLoginServlet" method="post" onsubmit="return validate()">
	        <!-- Do not use table to format fields. As a good practice use CSS -->
	        <div class="loginform" align="center">
		         <input type="text" name="username" placeholder="Username" required/>
		         <br>
		         <input type="password" name="password" placeholder="Password" required/>
		         <br>
				<span style="color:red"><%=(request.getAttribute("errMessage") == null) ? ""
		         : request.getAttribute("errMessage")%></span>
		         <br>
		         <input class="btn" type="submit" value="Login"></input>
		         <br>
		         <b><a href="stuRegister.jsp">No Account ? </a></b>
	        </div>
	    </form>
    </div>
</body>
</html>