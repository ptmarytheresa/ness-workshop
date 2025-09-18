package com.stackroute.recommendation.model;

import java.time.LocalDate;

public class RollbackEvent {
	
	String emailId;
	String author;
	String reason;
//	LocalDate day;
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
//	public LocalDate getDay() {
//		return day;
//	}
//	public void setDay(LocalDate day) {
//		this.day = day;
//	}
	
	
}
