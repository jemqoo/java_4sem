package com.example.p15.dao;

import com.example.p15.models.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.NoArgsConstructor;
import org.hibernate.Session;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Component
@NoArgsConstructor
public class ProductDAO {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public List<Product> findAll() {
        Session session = entityManager.unwrap(Session.class);
        return session.createQuery("select p from Product p", Product.class).getResultList();
    }

    @Transactional
    public void save(Product product) {
        Session session = entityManager.unwrap(Session.class);
        session.persist(product);
    }

    @Transactional
    public void delete(int id) {
        Session session = entityManager.unwrap(Session.class);
        Product product = session.get(Product.class, id);
        session.remove(product);
    }
}
