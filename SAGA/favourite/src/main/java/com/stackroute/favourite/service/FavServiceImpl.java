package com.stackroute.favourite.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.favourite.model.Favourite;
import com.stackroute.favourite.repo.FavRepo;

@Service
public class FavServiceImpl implements FavService{
	
@Autowired
FavRepo repo;
	 
	public Favourite addFav(Favourite favobject) {
 		return repo.save(favobject);
	}

	 
	public boolean deleteFav(int id) {
 		repo.deleteById(id);
		return true;
	}

	 
	public List<Favourite> viewByEmail(String email) {
 		return repo.findByEmailId(email);
	}

}
