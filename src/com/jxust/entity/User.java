package com.jxust.entity;

/**
 * @author shymain
 *
 */
public class User {
	
	
    private int userid;
    
    
    private String username;
    
     
    
    private String userpassword;
    
     
    private int age;
    


    private  String sex;
    
    private String email;
    
     
    private int type;
    
    
    private String remark;
      
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUserpassword() {
		return userpassword;
	}
	public void setUserpassword(String userpassword) {
		this.userpassword = userpassword;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}

	
	@Override
	public String toString() {
		return "User [userid=" + userid + ", username=" + username
				+ ", userpassword=" + userpassword + ", age=" + age + ", sex="
				+ sex + ", email=" + email + ", type=" + type + ", remark="
				+ remark + "]";
	}
      
      
  
}
