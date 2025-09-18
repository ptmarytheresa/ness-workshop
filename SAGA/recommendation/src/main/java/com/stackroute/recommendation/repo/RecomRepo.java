package com.stackroute.recommendation.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stackroute.recommendation.model.Recommendation;

import jakarta.transaction.Transactional;

@Repository
public interface RecomRepo extends JpaRepository<Recommendation,Long>{

	
	 Recommendation findByEmailId(String email);
	
	List<Recommendation> findBySourceName(String source);
	
	List<Recommendation> findBySourceNameAndAuthor(String source,String author);
	
	@Transactional
	 long deleteBySourceName(String sourceName);
}
