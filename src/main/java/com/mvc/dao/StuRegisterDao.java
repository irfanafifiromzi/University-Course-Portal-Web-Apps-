package com.mvc.dao;
import java.sql.*;

import com.mvc.bean.StuRegisterBean;
import com.mvc.util.DBConnection;

/*IBRAHIM*/

/*CLASS TO EXECUTE QUERY TO SAVE STUDENT REGISTRATION INTO MYSQL*/
public class StuRegisterDao {
	
	/*FUNCTION TO REGISTER USER AND SAVE IN DATABASE*/
	public String registerUser(StuRegisterBean registerBean)
    {
        String firstName = registerBean.getFirstName();
        String lastName = registerBean.getLastName();
        String email = registerBean.getEmail();
        String userName = registerBean.getUserName();
        String password = registerBean.getPassword();
        String age = registerBean.getAge();
        String gender = registerBean.getGender();
               
        try
        {
            Connection con = DBConnection.createConnection();
            String query = "INSERT INTO student (student_id, first_name, last_name, email, password, course_name, course_level, faculty_name, userType,username,age,gender) VALUES ( RAND() * 100000,?,?,?,?, 'Not Register', 'Not Register', 'Not Register','student',?,?,?)"; //Insert user details into the table 'USERS'
            PreparedStatement preparedStatement = con.prepareStatement(query);  //Making use of prepared statements here to insert bunch of data
            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, lastName);
            preparedStatement.setString(3, email);
            preparedStatement.setString(4, password);
            preparedStatement.setString(5, userName);
            preparedStatement.setString(6, age);
            preparedStatement.setString(7, gender);
            
            int i= preparedStatement.executeUpdate();
            
            if (i!=0)  //Just to ensure data has been inserted into the database
            return "SUCCESS"; 
        }
        catch(SQLException e)
        {
           e.printStackTrace();
        }       
        return "Oops.. Something went wrong there..!";  // On failure, send a message from here.
    }

}
