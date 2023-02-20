package com.mvc.bean;

/*Keep data from all Student in this class*/
/*IMRAN MIKHAIL*/

public class StudentBean {
	
	 private String id;
	 private String firstName;
	 private String lastName;
	 private String age;
	 private String facultyName;
	 private String courseName;
	 private String courseLevel;
	 private String gender;
	 
	 
	 
	 /*constructor with parameter*/
	public StudentBean(String id, String firstName, String lastName, String age, String facultyName, String courseName,String courseLevel,String gender) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.facultyName = facultyName;
		this.courseName = courseName;
		this.courseLevel = courseLevel;
		this.gender = gender;
	}
	
	/*Getter Setter*/
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getFacultyName() {
		return facultyName;
	}
	public void setFacultyName(String facultyName) {
		this.facultyName = facultyName;
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	 
	 

}
