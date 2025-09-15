package com.stackroute.thridparty.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.stackroute.thridparty.model.NewsBase;

@Service
public class NewsService {
	
	public NewsBase getNews()
	{
		RestTemplate resttemp=new RestTemplate();
		
		String url="https://newsapi.org/v2/top-headlines?country=us&apiKey=7f118af83e1b48f6939fc5096e89fd22";
	NewsBase newsresult=	resttemp.getForObject(url, NewsBase.class);
	return newsresult;
	}

}
