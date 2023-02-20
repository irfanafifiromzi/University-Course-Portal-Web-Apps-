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

/*class to forward the parameter from facManageStudent.jsp to be send it to mysql */
public class FacApproveStuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
    public FacApproveStuServlet() {

    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FacManageDao FacManageDAO = new FacManageDao();
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String coursename = request.getParameter("coursename");
		String stuusername = request.getParameter("stuusername");
		
		request.setAttribute("username", username); 
        request.setAttribute("password", password);
        
        /*Method to get faculty name using faculty username/id*/
        String facName = FacManageDAO.getFacultyName(username);
        /*Method to get course level*/
        String courselevel = FacManageDAO.getCourseLevel(coursename);
        
        try {
        	/*Method to update student data (course detail) in mysql*/
			boolean update = FacManageDAO.approveStu(coursename, courselevel, facName, stuusername);
			
			if (update == true) {
				
				request.setAttribute("username", username); 
	            request.setAttribute("password", password);
	            /*method to delete student apply data in mysql*/
	            boolean deleteStu = FacManageDAO.deleteApply(stuusername,coursename);
	            update = false;
	            /*forward the parameter to another servlet to update the list in web page*/
	            RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/FacManageStuBridgeServlet");
	            dispatcher.forward(request, response);
	            
	            
			}else {
				
				request.setAttribute("username", username); 
	            request.setAttribute("password", password);
	            request.setAttribute("errMessage", "Update failed !");
	            RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/FacManageStuBridgeServlet");
	            dispatcher.forward(request, response);
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
