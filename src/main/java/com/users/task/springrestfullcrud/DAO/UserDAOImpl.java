package com.users.task.springrestfullcrud.DAO;

import com.users.task.springrestfullcrud.models.User;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class UserDAOImpl implements UserDAO {
    @Autowired
    private RoleDAO roleDAO;

    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<User> getUsersList() {
        return manager.unwrap(Session.class).createQuery("from User").list();
    }

    @Override
    public User getUser(Long id) {
        return manager.find(User.class, id);
    }

    @Override
    public void deleteUser(Long id) {
        manager.remove(getUser(id));
    }

    @Override
    public Long addUser(User user) {
        user.setRoles(roleDAO.getRoles(user.getRoles()));
        manager.merge(user);
        return user.getId();
    }

    @Override
    public void edit(User user) {
        Session session = manager.unwrap(Session.class);
        User userData = (User) session.createQuery("select u from User u where login =:uLogin")
                .setParameter("uLogin", user.getLogin()).uniqueResult();
        if (userData != null) {
            userData.setRoles(roleDAO.getRoles(user.getRoles()));
            userData.setName(user.getName());
            userData.setPassword(user.getPassword());
            session.merge(userData);
        }
    }
}
