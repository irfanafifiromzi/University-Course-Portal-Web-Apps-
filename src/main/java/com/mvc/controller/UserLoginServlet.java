package com.mvc.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.mvc.bean.UserLoginBean;
import com.mvc.dao.FacManageDao;
import com.mvc.dao.UserLoginDao;

/*IRFAN AFIFI*/

public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public UserLoginServlet() // default constructor
    {
    }
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 
        //Here username and password are the names which I have given in the input box in Login.jsp page. Here I am retrieving the values entered by the user and keeping in instance variables for further use.
 
        String userName = request.getParameter("username");
        String password = request.getParameter("password");
 
        UserLoginBean loginBean = new UserLoginBean(); //creating object for LoginBean class, which is a normal java class, contains just setters and getters. Bean classes are efficiently used in java to access user information wherever required in the application.
        
        
         loginBean.setUserName(userName); //setting the username and password through the loginBean object then only you can get it in future.
         loginBean.setPassword(password);
         
        UserLoginDao loginDao = new UserLoginDao(); //creating object for LoginDao. This class contains main logic of the application.
        FacManageDao FacManageDAO = new FacManageDao();
        
        String userValidate = loginDao.authenticateUser(loginBean); //Calling authenticateUser function
 
        if(userValidate.equals("STUDENT")) //If function returns success string then user will be rooted to Home page
         {
             request.setAttribute("username", userName); //with setAttribute() you can define a "key" and value pair so that you can get it in future using getAttribute("key")
             request.setAttribute("password", password); 
             RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/stuHome.jsp");
             dispatcher.forward(request, response);

         }
        else if(userValidate.equals("FACULTY")) //If function returns success string then user will be rooted to Home page
        {
            request.setAttribute("username", userName); //with setAttribute() you can define a "key" and value pair so that you can get it in future using getAttribute("key")
            request.setAttribute("password", password);
            String facName = FacManageDAO.getFacultyName(userName);
            request.setAttribute("facName", facName);
            RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/facultyHome.jsp");
            dispatcher.forward(request, response);

        }
        else if(userValidate.equals("COURSE")) //If function returns success string then user will be rooted to Home page
        {
        	request.setAttribute("username", userName); //with setAttribute() you can define a "key" and value pair so that you can get it in future using getAttribute("key")
            request.setAttribute("password", password);
            RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/courseHome.jsp");
            dispatcher.forward(request, response);
        }
        else
        {
             request.setAttribute("errMessage", userValidate); //If authenticateUser() function returnsother than SUCCESS string it will be sent to Login page again. Here the error message returned from function has been stored in a errMessage key.
             request.getRequestDispatcher("/userLogin.jsp").forward(request, response);//forwarding the request
        }
    }

}
