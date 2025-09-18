package com.stackroute.summary;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Summary {
	
	@Override
	public String toString() {
		return "Summary [summaryid=" + summaryid + ", author=" + author + ", sourceName=" + sourceName + ", count="
				+ count + "]";
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int summaryid;

	String author;
	String sourceName;
	int count;
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getSummaryid() {
		return summaryid;
	}
	public void setSummaryid(int summaryid) {
		this.summaryid = summaryid;
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
