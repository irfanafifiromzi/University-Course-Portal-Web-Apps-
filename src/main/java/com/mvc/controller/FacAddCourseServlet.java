package com.mvc.controller;
import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.mvc.bean.CoursesBean;
import com.mvc.dao.FacManageDao;

/*IRFAN AFIFI*/

/*class to forward the parameter from AddCourseForm.jsp to be kept in CoursesBean and send it to mysql */
public class FacAddCourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private FacManageDao FacManageDAO;  

	/*Initializing DAO to execute query*/
	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init() {
		 FacManageDAO = new FacManageDao(); 
	}
	
    public FacAddCourseServlet() {

    }

    /*post the parameter to decided web page*/
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String courseId =  request.getParameter("courseid");
			String courseName = request.getParameter("coursename");
			String facultyId = request.getParameter("facultyid");
			String courseLevel = request.getParameter("courselevel");
			String cpassword = request.getParameter("cpassword");
			//String userType = request.getParameter("usertype");
			
            /*keep the parameter in a list of courses detail*/
			CoursesBean newCourse = new CoursesBean(courseId,courseName,courseLevel,facultyId,cpassword);
			
			/*execute the list to be sent to mysql database*/
	        String courseRegistered = FacManageDAO.addCourse(newCourse);
	        
	        
	        if(courseRegistered.equals("SUCCESS"))   //On success, the courses list will updated and be viewed in view page
	        {
	        	request.setAttribute("username", username); 
	            request.setAttribute("password", password);
	           request.getRequestDispatcher("/FacViewCourseServlet").forward(request, response);
	        }
	        else   //On Failure, display a meaningful message to the User.
	        {
	        	request.setAttribute("username", username); 
	            request.setAttribute("password", password);
	           request.setAttribute("errMessage", courseRegistered);
	           request.getRequestDispatcher("/facAddCourse.jsp").forward(request, response);
	        }



	}
}
