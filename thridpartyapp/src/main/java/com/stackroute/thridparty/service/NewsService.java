package com.stackroute.thridparty.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.stackroute.thridparty.model.NewsBase;

@Service
public class NewsService {
	
	public NewsBase getNews()
	{
		RestTemplate resttemp=new RestTemplate();
		
//generate api key using https://newsapi.org
		String url="https://newsapi.org/v2/top-headlines?country=us&apiKey=yourapikey";
	NewsBase newsresult=	resttemp.getForObject(url, NewsBase.class);
	return newsresult;
	}

}
