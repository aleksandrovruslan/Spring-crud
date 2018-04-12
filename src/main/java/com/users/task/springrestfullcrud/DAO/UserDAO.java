package com.users.task.springrestfullcrud.DAO;

import com.users.task.springrestfullcrud.models.User;

import java.util.List;

public interface UserDAO {

    List<User> getUsersList();
    User getUser(Long id);
    void deleteUser(Long id);
    Long addUser(User user);
    void editUser(User user);

}
