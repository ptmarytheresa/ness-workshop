package com.stackroute.favourite.repo;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.stackroute.favourite.model.Favourite;
@Repository
public interface FavRepo extends MongoRepository<Favourite,Integer>{

	List<Favourite> findByEmailId(String mailid);
}
