<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<!-- IRFAN AFIFI -->
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>FacultyManageStudent</title>
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
                    <br><h1 class="text-center">Manage Student for Faculty</h1> <!-- TITLE -->
                    <span style="color:#566573"><%=(request.getAttribute("username") == null) ? "": request.getAttribute("username")%></span>
                    <br>
                    <h4 class="text-center">Applied Student List</h4>  <!-- TITLE -->
                   

                    <!-- FUNCTION TO GET DATA OF STUDENT APPLIED FROM DATABASE -->
                     <c:forEach var="course" items="${appliedDetail}" > 
                     
                     <div class="card2" align="center">
                       <table class="table" align="center"> 
                                <tr>
                                	<th>username</th>
                                    <td>
                                        :&nbsp;<c:out value="${course.username}"/>
                                    </td>
                               </tr>
                               <tr>
                               		<th>Course Applied</th>
                                    <td>
                                        :&nbsp;<c:out value="${course.coursename}" />
                                    </td>
                               </tr>
                               <tr> 
                               		<th>Medium</th>
                                    <td>
                                        :&nbsp;<c:out value="${course.medium}" />
                                    </td>
                               </tr> 
								<tr>
                               		<th>Academic Credential</th>   <!-- RETRIEVE PDF FILE -->   
                                    <td>
                                        :&nbsp;
                                 		<form action="${pageContext.request.contextPath}/RetrievePdf" method="get">
											<input type="hidden" name="username" value=<%=(request.getAttribute("username") == null) ? "": request.getAttribute("username")%>>
											<input type="hidden" name="stuusername" value="${course.username}">
											<input type="hidden" name="coursename" value="${course.coursename}">			
											<input class="download" type="submit" value=${course.username}.pdf>
											<img src="https://upload.wikimedia.org/wikipedia/commons/thumb/8/87/PDF_file_icon.svg/1200px-PDF_file_icon.svg.png" height="20px" width="15px">
										</form>
									
                                    </td>
                               </tr>
                                <tr> 
                                	<th>current level</th>    
                                    <td>
                                        :&nbsp;<c:out value="${course.current}" />
                                    </td>
                               </tr> 
                               <tr> 
                                	<th>current Result</th>    
                                    <td>
                                        :&nbsp;<c:out value="${course.result}" />
                                    </td>
                               </tr>
                               <tr> 
                                	<th>Apply Scholarship</th>    
                                    <td>
                                        :&nbsp;<c:out value="${course.scholar}" />
                                    </td>
                               </tr>
                          
                             </table>
                             	
                             	<!-- APPROVE BUTTON -->
                                 <form action="${pageContext.request.contextPath}/FacApproveStuServlet" method="post">
										<input type="hidden" name="username" value=<%=(request.getAttribute("username") == null) ? "": request.getAttribute("username")%>>
										<input type="hidden" name="password" value=<%=(request.getAttribute("password") == null) ? "": request.getAttribute("password")%>>
										<input type="hidden" name="coursename" value="${course.coursename}">
										<input type="hidden" name="stuusername" value="${course.username}">
										<input class=btn type="submit" value="Approve">
								</form>
								
								<!-- NOT APPROVE BUTTON -->
								<form action="${pageContext.request.contextPath}/FacNotApproveServlet" method="post">
										<input type="hidden" name="username" value=<%=(request.getAttribute("username") == null) ? "": request.getAttribute("username")%>>
										<input type="hidden" name="password" value=<%=(request.getAttribute("password") == null) ? "": request.getAttribute("password")%>>
										<input type="hidden" name="coursename" value="${course.coursename}">
										<input type="hidden" name="stuusername" value="${course.username}">
										<input class=btn type="submit" value="Not Approve">
								</form>
								<br>
								<!-- ERROR MESSAGE -->
						       <span style="color:red"><%=(request.getAttribute("errMessage") == null) ? ""
		         						: request.getAttribute("errMessage")%></span>
                             </div>
                           </c:forEach>
                    <br>
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