package com.store.dao;



import com.store.entity.User;

import java.util.List;

public interface UserDAO {

    public List<User> getAll();

    public User getById(Long id);

}
