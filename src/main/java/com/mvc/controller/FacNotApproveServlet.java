package com.mvc.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.dao.FacManageDao;

/*IRFAN AFIFI*/

/*class to delete a student data in database when they not meet requirements*/
public class FacNotApproveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public FacNotApproveServlet() {

    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FacManageDao FacManageDAO = new FacManageDao();
		
		/*get student data as parameter from facManageStudent.jsp*/
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String coursename = request.getParameter("coursename");
		String stuusername = request.getParameter("stuusername");
		
		try {
			request.setAttribute("username", username); 
            request.setAttribute("password", password);
            /*Method to delete the student data in mysql database*/
			boolean deleteStu = FacManageDAO.deleteApply(stuusername,coursename);
			/*reload page of updated data*/
            RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/FacManageStuBridgeServlet");
            dispatcher.forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
