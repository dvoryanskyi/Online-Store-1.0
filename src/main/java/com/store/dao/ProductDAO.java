package com.store.dao;

import com.store.entity.Product;

import java.util.List;

public interface ProductDAO {

    public List<Product> getAll();

    public Product getById(Long id);

    public void add(Product product);
}
