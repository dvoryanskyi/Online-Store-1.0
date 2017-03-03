package com.store.dao.impl;

import com.store.dao.ProductDAO;
import com.store.entity.Product;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Repository
@Transactional
public class ProductDAOImpl implements ProductDAO{

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public List<Product> getAll() {
        return sessionFactory.getCurrentSession().createCriteria(Product.class).list();
    }

    @Override
    public Product getById(Long id) {
        return sessionFactory.getCurrentSession().get(Product.class,id);
    }

    @Override
    public void add(Product product) {
        sessionFactory.getCurrentSession().save(product);
    }
}
