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
import com.mvc.bean.StudentBean;
import com.mvc.dao.StuProfileDao;

/*IRFAN AFIFI*/

public class StuProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private StuProfileDao StuProfileDAO;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init() {
		StuProfileDAO = new StuProfileDao(); 
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		                                                                 		
			String value = request.getParameter("username");
			String value1 = request.getParameter("password");
            request.setAttribute("username", value);  
            request.setAttribute("password", value1);
			List<StudentBean> student = StuProfileDAO.studentProfile(value);
			request.setAttribute("student", student);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/stuProfile.jsp");
			dispatcher.forward(request, response);
	}

}
