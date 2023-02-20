package com.mvc.controller;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*IRFAN AFIFI*/

/*class to forward request from Edit course button in courseEditDetail.jsp to editCourseForm.jsp*/
public class EditCourseBridgeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public EditCourseBridgeServlet() {
    }

    /*Post attribute to editCourseForm.jsp*/
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/*Get parameter from courseEditDetail.jsp*/
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String courseName = request.getParameter("coursename");
		
		request.setAttribute("username", username); 
        request.setAttribute("password", password);
        request.setAttribute("coursename", courseName);
        
        /*send parameter to editCourseForm.jsp*/
        RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/editCourseForm.jsp");
        dispatcher.forward(request, response);
	}

}
