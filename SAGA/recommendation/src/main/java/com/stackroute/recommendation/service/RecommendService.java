package com.stackroute.recommendation.service;

import java.util.List;

import com.stackroute.recommendation.exception.IdAlreadyExistException;
import com.stackroute.recommendation.model.Recommendation;

public interface RecommendService {
	
	Recommendation addRecom(Recommendation recobj) throws IdAlreadyExistException;
	List<Recommendation> viewAllRecommendation();
	Recommendation viewbyemail(String email);
	List<Recommendation> viewBySourceName(String soruce);
	boolean delete(long id);
   boolean processVerify(Recommendation recum);
   boolean deletebysource(String s);
}
