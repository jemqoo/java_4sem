package com.example.p15.dao;

import com.example.p15.models.Market;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.NoArgsConstructor;
import org.hibernate.Session;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Component
public class MarketDAO {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public List<Market> findAll() {
        Session session = entityManager.unwrap(Session.class);
        return session.createQuery("select p from Market p", Market.class).getResultList();
    }

    @Transactional
    public void save(Market market) {
        Session session = entityManager.unwrap(Session.class);
        session.persist(market);
    }

    @Transactional
    public void delete(int id) {
        Session session = entityManager.unwrap(Session.class);
        Market market = session.get(Market.class, id);
        session.remove(market);
    }
}
