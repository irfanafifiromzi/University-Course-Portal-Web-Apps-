package com.mvc.controller;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/*IRFAN AFIFI*/

/*class to forward request from add (course button in faculty Manage Course) to (add course form page)*/
public class AddCourseBridgeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AddCourseBridgeServlet() {

    }

    /*post all attribute to facAddCourse.jsp (Go to the web page)*/
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			/*Get parameter from facManageCourse.jsp*/
			String username = request.getParameter("username");
			String password = request.getParameter("password");

			/*set attribute to be send to next web page*/
			request.setAttribute("username", username); 
            request.setAttribute("password", password);
            
            /*Dispatch the attribute to the page*/
            RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/facAddCourse.jsp");
            dispatcher.forward(request, response);

	}
}
