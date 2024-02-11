package com.example.h2demo.service;

import com.example.h2demo.entity.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    User findById(int id);
    void deleteById(int id);
    User save(User user);
}
