package com.mvc.controller;
import java.io.IOException;
import java.net.URLDecoder;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.mvc.bean.CoursesBean;
import com.mvc.dao.CourseManageDao;

/*IRFAN AFIFI*/

/*class to forward the parameter from editCourseForm.jsp to be kept in CoursesBean and send it to mysql */
public class CourseEditDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public CourseEditDetailsServlet() {

    }

    /*post the attribute to decided web page*/
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/*Get parameter from editCourseForm.jsp*/
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String courseName = request.getParameter("coursename");
		String originalCoursename = URLDecoder.decode(courseName, "ISO-8859-1");
		String subject = request.getParameter("subject");
		String duration = request.getParameter("duration");
		String employment = request.getParameter("employment");
		String scope = request.getParameter("scope");
		String scholarship = request.getParameter("scholarship");
		String fee = request.getParameter("fee");
		String requirements = request.getParameter("requirements");
		
		/*Keep parameter into Bean (Model)*/
		CoursesBean courseBean = new CoursesBean(); 
		 
        courseBean.setCourseName(originalCoursename); 
        courseBean.setSubjectTaught(subject);
        courseBean.setCourseDuration(duration);
        courseBean.setEmploymentOpportunities(employment);
        courseBean.setScopeFurtherStu(scope);
        courseBean.setScholarship(scholarship);
        courseBean.setFee(fee);
        courseBean.setRequirements(requirements);
        
        /*execute mysql query*/
       CourseManageDao courseDao = new CourseManageDao(); 

       try {
    	   
    	   /*function to execute mysql query*/
		Boolean updated = courseDao.editCourseDetails(courseBean);
		if(updated==true) {
			/*return to original web page (updated data in mysql)*/
			request.setAttribute("username", username); 
            request.setAttribute("password", password);
            request.setAttribute("coursename", courseName);
            RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/CourseViewDetailsServlet");
            dispatcher.forward(request, response);

		}else {
			request.setAttribute("username", username); 
            request.setAttribute("password", password);
            request.setAttribute("coursename", courseName);
            request.setAttribute("errMessage", "Update failed !");
            RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/EditCourseBridgeServlet");
            dispatcher.forward(request, response);
		}
       } catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

}
