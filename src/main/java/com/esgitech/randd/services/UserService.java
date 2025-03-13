package com.esgitech.randd.services;

import com.esgitech.randd.entities.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);

    List<User> findAllUsers();
}
