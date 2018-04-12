package com.users.task.springrestfullcrud.controllers;

import com.users.task.springrestfullcrud.models.User;
import com.users.task.springrestfullcrud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UsersController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<User> list() {
        return userService.getUsersList();
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public User user(@PathVariable("id") long id) {
        return userService.getUser(id);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") long id) {
        userService.deleteUser(id);
    }

    //{name: "Вася", login: "vasa", password: "123123", roles: {1, 3, 5}}
    @PostMapping("/add")
    public Long add(@RequestParam String name, @RequestParam String login, @RequestParam String password) {
        User user = new User();
        user.setName(name);
        user.setLogin(login);
        user.setPassword(password);
        return userService.addUser(user);
    }

    @RequestMapping(value = "/edit", method = RequestMethod.PUT)
    public void edit(@RequestBody User user) {
        userService.editUser(user);
    }
}
