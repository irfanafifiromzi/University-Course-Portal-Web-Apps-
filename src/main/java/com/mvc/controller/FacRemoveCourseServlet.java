package com.mvc.controller;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.mvc.dao.FacManageDao;

/*IRFAN AFIFI*/

/*class to remove course from database*/
public class FacRemoveCourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    private FacManageDao FacManageDAO;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init() {
		FacManageDAO = new FacManageDao(); 
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/*get parameter from facultyManageCourse.jsp*/
		String value = request.getParameter("username");
		String value1 = request.getParameter("password");
	    request.setAttribute("username", value); 
	    request.setAttribute("password", value1); 
		String courseid = request.getParameter("courseid");
		
		try {
			/*method to delete course from database*/
			FacManageDAO.deleteCourse(courseid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher("/FacViewCourseServlet");
		dispatcher.forward(request, response);

		}

	

}