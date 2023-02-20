package com.mvc.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.mvc.bean.StuRegisterBean;
import com.mvc.util.DBConnection;

/*IBRAHIM*/

/*CLASS TO EXECUTE QUERY TO EDIT STUDENT PROFILE/DATA IN MYSQL*/
public class StuEditDao {

	private static final String EDIT_PROFILE = "update student set first_name = ? ,last_name = ? , age = ? where username = ?;";

	Connection con = null;
	
	public StuEditDao() {
		
	}
	
	/*EDIT STUDENT PROFILE FUNCTION*/
	public boolean editProfile(StuRegisterBean editprofile) throws SQLException{
		
		boolean rowUpdated;
		
		try (Connection con = DBConnection.createConnection();//create connection
				//create statement
				PreparedStatement Statement = con.prepareStatement(EDIT_PROFILE)) {
			System.out.println("Edit Profile : "+ Statement);
			Statement.setString(1, editprofile.getFirstName());
			Statement.setString(2, editprofile.getLastName());
			Statement.setString(3, editprofile.getAge());
			Statement.setString(4, editprofile.getUserName());

			System.out.println("Edit Profile : "+ Statement);
			rowUpdated = Statement.executeUpdate() > 0;	
			System.out.println(rowUpdated + "" + editprofile.getUserName());
		}
		return rowUpdated;
	}
}
