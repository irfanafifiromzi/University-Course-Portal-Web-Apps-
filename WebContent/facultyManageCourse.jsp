<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<!-- IBRAHIM -->
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>facultyViewCourses</title>
<!-- FONT -->
<link href="https://fonts.googleapis.com/css2?family=Ubuntu:wght@300&display=swap" rel="stylesheet">
<!-- CSS -->
<style>
     <%@ include file="../Css/facultyView.css"%>
</style>
</head>
<body>
<div class="main-body" align="center"> <!-- BACKGROUND -->


            <div class="card" align="center"> <!-- WHITE BACKGROUND ON main-body -->
                <div class="container">
                    <br><h1 class="text-center">Manage Courses for Faculty</h1> <!-- TITLE -->
                    <span style="color:#566573"><%=(request.getAttribute("username") == null) ? "": request.getAttribute("username")%></span> <!-- GET USER NAME -->
                    <br>
                    
                    
                    
					<!-- GET LIST OF ALL COURSE FROM DATABASE (LOOP) -->
                     <c:forEach var="course" items="${listCourses}" > 
                         <div class="card2" align="center">
                          <table class="table" align="center">
                                <tr>
                                	<th>Course Id</th>
                                    <td>
                                        :&nbsp;<c:out value="${course.courseId}"/>
                                    </td>
                               </tr>
                               <tr>
                               		<th>Name</th>
                                    <td>
                                        :&nbsp;<c:out value="${course.courseName}" />
                                    </td>
                               </tr>
                               <tr> 
                               		<th>Level</th>
                                    <td>
                                        :&nbsp;<c:out value="${course.courseLevel}" />
                                    </td>
                               </tr> 
                               <tr> 
                               		<th>Faculty Id</th>     
                                    <td>
                                        :&nbsp;<c:out value="${course.facultyId}" />
                                    </td>
                               </tr> 
                                <tr> 
                                	<th>Password</th>    
                                    <td>
                                        :&nbsp;<c:out value="${course.password}" />
                                    </td>
                               </tr> 
                               <tr>  
                               		<th>Delete Course</th> <!-- DELETE COURSE BUTTON  --> 
									<td><form action="FacRemoveCourseServlet" method="post">
										  <input type="hidden" name="username" value=<%=(request.getAttribute("username") == null) ? "": request.getAttribute("username")%>>
										  <input type="hidden" name="password" value=<%=(request.getAttribute("password") == null) ? "": request.getAttribute("password")%>>
										  <input type="hidden" name="courseid" value="${course.courseId}">
										  :&nbsp;<input class="btn" type="submit" value="Delete Course">
										</form>
									</td>	 
                                </tr>
                                
                             </table> 
                            </div> 
                           </c:forEach>
                   
                    <br>
                    
                    <br>
                    <!-- ADD COURSE BUTTON -->
                    <form action="${pageContext.request.contextPath}/AddCourseBridgeServlet" method="post">
						<input type="hidden" name="username" value=<%=(request.getAttribute("username") == null) ? "": request.getAttribute("username")%>>
						<input type="hidden" name="password" value=<%=(request.getAttribute("password") == null) ? "": request.getAttribute("password")%>>
						<input class="btn" type="submit" value="Add Course">
					</form>	
                    
                    <!-- BACK BUTTON -->
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