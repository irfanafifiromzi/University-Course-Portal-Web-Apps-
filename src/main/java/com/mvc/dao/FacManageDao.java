package com.mvc.dao;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.mvc.bean.AppliedBean;
import com.mvc.bean.CoursesBean;
import com.mvc.bean.FacultyBean;
import com.mvc.util.DBConnection;

/*IBRAHIM*/

/*class to execute mysql query to Manage faculty function*/
public class FacManageDao {
	
	private static final String ADD_COURSE_SQL = "INSERT INTO course (course_id, course_name, faculty_id, course_level, course_password, userType, subject_taught, course_duration, employment_opportunities, scope_of_further_studies, scholarship_available, fee_structure, requirements) VALUES (?,?,?,?,?,'course',?,?,?,?,?,?,?)";
	private static final String SELECT_ALL_COURSES = "select course_id,course_name,course_level,faculty_id,course_password from course where faculty_id=?";
	private static final String DELETE_COURSE_SQL = "delete from course where course_id =?";
	private static final String DELETE_APPLY = "delete from appliedCourse where stu_username = ? AND coursename = ?";
	private static final String GET_FACULTY_NAME = "select faculty_name from faculty where faculty_id = ?";
	private static final String GET_APPLIED_STUDENT = "select stu_username,coursename,coursemedium,academic_Credentials,currentlevel,currentresult,applyscholar from appliedCourse where faculty_id=?";
	private static final String APPROVE_STUDENT = "update student set course_name = ?, course_level = ?, faculty_name = ?  where username = ?";
	private static final String GET_COURSE_LEVEL = "SELECT course_level FROM course WHERE course_name = ?";
	
	Connection con = null;
	
	public FacManageDao() {
			
	}
	

