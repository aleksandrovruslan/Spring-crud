package com.users.task.springrestfullcrud.DAO;

import com.users.task.springrestfullcrud.models.Role;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.HashSet;
import java.util.Set;

@Repository
@Transactional
public class RoleDAOImpl implements RoleDAO {
    @PersistenceContext
    private EntityManager manager;

    @Override
    public void addRole(Role role) {
        manager.persist(role);
    }

    @Override
    public Set<Role> getRoles(Set<Role> roles) {
        Session session = manager.unwrap(Session.class);
        Set<Role> rolesData = new HashSet<>();
        Role roleData;
        for (Role role:roles) {
            roleData = session.get(Role.class, role.getId());
            if (roleData == null) {
                throw new IllegalStateException("Role is missing or incorrect.");
            }
            rolesData.add(roleData);
        }
        return rolesData;
    }
}
