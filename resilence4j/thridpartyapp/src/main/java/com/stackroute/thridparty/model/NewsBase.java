package com.stackroute.thridparty.model;

import java.util.List;

public class NewsBase {
int totalResults;
List<Article> articles;
public int getTotalResults() {
	return totalResults;
}
public void setTotalResults(int totalResults) {
	this.totalResults = totalResults;
}
public List<Article> getArticles() {
	return articles;
}
public void setArticles(List<Article> articles) {
	this.articles = articles;
}



}
