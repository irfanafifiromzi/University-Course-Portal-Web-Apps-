package com.mvc.bean;

import java.sql.Blob;

/*Keep data from all application from student in this class*/
/*MUEEZ EIMAN*/

public class AppliedBean {

	private String username;
	private String coursename;
	private String medium;
	private Blob credential;
	private String current;
	private String result;
	private String scholar;
			
	/*constructor with parameter*/
	public AppliedBean(String username, String coursename, String medium, Blob credential, String current,
			String result, String scholar) {
		super();
		this.username = username;
		this.coursename = coursename;
		this.medium = medium;
		this.credential = credential;
		this.current = current;
		this.result = result;
		this.scholar = scholar;
	}
	
	
	/*Getter Setter*/
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getCoursename() {
		return coursename;
	}
	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}
	public String getMedium() {
		return medium;
	}
	public void setMedium(String medium) {
		this.medium = medium;
	}
	public Blob getCredential() {
		return credential;
	}
	public void setCredential(Blob credential) {
		this.credential = credential;
	}
	public String getCurrent() {
		return current;
	}
	public void setCurrent(String current) {
		this.current = current;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getScholar() {
		return scholar;
	}
	public void setScholar(String scholar) {
		this.scholar = scholar;
	}
	
	
	
	
}
