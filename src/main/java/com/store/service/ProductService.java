package com.store.service;

import com.store.entity.Product;

import java.util.List;

public interface ProductService {

    public List<Product> getAll();

    public Product getById(Long id);

    public void add(Product product);

    public void update(Product product);

    public void delete(Long id);

}
