package com.users.task.springrestfullcrud.service;

import com.users.task.springrestfullcrud.DAO.RoleDAO;
import com.users.task.springrestfullcrud.models.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleDAO roleDAO;

    @Override
    public void addRole(Role role) {
        roleDAO.addRole(role);
    }

    @Override
    public Set<Role> getRoles(Set<Role> roles) {
        return roleDAO.getRoles(roles);
    }
}
