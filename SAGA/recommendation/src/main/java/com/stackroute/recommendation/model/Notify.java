package com.stackroute.recommendation.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Notify {
	@Id
	int id;
	String sourceName;
	String author;
	public String getSourceName() {
		return sourceName;
	}
	public void setSourceName(String sourceName) {
		this.sourceName = sourceName;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
}
