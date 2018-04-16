package com.users.task.springrestfullcrud.service;

import com.users.task.springrestfullcrud.DAO.UserDAO;
import com.users.task.springrestfullcrud.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDAO userDAO;

    @Override
    public List<User> getUsersList() {
        return userDAO.getUsersList();
    }

    @Override
    public User getUser(long id) {
        return userDAO.getUser(id);
    }

    @Override
    public void deleteUser(long id) {
        userDAO.deleteUser(id);
    }

    @Override
    public Long addUser(User user) {
        return userDAO.addUser(user);
    }

    @Override
    public void edit(User user) {
        userDAO.edit(user);
    }
}
