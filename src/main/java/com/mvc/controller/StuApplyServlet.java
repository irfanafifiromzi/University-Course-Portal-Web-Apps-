package com.mvc.controller;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLDecoder;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import org.apache.commons.io.IOUtils;
import com.mvc.dao.StuApplyDao;

/*IRFAN AFIFI*/

@MultipartConfig

/*class to get the applied course details and save it to the database*/
public class StuApplyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public StuApplyServlet() {

    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/*get parameter from stuApplyCourse.jsp*/
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String coursemedium = request.getParameter("coursemedium");
		String courseName = request.getParameter("coursename");
		String originalCoursename = URLDecoder.decode(courseName, "ISO-8859-1");
		String currentlevel = request.getParameter("current");
		String currentresult = request.getParameter("cgpa");
		String applyscholar = request.getParameter("scholarship");
		
		request.setAttribute("username", username); 
        request.setAttribute("password", password);
        
        /*get pdf/files input from user and change it into byte --> save to database in Blob type*/
        Part pdfPart = request.getPart("pdfFile");
        InputStream pdfStream = pdfPart.getInputStream();
        byte[] pdfBytes = IOUtils.toByteArray(pdfStream);
        
        StuApplyDao stuApplyDao = new StuApplyDao();
        
        try {
        	/*method to get faculty name*/
        	String facultyid = stuApplyDao.getFaculty(originalCoursename);
        	
        	/*method to save the application detail in database*/
			stuApplyDao.uploadCredentials(username,originalCoursename,coursemedium,pdfBytes,currentlevel,currentresult,applyscholar,facultyid);
			
			RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/StuViewServlet");
            dispatcher.forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
