package com.store.service;

import com.store.entity.User;

import java.util.List;

public interface UserService {

    public List<User> getAll();

    public User getById(Long id);

}
