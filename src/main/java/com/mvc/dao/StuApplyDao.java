package com.mvc.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mvc.bean.FacultyBean;
import com.mvc.util.DBConnection;

/*IBRAHIM*/

/*CLASS TO EXECUTE QUERY TO MANAGE STUDENT APPLICATION (COURSE APPLICATION)*/
public class StuApplyDao {
	private static final String UPLOAD_CREDENTIALS = "INSERT INTO appliedCourse (stu_username, coursename ,coursemedium, academic_Credentials,currentlevel,currentresult,applyscholar,faculty_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String GET_FACULTY = "SELECT faculty_id from course where course_name = ?";
	
	Connection con = null;
	
	public StuApplyDao() {
		
	}
	
	/*UPLOAD STUDENT ACADEMIC CREDENTIALS TO MYSQL*/
	public void uploadCredentials(String username,String coursename ,String medium ,byte[] pdfFile, String current, String cgpa, String scholar, String facultyid) throws SQLException{
		
		
		try (Connection con = DBConnection.createConnection();//create connection
				//create statement
			PreparedStatement Statement = con.prepareStatement(UPLOAD_CREDENTIALS)) {
			System.out.println("Upload Academic Credentials :"+ Statement);
			Statement.setString(1,username);
			Statement.setString(2,coursename);
			Statement.setString(3,medium);
			Statement.setBytes(4,pdfFile);
			Statement.setString(5,current);
			Statement.setString(6,cgpa);
			Statement.setString(7,scholar);
			Statement.setString(8,facultyid);

			System.out.println("Upload Academic Credentials :"+ Statement);
			Statement.executeUpdate();	

		}

	}
	
	/*GET FACULTY NAME*/
	public String getFaculty(String coursename) throws SQLException{
		
		FacultyBean facultyBean = new FacultyBean();
	
		try (Connection con = DBConnection.createConnection();//create connection
				//create statement
			PreparedStatement Statement = con.prepareStatement(GET_FACULTY)) {
			System.out.println("Get faculty name : "+ Statement);
			Statement.setString(1,coursename);
			ResultSet rs = Statement.executeQuery();
			
			
			while (rs.next()) {
				String facultyid = rs.getString("faculty_id");
				facultyBean.setFacultyid(facultyid);
				
			}
			

		}

		return facultyBean.getFacultyid();
	}
	
	
	
}
