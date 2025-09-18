package com.stackroute.summary;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

 
@Service
public class SummaryService {

	@Autowired
	SummaryRepo repo;

	@Autowired
	Gson gson;
	
	
	@KafkaListener(topics="summarytopic",groupId="summaryness")
	public void saveSummary(String obj)
	{
		Summary dtobj=gson.fromJson(obj, Summary.class);
		
		Optional<Summary> oldobj=repo.findBySourceNameAndAuthor(dtobj.getSourceName(),dtobj.getAuthor());
		
		System.out.println("Data From Recommendation is " + dtobj);

		if (oldobj.isPresent())
		{
			int curcount=oldobj.get().getCount();
			Summary exist=oldobj.get();
			exist.setCount(curcount+1);
			repo.save(exist);
			
		System.out.println("Updated count " + exist);
		}
		else
		{
			dtobj.setCount(1);
			repo.save(dtobj);
			
			System.out.println("inserted summary " + dtobj);

		}
		
		
	}
	
}
