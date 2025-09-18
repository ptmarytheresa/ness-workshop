package com.stackroute.summary;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SummaryRepo extends JpaRepository<Summary,Integer>{

	Optional<Summary> findBySourceNameAndAuthor(String source,String author);
}
