package com.stackroute.favourite.service;

import java.util.List;

import com.stackroute.favourite.model.Favourite;

public interface FavService {

	Favourite addFav(Favourite favobject);
	boolean deleteFav(int id);
	List<Favourite> viewByEmail(String email);
}
