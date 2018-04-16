package com.users.task.springrestfullcrud.service;

import com.users.task.springrestfullcrud.models.Role;

import java.util.Set;

public interface RoleService {

    void addRole(Role role);
    Set<Role> getRoles(Set<Role> roles);

}
