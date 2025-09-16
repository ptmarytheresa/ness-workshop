package com.stackroute.samplefeign.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.stackroute.samplefeign.model.Article;

@FeignClient("thridpartyapp")

public interface NewsService {

	@RequestMapping(method=RequestMethod.GET,value="/news/viewnews",consumes="application/json")
	public List<Article> getAllNews();
	
	
	
}
