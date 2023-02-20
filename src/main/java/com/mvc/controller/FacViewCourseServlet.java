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

import com.mvc.bean.CoursesBean;
import com.mvc.dao.FacManageDao;

/*IRFAN AFIFI*/

/*class to send list of courses from database to facultyManageCourse.jsp*/
public class FacViewCourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private FacManageDao FacManageDAO;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init() {
		FacManageDAO = new FacManageDao(); 
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		     /*Get parameter from facultyHome.jsp*/                                                            		
			String value = request.getParameter("username");
			String value1 = request.getParameter("password");
			
            request.setAttribute("username", value); 
            request.setAttribute("password", value1); 
            
            /*method to get list of courses from database*/
			List<CoursesBean> listCourse = FacManageDAO.selectAllCourses(value);
			request.setAttribute("listCourses", listCourse);
			
			/*send parameter to the web page*/
			RequestDispatcher dispatcher = request.getRequestDispatcher("/facultyManageCourse.jsp");
			dispatcher.forward(request, response);
	}


}
