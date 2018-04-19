package com.niit.shoppingcart.domain;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.stereotype.Component;

@Component
@Entity                          //specify it is not normal class-it is database entity
@Table(name="user")             //to specify to which database table we need to map this class
public class User {
	
	@Id
	private String emailID;
	private String name;
	@Column(name="password")
	private String pwd;
	private String mobile;
	private Character role;
	private String registeredDate;
	                           
	                               //getter setter for emailid
	public String getEmailID() { 
		return emailID;
	}
	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}
	                              //getter setter for Name
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	                              //getter setter for pwd(password)
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	                           //getter setter for mobile
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	                          // getter setter for role
	public Character getRole() {
		return role;
	}
	public void setRole(Character role) {
		
		this.role = 'C';
	}
	                         //getter setter for Registered date
	public String getRegisteredDate() {
		return registeredDate;
	}
	public void setRegisteredDate(String registeredDate) {
		this.registeredDate = registeredDate;
	}
	
}