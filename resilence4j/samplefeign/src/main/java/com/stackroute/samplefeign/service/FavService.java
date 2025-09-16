package com.stackroute.samplefeign.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.stackroute.samplefeign.model.Article;
import com.stackroute.samplefeign.model.Favourite;

//@FeignClient(name = "viewService", url = "http://localhost:9111/favourite")


@FeignClient("favourite")
public interface FavService {
	
	@RequestMapping(method=RequestMethod.GET,value="/favourite/view/{email}",consumes="application/json")
	
	public List<Favourite> viewFavorite(@PathVariable("email") String email);

}
