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

/*All function to manage course function/interface*/
public class CourseManageDao {
	
	/*query to execute mysql*/
	private static final String VIEW_COURSE_DETAILS = "select course_name,course_level,subject_taught,course_duration,employment_opportunities,scope_of_further_studies,scholarship_available,fee_structure,requirements from course where course_id=?";
	private static final String UPDATE_COURSE_DETAILS = "update course set subject_taught = ?, course_duration = ?, employment_opportunities = ? , scope_of_further_studies = ?, scholarship_available = ?, fee_structure = ? , requirements = ? where course_name = ?";
	
	Connection con = null;
	
	public CourseManageDao() {
		
	}
	
	//SELECT COURSE DETAILS - Aggregation 
	public List<CoursesBean> selectAllCourses (String username) {
		List<CoursesBean> CourseDetails = new ArrayList<>();
		
		try (Connection con = DBConnection.createConnection();//create connection
				//create statement
			PreparedStatement preparedStatement = con.prepareStatement(VIEW_COURSE_DETAILS)) {
			System.out.println(preparedStatement);
			preparedStatement.setString(1,username);
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
			}
				
				
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return CourseDetails;
	}
	
	
	
	//Edit Course Details - update in mysql
	public boolean editCourseDetails(CoursesBean editCourse) throws SQLException{
		
		boolean rowUpdated;
		
		try (Connection con = DBConnection.createConnection();//create connection
				//create statement
				PreparedStatement Statement = con.prepareStatement(UPDATE_COURSE_DETAILS)) {
			System.out.println("Edit Course Details :"+ Statement);
			Statement.setString(1, editCourse.getSubjectTaught());
			Statement.setString(2, editCourse.getCourseDuration());
			Statement.setString(3, editCourse.getEmploymentOpportunities());
			Statement.setString(4, editCourse.getScopeFurtherStu());
			Statement.setString(5, editCourse.getScholarship());
			Statement.setString(6, editCourse.getFee());
			Statement.setString(7, editCourse.getRequirements());
			Statement.setString(8, editCourse.getCourseName());
			
			System.out.println("Edit Course Details :"+ Statement);
			rowUpdated = Statement.executeUpdate() > 0;	
			System.out.println(rowUpdated + "" + editCourse.getCourseName());
		}
		return rowUpdated;
	}
	
}
