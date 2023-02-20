<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<!-- MUEEZ EIMAN -->
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>StuProfile</title>
<!-- FONT -->
<link href="https://fonts.googleapis.com/css2?family=Ubuntu:wght@300&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=ZCOOL+XiaoWei&display=swap" rel="stylesheet">
<!-- CSS -->
<style>
     <%@ include file="../Css/stuProfile.css"%>
</style>
</head>
<body>

<div class="container"> <!-- BACKGROUND -->
    <div class="main-body" align="center">
          <div class="row gutters-sm">
            <div class="col-md-4 mb-3">
              <div class="card"  align="center">
                <div class="card-body">
                  <div class="d-flex flex-column align-items-center text-center">
                    <h1>Student Profile</h1> <!-- TITLE -->
                    <img src="https://cdn-icons-png.flaticon.com/512/146/146007.png" alt="Admin" class="rounded-circle" width="150"> <!-- IMAGE -->
                    <div class="mt-3">
                      <h4><%=(request.getAttribute("username") == null) ? "": request.getAttribute("username")%></h4> <!-- GET USERNAME -->
                    </div>
                  </div>
                </div>
              </div>
            </div>
            
            <!-- PRINT STUDENT PROFILE FROM DATABASE -->
            <c:forEach var="student" items="${student}" >
            <div class="col-md-8">
              <div class="card mb-3">
                <div class="card-body">
                  <div class="row">
                    <div class="col-sm-3">
                      <h6 class="mb-0">Student Id</h6>
                    </div>
                    <div class="col-sm-9 text-secondary">
                      <c:out value="${student.id}" />
                    </div>
                  </div>
                  <hr>
                  <div class="row">
                    <div class="col-sm-3">
                      <h6 class="mb-0">Student Name</h6>
                    </div>
                    <div class="col-sm-9 text-secondary">
                      <c:out value="${student.firstName} ${student.lastName}" />
                    </div>
                  </div>
                  <hr>
                  <div class="row">
                    <div class="col-sm-3">
                      <h6 class="mb-0">Gender</h6>
                    </div>
                    <div class="col-sm-9 text-secondary">
                      <c:out value="${student.gender}" />
                    </div>
                  </div>
                  <hr>
                  <div class="row">
                    <div class="col-sm-3">
                      <h6 class="mb-0">Age</h6>
                    </div>
                    <div class="col-sm-9 text-secondary">
                      <c:out value="${student.age}" />
                    </div>
                  </div>
                  <hr>
                  <div class="row">
                    <div class="col-sm-3">
                      <h6 class="mb-0">Course</h6>
                    </div>
                    <div class="col-sm-9 text-secondary">
                      <c:out value="${student.courseName}" />
                    </div>
                  </div>
                  <hr>
                  <div class="row">
                    <div class="col-sm-3">
                      <h6 class="mb-0">Level</h6>
                    </div>
                    <div class="col-sm-9 text-secondary">
                      <c:out value="${student.courseLevel}" />
                    </div>
                  </div>
                  <hr>
                  <div class="row">
                    <div class="col-sm-3">
                      <h6 class="mb-0">Faculty</h6>
                    </div>
                    <div class="col-sm-9 text-secondary">
                      <c:out value="${student.facultyName}" />
                    </div>
                  </div>
                  <hr>
                  <div class="row">
                  <br>
                    <div class="col-sm-12">
                    
                    
                    <!-- EDIT PROFILE BUTTON -->
                <form action="${pageContext.request.contextPath}/StuEditBridgeServlet" method="post">
					<input type="hidden" name="username" value=<%=(request.getAttribute("username") == null) ? "": request.getAttribute("username")%>>
					<input type="hidden" name="password" value=<%=(request.getAttribute("password") == null) ? "": request.getAttribute("password")%>>
					<input class="btn" type="submit" value="Edit">
				</form>	  
					<!-- BACK BUTTON -->   
                 <form action="${pageContext.request.contextPath}/UserLoginServlet" method="post">
					<input type="hidden" name="username" value=<%=(request.getAttribute("username") == null) ? "": request.getAttribute("username")%>>
					<input type="hidden" name="password" value=<%=(request.getAttribute("password") == null) ? "": request.getAttribute("password")%>>
					<input class="btn" type="submit" value="Back">
				</form>	
                    </div>
                  </div>
                </div>
              </div>
            </div>
             </c:forEach>
          </div>
         </div>
       </div>
                


</body>
</html>