package com.store.dao;

import com.store.entity.Product;

import java.util.List;

public interface ProductDAO {

    public List<Product> getAll();

    public Product getById(Long id);

    public void add(Product product);

    public void update(Product product);

    public void delete(Long id);

    public List<Product> find(String text);
}
