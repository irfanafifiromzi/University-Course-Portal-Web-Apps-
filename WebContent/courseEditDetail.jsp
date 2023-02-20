<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<!-- IRFAN AFIFI -->
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CourseEditDetails</title>
<!-- FONT STYLE -->
<link href="https://fonts.googleapis.com/css2?family=Ubuntu:wght@300&display=swap" rel="stylesheet">
<!-- CSS FILE -->
<style>
     <%@ include file="../Css/courseView.css"%>
</style>
</head>
<body>
<div class="main-body" align="center"> <!-- BACKGROUND -->
			
            <div class="card" align="center"> <!-- WHITE BACKGROUND ON main-body -->
                <div class="container">
                    <br><h1>Edit Courses Details</h1> <!-- TITLE -->
                    <span style="color:#566573"><%=(request.getAttribute("username") == null) ? "": request.getAttribute("username")%></span> <!-- GET USERNAME -->
                   
                    <br>
                 			<!-- PRINT COURSE DETAILS FROM DATABASE IN FORM OF TABLE (LOOP) -->
                            <c:forEach var="course" items="${courseDetail}" >
                              <div class="card2" align="center">
								<table class="table">
                                <tr>
                                	<th>Course Name</th>
                                    <td >
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
                                	<th>Subject Taught</th> 
                                    <td>
                                        :&nbsp;<c:out value="${course.subjectTaught}" />
                                    </td>
                                </tr>    
							    <tr>
							    	<th>Duration</th>
                                    <td>
                                        :&nbsp;<c:out value="${course.courseDuration}" />
                                    </td>
                                </tr>    
                                <tr>   
                                	<th>Employment Opportunities</th> 
                                    <td>
                                        :&nbsp;<c:out value="${course.employmentOpportunities}" />
                                    </td>
                                </tr>   
                                <tr>    
                                	<th>Scope of Further Studies</th>
                                    <td>
                                        :&nbsp;<c:out value="${course.scopeFurtherStu}" />
                                    </td>
                                </tr>    
                                <tr>    
                                	<th>Scholarship</th>
                                    <td>
                                        :&nbsp;<c:out value="${course.scholarship}" />
                                    </td>
                                </tr>    
                                <tr>    
                                	<th>Fee Structure</th>
                                    <td>
                                        :&nbsp;<c:out value="${course.fee}" />
                                    </td>
                                </tr>  
                                <tr>    
                                	<th>Requirements</th>
                                    <td>
                                        :&nbsp;<c:out value="${course.requirements}" />
                                    </td>
                                </tr>  
                                <tr>  
                                	<th>Edit Details</th> <!-- EDIT BUTTON  -->
                                    <td><form action="EditCourseBridgeServlet" method="post">
										  <input type="hidden" name="username" value=<%=(request.getAttribute("username") == null) ? "": request.getAttribute("username")%>>
										  <input type="hidden" name="password" value=<%=(request.getAttribute("password") == null) ? "": request.getAttribute("password")%>>
										  <input type="hidden" name="coursename" value="${course.courseName}">
										   :&nbsp;<input class="btn" type="submit" value="Edit Details">
										</form>
									</td>
								</tr>
								
						</table>
						</div>
                      </c:forEach>

                    <br>
                 
             
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