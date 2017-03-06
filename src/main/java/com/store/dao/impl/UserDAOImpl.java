package com.store.dao.impl;

import com.store.dao.UserDAO;
import com.store.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Repository
@Transactional
public class UserDAOImpl implements UserDAO{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<User> getAll() {
        return sessionFactory.getCurrentSession().createCriteria(User.class).list();
    }

    @Override
    public User getById(Long id) {
        return sessionFactory.getCurrentSession().get(User.class,id);
    }

    @Override
    public void add(User user) {
        sessionFactory.getCurrentSession().save(user);
    }
    @Override
    public void update(User user) {
        User exUser = sessionFactory.getCurrentSession().get(User.class,user.getId());
        exUser.setName(user.getName());
        exUser.setPassword(user.getPassword());
        exUser.setRole(user.getRole());
        sessionFactory.getCurrentSession().update(exUser);
    }

    @Override
    public void delete(Long id) {
        User user = sessionFactory.getCurrentSession().get(User.class,id);
        sessionFactory.getCurrentSession().delete(user);
    }
}
