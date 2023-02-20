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
import com.mvc.dao.CourseManageDao;

/*IRFAN AFIFI*/

/*class to forward the request/parameter from courseHome.jsp to courseEditDetails.jsp */
public class CourseViewDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    private CourseManageDao CourseManageDAO;

    /*DAO initialization in order to use method on Data Access Object (DAO)*/
	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init() {
		CourseManageDAO = new CourseManageDao(); 
	}

	/*post the attribute to decided web page*/
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/*Get parameter from courseHome.jsp*/
		String value = request.getParameter("username");
		String value1 = request.getParameter("password");
		
        request.setAttribute("username", value); 
        request.setAttribute("password", value1); 
        
        /*Method to keep a list of course details from database mysql*/
		List<CoursesBean> courseDetail = CourseManageDAO.selectAllCourses(value);
		request.setAttribute("courseDetail", courseDetail);
		
		/*Send the parameter to courseEditDetail.jsp*/
		RequestDispatcher dispatcher = request.getRequestDispatcher("/courseEditDetail.jsp");
		dispatcher.forward(request, response);


	}

}
