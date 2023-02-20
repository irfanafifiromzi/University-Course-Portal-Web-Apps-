package com.mvc.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*IRFAN AFIFI*/

/*class to forward request from (edit button in stuProfile.jsp) to (stuEditProfile.jsp)*/
public class StuEditBridgeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public StuEditBridgeServlet() {

    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*get parameter of student keyword from stuProfile.jsp*/
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		request.setAttribute("username", username); 
        request.setAttribute("password", password);
        
        /*send the attribute to next web page*/
        RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/stuEditProfile.jsp");
        dispatcher.forward(request, response);
	}

}
