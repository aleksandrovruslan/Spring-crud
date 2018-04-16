package com.users.task.springrestfullcrud.controllers;

import com.users.task.springrestfullcrud.models.User;
import com.users.task.springrestfullcrud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class UsersController {

    @Autowired
    private UserService userService;

    @GetMapping("/list")
    public List<User> list() {
        return userService.getUsersList();
    }

    @GetMapping("/get/{id}")
    public User user(@PathVariable("id") long id) {
        return userService.getUser(id);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") long id) {
        userService.deleteUser(id);
    }

    @PostMapping("/add")
    public void add(@RequestBody User user) {
        userService.addUser(user);
    }

    @PutMapping("/edit")
    public void edit(@RequestBody User user) {
        userService.edit(user);
    }

}