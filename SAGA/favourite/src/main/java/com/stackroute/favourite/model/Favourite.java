package com.stackroute.favourite.model;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
 
@Document
public class Favourite {
	@Id
	int favid;
	public int getFavid() {
		return favid;
	}
	public void setFavid(int favid) {
		this.favid = favid;
	}
	String emailId;
	
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
	 News favnews;
	public News getFavnews() {
		return favnews;
	}
	public void setFavnews(News favnews) {
		this.favnews = favnews;
	}
	
	
	 

}
