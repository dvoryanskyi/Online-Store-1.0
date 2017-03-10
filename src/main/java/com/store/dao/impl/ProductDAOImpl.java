package com.store.dao.impl;

import com.store.dao.ProductDAO;
import com.store.entity.Product;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.search.FullTextSession;
import org.hibernate.search.Search;
import org.hibernate.search.SearchFactory;
import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
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

    @Override
    public void update(Product product) {
        Product exProduct = sessionFactory.getCurrentSession().get(Product.class,product.getId());
        exProduct.setName(product.getName());
        exProduct.setDescription(product.getDescription());
        exProduct.setPrice(product.getPrice());
        sessionFactory.getCurrentSession().update(exProduct);
    }

    @Override
    public void delete(Long id) {
        Product product = sessionFactory.getCurrentSession().get(Product.class,id);
        sessionFactory.getCurrentSession().delete(product);
    }

    @Override
    public List<Product> find(String text) {
        FullTextSession fullTextSession = Search.getFullTextSession(sessionFactory.getCurrentSession());
        try {
            fullTextSession.createIndexer().startAndWait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        final QueryBuilder builder = fullTextSession.getSearchFactory().buildQueryBuilder().forEntity(Product.class).get();
        org.apache.lucene.search.Query luceneQuery = builder.keyword().onFields("name","description").matching(text).createQuery();
        org.hibernate.Query fullTextQuery =  fullTextSession.createFullTextQuery(luceneQuery);
        List<Product> result =  fullTextQuery.getResultList();
        System.out.println(result);
        return result;
    }
}
