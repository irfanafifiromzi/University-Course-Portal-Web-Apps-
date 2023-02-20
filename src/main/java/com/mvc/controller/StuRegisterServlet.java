package com.mvc.controller;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.mvc.bean.StuRegisterBean;
import com.mvc.dao.StuRegisterDao;

/*IRFAN AFIFI*/

@WebServlet("/stuRegisterServlet")
public class StuRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public StuRegisterServlet() {
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       //Copying all the input parameters in to local variables
        String firstName = request.getParameter("firstname");
        String lastName = request.getParameter("lastname");
        String email = request.getParameter("email");
        String userName = request.getParameter("username");
        String password = request.getParameter("password");
        String age = request.getParameter("age");
        String gender = request.getParameter("gender");
        
        StuRegisterBean registerBean = new StuRegisterBean();
       //Using Java Beans - An easiest way to play with group of related data
        registerBean.setFirstName(firstName);
        registerBean.setLastName(lastName);
        registerBean.setEmail(email);
        registerBean.setUserName(userName);
        registerBean.setPassword(password); 
        registerBean.setAge(age); 
        registerBean.setGender(gender); 
        
        
        StuRegisterDao registerDao = new StuRegisterDao();
        
       //The core Logic of the Registration application is present here. We are going to insert user data in to the database.
        String userRegistered = registerDao.registerUser(registerBean);
        
        if(userRegistered.equals("SUCCESS"))   //On success, you can display a message to user on Home page
        {
           request.getRequestDispatcher("/userLogin.jsp").forward(request, response);
        }
        else   //On Failure, display a meaningful message to the User.
        {
           request.setAttribute("errMessage", userRegistered);
           request.getRequestDispatcher("/stuRegister.jsp").forward(request, response);
        }
    }
}
