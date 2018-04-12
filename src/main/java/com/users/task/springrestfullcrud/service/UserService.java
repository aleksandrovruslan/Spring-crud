package com.users.task.springrestfullcrud.service;

import com.users.task.springrestfullcrud.models.User;

import java.util.List;

public interface UserService {

    List<User> getUsersList();
    User getUser(long id);
    void deleteUser(long id);
    Long addUser(User user);
    void editUser(User user);

}
