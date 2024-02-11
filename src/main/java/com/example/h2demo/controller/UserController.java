package com.example.h2demo.controller;

import com.example.h2demo.entity.User;
import com.example.h2demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.h2demo.validation.Validate.validate;

@RestController
@RequestMapping("/v1")
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.findAll();
    }

    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable("id") int id) {
        return userService.findById(id);
    }

    @PutMapping("/users")
    public ResponseEntity<User> addUser(@RequestBody User user) {
        if(validate(user)) {
            User dbUser = userService.findById(user.getId());
            if(dbUser==null) {
                userService.save(user);
            }
            else {
                dbUser.setFirstName(user.getFirstName());
                dbUser.setLastName(user.getLastName());
                dbUser.setEmail(user.getEmail());
                userService.save(dbUser);
            }
            return new ResponseEntity<> (user, HttpStatus.CREATED);
        }
        return new ResponseEntity<> (user, HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/users")
    public ResponseEntity<User> addNewUser(@RequestBody User user) {
        if(validate(user)) {
            userService.save(user);
            return new ResponseEntity<>(user, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(user, HttpStatus.BAD_REQUEST);
    }
}
