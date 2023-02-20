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
import com.mvc.dao.StuViewDao;

/*IRFAN AFIFI*/

/*class to get courses detail to display in stuView.jsp*/
public class StuViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private StuViewDao StuViewDAO;

		/**
		 * @see Servlet#init(ServletConfig)
		 */
		public void init() {
			StuViewDAO = new StuViewDao(); 
		}
		
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*Get parameter*/
		String value = request.getParameter("username");
		String value1 = request.getParameter("password");
        request.setAttribute("username", value); 
        request.setAttribute("password", value1); 
        
        /*method to get list of courses by level into coursesBean*/
		List<CoursesBean> dipCourse = StuViewDAO.selectDiploma();
		List<CoursesBean> degCourse = StuViewDAO.selectDegree();
		List<CoursesBean> masCourse = StuViewDAO.selectMaster();
		List<CoursesBean> phdCourse = StuViewDAO.selectPHD();
		
		/*send the list to web page to be displayed*/
		request.setAttribute("dipCourse", dipCourse);
		request.setAttribute("degCourse", degCourse);
		request.setAttribute("masCourse", masCourse);
		request.setAttribute("phdCourse", phdCourse);
		
		/*send all parameter to below web page*/
		RequestDispatcher dispatcher = request.getRequestDispatcher("/stuView.jsp");
		dispatcher.forward(request, response);
	}

}
