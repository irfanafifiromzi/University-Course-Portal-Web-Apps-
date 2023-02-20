package com.mvc.bean;

/*Keep data from Faculty in this class*/
/*MUEEZ EIMAN*/

public class FacultyBean {

	
	private String facultyName;
	private String facultyid;
	
	
	
	public FacultyBean() {
	}

	/*constructor with parameter*/
	public FacultyBean(String facultyName) {
		this.facultyName = facultyName;
	}


	/*Getter Setter*/
	
	public String getFacultyName() {
		return facultyName;
	}

	public void setFacultyName(String facultyName) {
		this.facultyName = facultyName;
	}


	public String getFacultyid() {
		return facultyid;
	}


	public void setFacultyid(String facultyid) {
		this.facultyid = facultyid;
	}
	
	
	
	
}
