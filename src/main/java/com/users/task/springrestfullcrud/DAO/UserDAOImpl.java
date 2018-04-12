package com.users.task.springrestfullcrud.DAO;

import com.users.task.springrestfullcrud.models.Role;
import com.users.task.springrestfullcrud.models.User;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.HashSet;
import java.util.List;

@Repository
@Transactional
public class UserDAOImpl implements UserDAO {
    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<User> getUsersList() {
        initUsers();

        List userList = manager.unwrap(Session.class)
                .createQuery("from User").list();
        return userList;
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
        manager.merge(user);
        return user.getId();
    }

    @Override
    public void editUser(User user) {
        manager.merge(user);
    }


    //TODO delete this
    private void initUsers() {
        Role user = new Role("User");
        Role admin = new Role("Admin");
        Role moder = new Role("Moderator");

        manager.persist(user);
        manager.persist(admin);
        manager.persist(moder);

        User alex = new User("Alex", "alex", "Passwo0rd", new HashSet<>());
        alex.getRoles().add(admin);
        alex.getRoles().add(moder);

        User nikolay = new User("Nikolay", "nikolay", "Passw0rd", new HashSet<>());
        nikolay.getRoles().add(user);

        manager.merge(alex);
        manager.merge(nikolay);
    }
}
