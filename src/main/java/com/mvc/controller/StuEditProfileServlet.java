package com.mvc.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.mvc.bean.StuRegisterBean;
import com.mvc.dao.StuEditDao;

/*IRFAN AFIFI*/

/*get parameter from web page and update in mysql database (edit profile)*/
public class StuEditProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public StuEditProfileServlet() {

    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*get parameter or input from stuEditProfile.jsp*/
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String age = request.getParameter("age");
		
		/*keep the input to the bean*/
		StuRegisterBean stuRegBean = new StuRegisterBean();
		
		stuRegBean.setUserName(username);
		stuRegBean.setFirstName(firstname);
		stuRegBean.setLastName(lastname);
		stuRegBean.setAge(age);
		
		StuEditDao stueditDao = new StuEditDao(); 
		
		try {
			/*method to execute edit profile query in mysql*/
			Boolean updated = stueditDao.editProfile(stuRegBean);
			
			if(updated==true) { // if succeed, update the data to StuProfileServlet
				request.setAttribute("username", username); 
	            request.setAttribute("password", password);
	            RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/StuProfileServlet");
	            dispatcher.forward(request, response);

			}else { // if failed , student need to re-edit
				request.setAttribute("username", username); 
	            request.setAttribute("password", password);
	            request.setAttribute("errMessage", "Update failed !");
	            RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/StuEditBridgeServlet");
	            dispatcher.forward(request, response);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
