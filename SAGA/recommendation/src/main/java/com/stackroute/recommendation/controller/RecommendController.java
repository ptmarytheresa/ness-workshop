package com.stackroute.recommendation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.stackroute.recommendation.exception.IdAlreadyExistException;
import com.stackroute.recommendation.model.FavData;
import com.stackroute.recommendation.model.Notify;
import com.stackroute.recommendation.model.Recommendation;
import com.stackroute.recommendation.model.Summary;
import com.stackroute.recommendation.service.RecommendService;

 
import java.util.List;

@RestController
@RequestMapping("/recommend")

public class RecommendController {


	@Autowired
	Gson gson;
	
	@Autowired
	KafkaTemplate<String,String> kafkatemp;

    @Autowired
    private RecommendService recommendService;
    





 	    @GetMapping("/all")
	    public  ResponseEntity<?> getAllRecommendations() {
	    	List<Recommendation> result=recommendService.viewAllRecommendation();
	        return new ResponseEntity(result,HttpStatus.OK);

	    }

 	    @GetMapping("/byemailid/{emailId}")
	    public  ResponseEntity<?> getRecommendationsByEmail(@PathVariable String emailId) {
	    	Recommendation result=recommendService.viewbyemail(emailId);
	        return new ResponseEntity(result,HttpStatus.OK);

	    }

 	    @GetMapping("/bysource/{source}")
	    public ResponseEntity<?> getRecommendationsBysource( @PathVariable String source) {
	    	List<Recommendation> result= recommendService.viewBySourceName(source);
	        
	        return new ResponseEntity(result,HttpStatus.OK);

	    }
	    
	    // delete
	    @DeleteMapping("/delete/{id}")
	    public ResponseEntity<?> deleterecommend( @PathVariable long id) {
	    	
	         recommendService.delete(id);
	         
	         
	         return new ResponseEntity("deleted",HttpStatus.OK);
	    }
	    
	    @GetMapping("/notify/{source}")
	    public ResponseEntity<?> sendNotification( @PathVariable String source) {
	    	List<Recommendation> result= recommendService.viewBySourceName(source);
	        
	    	kafkatemp.send("notifytopic","start");
	        return new ResponseEntity("Updated Notification",HttpStatus.OK);

	    }
	    
	    @DeleteMapping("/deleteBySource/{source}")
	    public ResponseEntity<?> deletesource( @PathVariable String source) {
	    	
//	    	kafkatemp.send("notifytopic",source);
 	        
	        try {
	        	boolean resultt= recommendService.deletebysource(source);
	        	
	        // update summary microserive and reduce the count
	        	kafkatemp.send("notifytopic",source+"removed");
		        
	            return ResponseEntity.ok("User deleted successfully " );
	        } catch (RuntimeException e) {
	        	System.out.println(e.getMessage());
	            return ResponseEntity.ok("Rollback occurred: source Not Delete " );
	        }

	    }

	    

	}
	
 