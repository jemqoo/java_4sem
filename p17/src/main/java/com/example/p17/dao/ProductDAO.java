package com.example.p17.dao;

import com.example.p17.models.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import lombok.NoArgsConstructor;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Transactional
    public List<Product> getWorkersWithouManifacture() {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();

        CriteriaQuery<Product> criteriaQuery = builder.createQuery(Product.class);
        Root<Product> root = criteriaQuery.from(Product.class);
        criteriaQuery.select(root).where(builder.isNull(root.get("market")));

        TypedQuery<Product> query = entityManager.createQuery(criteriaQuery);
        List<Product> productS = query.getResultList();
        return productS;
    }

    @Transactional
    public Product findByText(String text) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();

        CriteriaQuery<Product> criteriaQuery = builder.createQuery(Product.class);
        Root<Product> root = criteriaQuery.from(Product.class);
        criteriaQuery.select(root).where(builder.equal(root.get("name"), text));

        TypedQuery<Product> query = entityManager.createQuery(criteriaQuery);
        return query.getSingleResult();
    }

    @Transactional
    public List<Product> getWithUser() {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();

        CriteriaQuery<Product> criteriaQuery = builder.createQuery(Product.class);
        Root<Product> root = criteriaQuery.from(Product.class);
        criteriaQuery.select(root).where(builder.isNotNull(root.get("market")));

        TypedQuery<Product> query = entityManager.createQuery(criteriaQuery);
        List<Product> posts = query.getResultList();
        return posts;
    }

    @Transactional
    public List<Product> greaterThanById(int id) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();

        CriteriaQuery<Product> criteriaQuery = builder.createQuery(Product.class);
        Root<Product> root = criteriaQuery.from(Product.class);
        criteriaQuery.select(root).where(builder.greaterThan(root.get("id"), id));

        TypedQuery<Product> query = entityManager.createQuery(criteriaQuery);
        List<Product> posts = query.getResultList();
        return posts;
    }
}
