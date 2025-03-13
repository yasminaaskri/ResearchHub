package com.esgitech.randd.controller;

import com.esgitech.randd.entities.User;
import com.esgitech.randd.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private  UserService userService;

    @PostMapping("/addUser")
    public User createUser(@RequestBody User user) {
        User unuser= new User();

        unuser.setFirstName(user.getFirstName());
        unuser.setLastName(user.getLastName());
        unuser.setEmail(user.getEmail());
        unuser.setPassword(user.getPassword());


        return userService.saveUser(unuser);
    }


    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userService.findAllUsers());
    }

}
