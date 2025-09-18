package com.stackroute.recommendation.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Recommendation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long recommendationid;
	
	String emailId;
	String author;
	String sourceName;
	boolean verified;
	public boolean isVerified() {
		return verified;
	}
	public void setVerified(boolean verified) {
		this.verified = verified;
	}
	public long getRecommendationid() {
		return recommendationid;
	}
	public void setRecommendationid(long recommendationid) {
		this.recommendationid = recommendationid;
	}
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
	public String getSourceName() {
		return sourceName;
	}
	public void setSourceName(String sourceName) {
		this.sourceName = sourceName;
	}
	
}
