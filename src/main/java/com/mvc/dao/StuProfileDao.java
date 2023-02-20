package com.mvc.dao;
 
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.mvc.bean.StudentBean;
import com.mvc.util.DBConnection;


/*IBRAHIM*/

/*Class to execute mysql query to get student profile data */
public class StuProfileDao {

	private static final String SELECT_STUDENT = "select student_id,first_name,last_name,gender,age,course_name,course_level,faculty_name from student where username=?";
	
	Connection con = null;
	
	public StuProfileDao() {
		
	}
	
	/*FUNCTION TO EXECUTE QUERY AND SAVE THE DATA INTO LIST*/
	/*GET STUDENT PROFILE*/
	public List<StudentBean> studentProfile (String username) {
		List<StudentBean> student = new ArrayList<>();
		
		try (Connection con = DBConnection.createConnection();//create connection
				//create statement
			PreparedStatement preparedStatement = con.prepareStatement(SELECT_STUDENT)) {
			System.out.println(preparedStatement);
			preparedStatement.setString(1,username);
			ResultSet rs = preparedStatement.executeQuery();
			// process the ResultSet object
			while (rs.next()) {
				String id = rs.getString("student_id");
				String firstname = rs.getString("first_name");
				String lastname = rs.getString("last_name");
				String gender = rs.getString("gender");
				String age = rs.getString("age");
				String faculty = rs.getString("faculty_name");
				String course = rs.getString("course_name");
				String level = rs.getString("course_level");
				student.add(new StudentBean(id,firstname,lastname,age,faculty,course,level,gender));
			}
				
				
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return student;
	}
}
