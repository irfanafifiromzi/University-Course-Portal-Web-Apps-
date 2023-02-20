package com.mvc.bean;

/*Keep data from all Courses in this class*/
/*MUEEZ EIMAN*/

public class CoursesBean {
	//encapsulation
	private String courseId;
	private String courseName;
	private String courseLevel;
	private String facultyId;
	private String password;
	private String userType;
	private String subjectTaught;
	private String courseDuration;
	private String employmentOpportunities;
	private String scopeFurtherStu;
	private String scholarship;
	private String fee;
	private String requirements;
	

	public CoursesBean() {

	}
	
	public CoursesBean(String courseId, String courseName, String courseLevel, String facultyId, String password) {
		this.courseId = courseId;
		this.courseName = courseName;
		this.courseLevel = courseLevel;
		this.facultyId = facultyId;
		this.password = password;
	}

	/*constructor with parameter*/
	public CoursesBean(String courseName, String courseLevel, String subjectTaught, String courseDuration, String employmentOpportunities , String scopeFurtherStu , String scholarship , String fee, String requirements) {
		this.courseName = courseName;
		this.courseLevel = courseLevel;
		this.subjectTaught = subjectTaught;
		this.courseDuration = courseDuration;
		this.employmentOpportunities = employmentOpportunities;
		this.scopeFurtherStu = scopeFurtherStu;
		this.scholarship = scholarship;
		this.fee = fee;
		this.requirements = requirements;

	}
	
	
	/*Getter Setter*/
	
	public String getSubjectTaught() {
		return subjectTaught;
	}
	public void setSubjectTaught(String subjectTaught) {
		this.subjectTaught = subjectTaught;
	}
	public String getCourseDuration() {
		return courseDuration;
	}
	public void setCourseDuration(String courseDuration) {
		this.courseDuration = courseDuration;
	}
	public String getEmploymentOpportunities() {
		return employmentOpportunities;
	}
	public void setEmploymentOpportunities(String employmentOpportunities) {
		this.employmentOpportunities = employmentOpportunities;
	}
	public String getScopeFurtherStu() {
		return scopeFurtherStu;
	}
	public void setScopeFurtherStu(String scopeFurtherStu) {
		this.scopeFurtherStu = scopeFurtherStu;
	}
	public String getScholarship() {
		return scholarship;
	}
	public void setScholarship(String scholarship) {
		this.scholarship = scholarship;
	}
	public String getFee() {
		return fee;
	}
	public void setFee(String fee) {
		this.fee = fee;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public String getCourseId() {
		return courseId;
	}
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getCourseLevel() {
		return courseLevel;
	}
	public void setCourseLevel(String courseLevel) {
		this.courseLevel = courseLevel;
	}
	public String getFacultyId() {
		return facultyId;
	}
	public void setFacultyId(String facultyId) {
		this.facultyId = facultyId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String getRequirements() {
		return requirements;
	}

	public void setRequirements(String requirements) {
		this.requirements = requirements;
	}
		



}
