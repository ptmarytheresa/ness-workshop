package com.stackroute.userservice.entity;

import java.time.LocalDate;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.stackroute.userservice.config.Country;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;

@Entity
public class UserProfile {
	
	@Id
	int userid;
	String emailId;
	String addr;
	 
	String phone;
	String password;
	
	@Pattern(regexp="(yes|no)",message="Active can be either yes or no")
	String active;
	
	
	@Min(1)
	int age;
	
   @NotEmpty(message="Date of jounery can not be null")
	@JsonDeserialize
	LocalDate dateofbirth;
	
 @Country(message="Country should be either india or bldesh")
	String country;
	
 
 
   	
   	
	public String getCountry() {
	return country;
}
public void setCountry(String country) {
	this.country = country;
}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public LocalDate getDateofbirth() {
		return dateofbirth;
	}
	public void setDateofbirth(LocalDate dateofbirth) {
		this.dateofbirth = dateofbirth;
	}
	public String getActive() {
		return active;
	}
	public void setActive(String active) {
		this.active = active;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "UserProfile [userid=" + userid + ", emailId=" + emailId + ", addr=" + addr + ", phone=" + phone
				+ ", password=" + password + ", active=" + active + "]";
	}
	
	

}
