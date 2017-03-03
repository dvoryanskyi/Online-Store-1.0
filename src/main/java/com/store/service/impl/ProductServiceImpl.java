package com.store.service.impl;


import com.store.dao.ProductDAO;
import com.store.entity.Product;
import com.store.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductDAO productDAO;
    @Override
    public List<Product> getAll() {
        return productDAO.getAll();
    }

    @Override
    public Product getById(Long id) {
        return productDAO.getById(id);
    }

    @Override
    public void add(Product product) {
        productDAO.add(product);
    }
}
