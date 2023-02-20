package com.mvc.bean;


/*Keep data from registration form in this class*/
/*IMRAN MIKHAIL*/

public class StuRegisterBean {
	
	 private String firstName;
	 private String lastName;
	 private String email;
	 private String userName;
	 private String password;
	 private String age;
	 private String gender;
	 
	 public StuRegisterBean() {}
	 
	 /*constructor with parameter*/
	 public StuRegisterBean(String firstName,String lastName, String email, String userName, String password, String age,String gender) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.userName = userName;
		this.password = password;
		this.age = age;
		this.gender = gender;
	 }
	 
	 
		/*Getter Setter*/
	 
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
	 public String getUserName() {
	 return userName;
	 }
	 
	 public void setUserName(String userName) {
	 this.userName = userName;
	 }
	 public String getPassword() {
	 return password;
	 }
	 public void setPassword(String password) {
	 this.password = password;
	 }
	 
	 public void setEmail(String email) {
	 this.email = email;
	 }
	 public String getEmail() {
	 return email;
	 }
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	 
	 
}
