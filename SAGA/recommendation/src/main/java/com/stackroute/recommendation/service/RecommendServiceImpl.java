package com.stackroute.recommendation.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import org.springframework.cache.annotation.*;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.stackroute.recommendation.exception.IdAlreadyExistException;
import com.stackroute.recommendation.model.FavData;
import com.stackroute.recommendation.model.Notify;
import com.stackroute.recommendation.model.Recommendation;
import com.stackroute.recommendation.model.RollbackEvent;
import com.stackroute.recommendation.model.Summary;
import com.stackroute.recommendation.repo.NotificationRepo;
import com.stackroute.recommendation.repo.RecomRepo;

import jakarta.transaction.Transactional;
@CacheConfig(cacheNames="mycache")

@Service
public class RecommendServiceImpl implements RecommendService{

	
	@Autowired
	RecomRepo repo;
	
	@Autowired
	NotificationRepo repo1;
	
	@Autowired
	Gson gson;
	
	@Autowired
	KafkaTemplate<String,String> kafkatemp;
	
	
	@Caching( evict = {
	@CacheEvict(value="allrecommend",allEntries=true),
	@CacheEvict(value="recommendcache",key="#recommendation.recommendationid")
})
	@Override
	@Transactional
	public Recommendation addRecom(Recommendation recobj) throws IdAlreadyExistException {
		
		Recommendation recommend=repo.findByEmailId(recobj.getEmailId());
		
		if (recommend!=null)
		{
			
			
			throw new IdAlreadyExistException();
		
		}
 		return repo.save(recobj);
	}

 @Cacheable(value="allrecommend")

 
	
	public List<Recommendation> viewAllRecommendation() {
	 System.out.println("Fetching data from DB...");
	 long start = System.currentTimeMillis();
	 List<Recommendation> reclist= repo.findAll();
 		
 		  
        long end = System.currentTimeMillis();
        System.out.println("Time taken to fetch data: " + (end - start) + " ms");
        return reclist;
	}

 @Cacheable(value="allrecommendmail",key="#emailId")

	@Override
	public Recommendation viewbyemail(String email) {
		// TODO Auto-generated method stub
		return repo.findByEmailId(email);
	}

	@Override
	public List<Recommendation>  viewBySourceName(String source) {
		// TODO Auto-generated method stub
		return repo.findBySourceName(source);
	}

	@Override
	public boolean processVerify(Recommendation recum) {
 		return false;
	}

	
	@Caching( evict = {
			@CacheEvict(value="allrecommend",allEntries=true),
			@CacheEvict(value="recommendcache",key="#recommendationid")
	})
	@Override
	public boolean delete(long id) {
repo.deleteById(id);
return false;
	}

	
	@Caching( evict = {
			@CacheEvict(value="allrecommend",allEntries=true),
			@CacheEvict(value="recommendcache",key="#recommendationid")
	})
	@Transactional
	public boolean deletebysource(String s) {
//       Notify obj=repo1.findyBySourceName(s);
	
		 long deletedCount = repo.deleteBySourceName(s);

	        int count = repo.findAll().size();

	        if (count == 0) {
	            
	            throw new RuntimeException("Delete Rolledback, as there is only one record");
	        }

	        return deletedCount > 0;
	}
	
	
	//@CachePut(value="allrecommend",key="#passenger.passengerId")

	
	@KafkaListener(topics="recomtopic",groupId="nesssep")
	public void datafromProducer(String result)
	{
	    Recommendation recobj=new Recommendation();

	    Recommendation dtobj=gson.fromJson(result, Recommendation.class);
		System.out.println("Data From Favour is " + dtobj);
		
		
		recobj.setAuthor(dtobj.getAuthor());
		recobj.setEmailId(dtobj.getEmailId());
		recobj.setSourceName(dtobj.getSourceName());
		
		recobj.setVerified(false);

	
		
        try {
			Recommendation result1=  addRecom(recobj);
	
			
			
			Summary summaryobj=new Summary();
			summaryobj.setAuthor(dtobj.getAuthor());
			summaryobj.setSourceName(dtobj.getSourceName());
			
	kafkatemp.send("summarytopic", gson.toJson(summaryobj)); // summmary microservice
System.out.println("Recommendation added " + result1);
System.out.println("Summary sent to " + summaryobj);

 		} catch (IdAlreadyExistException e) {
 			 
 			RollbackEvent rollobj=new RollbackEvent();
 			rollobj.setEmailId(dtobj.getEmailId());
 			rollobj.setAuthor(dtobj.getAuthor());
  			rollobj.setReason("This user Already Recommended a product " );
 			
 			
 			kafkatemp.send("rollbacktopic",gson.toJson(rollobj)); // favourite microservice
			 
		}

		
		

	}
	
	
}




//
//Notify notify=new Notify();
//notify.setAuthor(dtobj.getAuthor());
//notify.setSourceName(dtobj.getSourceName());
