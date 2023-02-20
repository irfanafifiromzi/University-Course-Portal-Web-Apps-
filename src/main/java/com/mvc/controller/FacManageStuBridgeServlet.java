package com.mvc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.mvc.bean.AppliedBean;
import com.mvc.dao.FacManageDao;

/*IRFAN AFIFI*/

/*class to forward request from Manage Students button in facultyHome.jsp to facManageStudent.jsp.jsp*/
public class FacManageStuBridgeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private FacManageDao facManageDAO;
       
	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init() {
		facManageDAO = new FacManageDao(); 
	}
    public FacManageStuBridgeServlet() {

    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		request.setAttribute("username", username); 
        request.setAttribute("password", password);
        
        /*method to get a list of student that applied course from database*/
		List<AppliedBean> appliedDetail = facManageDAO.appliedStudent(username);
		request.setAttribute("appliedDetail", appliedDetail);
        
        RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/facManageStudent.jsp");
        dispatcher.forward(request, response);
		
		
	}

}
