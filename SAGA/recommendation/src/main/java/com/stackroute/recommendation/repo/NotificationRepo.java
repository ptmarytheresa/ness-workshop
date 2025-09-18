package com.stackroute.recommendation.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stackroute.recommendation.model.Notify;

@Repository
public interface NotificationRepo extends JpaRepository<Notify,Integer> 
{
//  Notify findyBySourceName(String n);
}