	//ADD COURSE 
	public String addCourse(CoursesBean addCourses){
		System.out.println(ADD_COURSE_SQL);
		try (Connection con = DBConnection.createConnection();
			PreparedStatement preparedStatement = con.prepareStatement(ADD_COURSE_SQL)) {
			preparedStatement.setString(1, addCourses.getCourseId());
			preparedStatement.setString(2, addCourses.getCourseName());
			preparedStatement.setString(3, addCourses.getFacultyId());
			preparedStatement.setString(4, addCourses.getCourseLevel());
			preparedStatement.setString(5, addCourses.getPassword());
			preparedStatement.setString(6,"TBD");
			preparedStatement.setString(7,"TBD");
			preparedStatement.setString(8,"TBD");
			preparedStatement.setString(9,"TBD");
			preparedStatement.setString(10,"TBD");
			preparedStatement.setString(11,"TBD");
			preparedStatement.setString(12,"TBD");
			System.out.println(preparedStatement);
			int i= preparedStatement.executeUpdate();
            
            if (i!=0)  //Just to ensure data has been inserted into the database
            return "SUCCESS"; 
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return "Oops.. Something went wrong there..!";
	}

	
	
	//DELETE COURSE
	public boolean deleteCourse(String courseName) throws SQLException{
			boolean rowDeleted;
			try(Connection con = DBConnection.createConnection();//create connection
					//create statement
					PreparedStatement Statement = con.prepareStatement(DELETE_COURSE_SQL)) {
				Statement.setString(1,courseName);
				rowDeleted = Statement.executeUpdate() > 0;
				
			}
			return rowDeleted;
	}
	
	//DELETE APPLY STUDENT
	public boolean deleteApply(String stuusername,String courseName) throws SQLException{
			boolean rowDeleted;
			try(Connection con = DBConnection.createConnection();//create connection
					//create statement
					PreparedStatement Statement = con.prepareStatement(DELETE_APPLY)) {
				Statement.setString(1,stuusername);
				Statement.setString(2,courseName);
				rowDeleted = Statement.executeUpdate() > 0;
				
			}
			return rowDeleted;
	}
	
	//SELECT ALL Course - Aggregation 
	public List<CoursesBean> selectAllCourses (String username) {
		List<CoursesBean> allCourse = new ArrayList<>();
		
		try (Connection con = DBConnection.createConnection();//create connection
				//create statement
			PreparedStatement preparedStatement = con.prepareStatement(SELECT_ALL_COURSES)) {
			System.out.println(preparedStatement);
			preparedStatement.setString(1,username);
			ResultSet rs = preparedStatement.executeQuery();
			// process the ResultSet object
			while (rs.next()) {
				
				String courseId = rs.getString("course_id");
				String courseName = rs.getString("course_name");
				String courselevel = rs.getString("course_level");
				String facultyId = rs.getString("faculty_id");
				String password = rs.getString("course_password");
				allCourse.add(new CoursesBean(courseId,courseName,courselevel,facultyId,password));
			}
				
				
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return allCourse;
	}
	
	/*GET FACULTY NAME BY USING KEYWORD*/
	public String getFacultyName (String username) {
		FacultyBean facultyname = new FacultyBean();
		
		try (Connection con = DBConnection.createConnection();//create connection
				//create statement
			PreparedStatement preparedStatement = con.prepareStatement(GET_FACULTY_NAME)) {
			System.out.println(preparedStatement);
			preparedStatement.setString(1,username);
			ResultSet rs = preparedStatement.executeQuery();
			// process the ResultSet object
			while (rs.next()) {
				
				String facName = rs.getString("faculty_name");
				facultyname.setFacultyName(facName);
			}
				
				
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return facultyname.getFacultyName();
	}
	
	/*GET COURSE LEVEL BY USING KEYWORD*/
	public String getCourseLevel (String coursename) {
		CoursesBean courselevel = new CoursesBean();
		
		try (Connection con = DBConnection.createConnection();//create connection
				//create statement
			PreparedStatement preparedStatement = con.prepareStatement(GET_COURSE_LEVEL)) {
			System.out.println(preparedStatement);
			preparedStatement.setString(1,coursename);
			ResultSet rs = preparedStatement.executeQuery();
			// process the ResultSet object
			while (rs.next()) {
				
				String courseLev = rs.getString("course_level");
				courselevel.setCourseLevel(courseLev);
			}
				
				
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return courselevel.getCourseLevel();
	}
	
	
	//SELECT STUDENT WHO APPLIED COURSE
	public List<AppliedBean> appliedStudent (String username) {
		List<AppliedBean> applied = new ArrayList<>();
		
		try (Connection con = DBConnection.createConnection();//create connection
				//create statement
			PreparedStatement preparedStatement = con.prepareStatement(GET_APPLIED_STUDENT)) {
			System.out.println(preparedStatement);
			preparedStatement.setString(1,username);
			ResultSet rs = preparedStatement.executeQuery();
			// process the ResultSet object
			while (rs.next()) {
				
				String stuusername = rs.getString("stu_username");
				String courseName = rs.getString("coursename");
				String coursemedium = rs.getString("coursemedium");
				Blob credential = rs.getBlob("academic_Credentials");
				String currentlevel = rs.getString("currentlevel");
				String currentresult = rs.getString("currentresult");
				String scholar = rs.getString("applyscholar");
				applied.add(new AppliedBean(stuusername,courseName,coursemedium,credential,currentlevel,currentresult,scholar));
			}
				
				
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return applied;
	}
	
	//APPROVE STUDENT TO REGISTER COURSE
	public boolean approveStu(String coursename, String courselevel , String facultyname , String username) throws SQLException{
		
		boolean rowUpdated;
		
		try (Connection con = DBConnection.createConnection();//create connection
				//create statement
				PreparedStatement Statement = con.prepareStatement(APPROVE_STUDENT)) {
			System.out.println("Approve student:"+ Statement);
			Statement.setString(1,coursename);
			Statement.setString(2, courselevel);
			Statement.setString(3, facultyname);
			Statement.setString(4, username);

			rowUpdated = Statement.executeUpdate() > 0;	
			System.out.println("Approve student:"+ Statement);
		}
		return rowUpdated;
	}
	
	
}


