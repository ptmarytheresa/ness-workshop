package com.stackroute.TransactionManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.TransactionManagement.model.User;
import com.stackroute.TransactionManagement.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/save")
    public ResponseEntity<String> saveUser(@RequestBody User user) {
        userService.saveUser(user);
        return ResponseEntity.ok("User saved successfully");
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        User user = userService.getUserById(id);
        return ResponseEntity.ok(user);
    }
    
    @GetMapping("/view")
    public ResponseEntity<?> getUsers() {
        List<User> userlist = userService.getUsers();
        return ResponseEntity.ok(userlist);
    }

    @DeleteMapping("/delete/{firstName}")
    public ResponseEntity<String> deleteUser(@PathVariable String firstName) {
        try {
            userService.deleteUserByFirstName(firstName);
            return ResponseEntity.ok("User deleted successfully " + firstName);
        } catch (RuntimeException e) {
            return ResponseEntity.ok("Rollback occurred: User Not Delete " + firstName);
        }
    }
}