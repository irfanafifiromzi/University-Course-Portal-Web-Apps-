package com.mvc.bean;

/*Keep data from all user in this class*/
/*IMRAN MIKHAIL*/
public class UserLoginBean {
	
    private String userName;
    private String password;
    private String userType;

    
	/*Getter Setter*/
   public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
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
}
