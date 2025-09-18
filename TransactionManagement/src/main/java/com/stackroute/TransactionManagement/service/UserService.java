package com.stackroute.TransactionManagement.service;


import com.stackroute.TransactionManagement.model.User;
import com.stackroute.TransactionManagement.repository.UserRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Propagation;
@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void saveUser(User user) {
        userRepository.save(user);
    }
    
   //@Transactional(readOnly = true)
    public List<User> getUsers() {
   	 System.out.println("Fetching data from DB...");
   	 long start = System.currentTimeMillis();
   	 
   	 List<User> reclist= userRepository.findAll();
    		
    		  
           long end = System.currentTimeMillis();
           System.out.println("Time taken to fetch data: " + (end - start) + " ms");
           return reclist;
     }

    @Transactional(readOnly = true)
    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Transactional
    public void deleteUserByFirstName(String firstName) {
    	
        userRepository.deleteByFirstName(firstName);
        
        int count=userRepository.findAll().size();
        
        
        if(count==0)
            throw new RuntimeException("Delete Rolledback , as there is only one record");

        // 2. Simulate an exception (force rollback)
//        if (firstName.equals("Dan")) {
//            throw new RuntimeException("Simulated Transaction Rollback");
      //  }
    }
}
