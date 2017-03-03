package com.store.service.impl;

import com.store.dao.UserDAO;
import com.store.entity.User;
import com.store.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDAO userDAO;


    @Override
    public List<User> getAll() {
        return userDAO.getAll();
    }

    @Override
    public User getById(Long id) {
        return userDAO.getById(id);
    }
}
