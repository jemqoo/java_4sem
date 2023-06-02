package com.example.p18.services;

import com.example.p18.models.Market;
import com.example.p18.repositories.MarketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class MarketService {

    private final MarketRepository marketRepository;

    @Autowired
    public MarketService(MarketRepository marketRepository){
        this.marketRepository = marketRepository;
    }

    @Transactional(readOnly = true)
    public List<Market> findAll() {
        return marketRepository.findAll();
    }

    @Transactional
    public void save(Market market) {
        marketRepository.save(market);
    }

    @Transactional
    public void delete(int id) {
        marketRepository.deleteById(id);
    }
}
