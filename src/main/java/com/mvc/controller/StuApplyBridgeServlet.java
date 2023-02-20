package com.mvc.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*IRFAN AFIFI*/

/*class to forward request from (apply button in stuView.jsp) to (stuApplyCourse.jsp)*/
public class StuApplyBridgeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public StuApplyBridgeServlet() {

    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*Get parameter of courses detail from stuView.jsp*/
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String coursename = request.getParameter("coursename");
		String requirement = request.getParameter("requirement");
		
		request.setAttribute("username", username); 
        request.setAttribute("password", password);
        request.setAttribute("coursename", coursename);
        request.setAttribute("requirement", requirement);

        /*send the detail*/
        RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/stuApplyCourse.jsp");
        dispatcher.forward(request, response);

	}

}
