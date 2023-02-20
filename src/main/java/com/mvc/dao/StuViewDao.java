package com.mvc.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mvc.bean.CoursesBean;
import com.mvc.util.DBConnection;

/*IBRAHIM*/

/*CLASS TO GET ALL COURSES DATA FROM MYSQL AND DISPLAY TO STUDENT*/
public class StuViewDao {
	
	private static final String STU_VIEW_COURSE = "select course_name,course_level,subject_taught,course_duration,employment_opportunities,scope_of_further_studies,scholarship_available,fee_structure,requirements from course";
	private static final String VIEW_COURSE_DIP = "select course_name,course_level,subject_taught,course_duration,employment_opportunities,scope_of_further_studies,scholarship_available,fee_structure,requirements from course where course_level = 'Diploma'";
	private static final String VIEW_COURSE_DEG = "select course_name,course_level,subject_taught,course_duration,employment_opportunities,scope_of_further_studies,scholarship_available,fee_structure,requirements from course where course_level = 'Degree'";
	private static final String VIEW_COURSE_MAS = "select course_name,course_level,subject_taught,course_duration,employment_opportunities,scope_of_further_studies,scholarship_available,fee_structure,requirements from course where course_level = 'Master'";
	private static final String VIEW_COURSE_PHD = "select course_name,course_level,subject_taught,course_duration,employment_opportunities,scope_of_further_studies,scholarship_available,fee_structure,requirements from course where course_level = 'PHD'";
	
	Connection con = null;
	
	public StuViewDao() {
		
	}
	
	//SELECT COURSE DETAILS - Aggregation 
	public List<CoursesBean> selectAllCourses () {
		List<CoursesBean> CourseDetails = new ArrayList<>();
		
		try (Connection con = DBConnection.createConnection();//create connection
				//create statement
			PreparedStatement preparedStatement = con.prepareStatement(STU_VIEW_COURSE)) {
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();
			// process the ResultSet object
			while (rs.next()) {
				
				String courseName = rs.getString("course_name");
				String courselevel = rs.getString("course_level");
				String subject = rs.getString("subject_taught");
				String duration = rs.getString("course_duration");
				String employment = rs.getString("employment_opportunities");
				String further = rs.getString("scope_of_further_studies");
				String scholarship = rs.getString("scholarship_available");
				String fee = rs.getString("fee_structure");
				String requirements = rs.getString("requirements");
				CourseDetails.add(new CoursesBean(courseName,courselevel,subject,duration,employment,further,scholarship,fee,requirements));
				System.out.println(CourseDetails);
			}
				
				
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return CourseDetails;
	}
	
	//SELECT DIPLOMA COURSE DETAILS - Aggregation 
	public List<CoursesBean> selectDiploma () {
		List<CoursesBean> CourseDetails = new ArrayList<>();
		
		try (Connection con = DBConnection.createConnection();//create connection
				//create statement
			PreparedStatement preparedStatement = con.prepareStatement(VIEW_COURSE_DIP)) {
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();
			// process the ResultSet object
			while (rs.next()) {
				
				String courseName = rs.getString("course_name");
				String courselevel = rs.getString("course_level");
				String subject = rs.getString("subject_taught");
				String duration = rs.getString("course_duration");
				String employment = rs.getString("employment_opportunities");
				String further = rs.getString("scope_of_further_studies");
				String scholarship = rs.getString("scholarship_available");
				String fee = rs.getString("fee_structure");
				String requirements = rs.getString("requirements");
				CourseDetails.add(new CoursesBean(courseName,courselevel,subject,duration,employment,further,scholarship,fee,requirements));
				System.out.println(CourseDetails);
			}
				
				
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return CourseDetails;
	}
	
	
	//SELECT DEGREEE COURSE DETAILS - Aggregation 
	public List<CoursesBean> selectDegree () {
		List<CoursesBean> CourseDetails = new ArrayList<>();
		
		try (Connection con = DBConnection.createConnection();//create connection
				//create statement
			PreparedStatement preparedStatement = con.prepareStatement(VIEW_COURSE_DEG)) {
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();
			// process the ResultSet object
			while (rs.next()) {
				
				String courseName = rs.getString("course_name");
				String courselevel = rs.getString("course_level");
				String subject = rs.getString("subject_taught");
				String duration = rs.getString("course_duration");
				String employment = rs.getString("employment_opportunities");
				String further = rs.getString("scope_of_further_studies");
				String scholarship = rs.getString("scholarship_available");
				String fee = rs.getString("fee_structure");
				String requirements = rs.getString("requirements");
				CourseDetails.add(new CoursesBean(courseName,courselevel,subject,duration,employment,further,scholarship,fee,requirements));
				System.out.println(CourseDetails);
			}
				
				
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return CourseDetails;
	}
	
	
	//SELECT MASTER COURSE DETAILS - Aggregation 
	public List<CoursesBean> selectMaster () {
		List<CoursesBean> CourseDetails = new ArrayList<>();
		
		try (Connection con = DBConnection.createConnection();//create connection
				//create statement
			PreparedStatement preparedStatement = con.prepareStatement(VIEW_COURSE_MAS)) {
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();
			// process the ResultSet object
			while (rs.next()) {
				
				String courseName = rs.getString("course_name");
				String courselevel = rs.getString("course_level");
				String subject = rs.getString("subject_taught");
				String duration = rs.getString("course_duration");
				String employment = rs.getString("employment_opportunities");
				String further = rs.getString("scope_of_further_studies");
				String scholarship = rs.getString("scholarship_available");
				String fee = rs.getString("fee_structure");
				String requirements = rs.getString("requirements");
				CourseDetails.add(new CoursesBean(courseName,courselevel,subject,duration,employment,further,scholarship,fee,requirements));
				System.out.println(CourseDetails);
			}
				
				
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return CourseDetails;
	}
	
	
	//SELECT PHD COURSE DETAILS - Aggregation 
	public List<CoursesBean> selectPHD () {
		List<CoursesBean> CourseDetails = new ArrayList<>();
		
		try (Connection con = DBConnection.createConnection();//create connection
				//create statement
			PreparedStatement preparedStatement = con.prepareStatement(VIEW_COURSE_PHD)) {
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();
			// process the ResultSet object
			while (rs.next()) {
				
				String courseName = rs.getString("course_name");
				String courselevel = rs.getString("course_level");
				String subject = rs.getString("subject_taught");
				String duration = rs.getString("course_duration");
				String employment = rs.getString("employment_opportunities");
				String further = rs.getString("scope_of_further_studies");
				String scholarship = rs.getString("scholarship_available");
				String fee = rs.getString("fee_structure");
				String requirements = rs.getString("requirements");
				CourseDetails.add(new CoursesBean(courseName,courselevel,subject,duration,employment,further,scholarship,fee,requirements));
				System.out.println(CourseDetails);
			}
				
				
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return CourseDetails;
	}
	
	
	
	
}
