package com.users.task.springrestfullcrud.DAO;

import com.users.task.springrestfullcrud.models.Role;

import java.util.Set;

public interface RoleDAO {

    void addRole(Role role);
    Set<Role> getRoles(Set<Role> roles);

}
