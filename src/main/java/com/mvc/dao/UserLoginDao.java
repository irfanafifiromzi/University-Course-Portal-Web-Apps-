package com.mvc.dao;
 
import java.sql.*;
import com.mvc.bean.UserLoginBean;
import com.mvc.util.DBConnection;
 
/*IBRAHIM*/

/*GET USERS DATA AND AUTHENTICATE WHETHER SAME TO DATABASE OR NOT*/
/*CLASS TO LOGIN USER*/
public class UserLoginDao {
     public String authenticateUser(UserLoginBean loginBean)
     {
         String userName = loginBean.getUserName(); //Assign user entered values to temporary variables.
         String password = loginBean.getPassword();
 
         Connection con = null;
         Statement statement = null;
         ResultSet resultSet = null;
 
         String userNameDB = "";
         String passwordDB = "";
         String userTypeDB = "";
        
         try
         {
             con = DBConnection.createConnection(); //Fetch database connection object
             statement = con.createStatement(); //Statement is used to write queries. Read more about it.
             resultSet = statement.executeQuery("SELECT s.username as username, s.password as password ,s.userType as userType FROM student s UNION SELECT c.course_id as username, c.course_password as password ,c.userType as userType FROM course c UNION SELECT f.faculty_id as username, f.faculty_password as password ,f.userType as userType FROM faculty f"); 
            	
            		 
             while(resultSet.next()) // Until next row is present otherwise it return false
             {
              userNameDB = resultSet.getString("username"); //fetch the values present in database
              passwordDB = resultSet.getString("password");
              userTypeDB = resultSet.getString("userType");
              
              if(userName.equals(userNameDB) && password.equals(passwordDB) && userTypeDB.equals("student"))
               {
            	  return "STUDENT"; 
               }else if(userName.equals(userNameDB) && password.equals(passwordDB) && userTypeDB.equals("faculty"))
               {
         		  return "FACULTY"; 
               }else if(userName.equals(userNameDB) && password.equals(passwordDB) && userTypeDB.equals("course"))
               {
         		  return "COURSE"; 
               }
             }
          }catch(SQLException e) {
             
                e.printStackTrace();
          }
             return "Invalid user"; // Return appropriate message in case of failure
         }
     }