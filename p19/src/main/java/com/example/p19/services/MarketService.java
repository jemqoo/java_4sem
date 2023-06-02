package com.example.p19.services;

import com.example.p19.models.Market;
import com.example.p19.repositories.MarketRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Slf4j
public class MarketService {

    private final MarketRepository marketRepository;

    @Autowired
    public MarketService(MarketRepository marketRepository){
        this.marketRepository = marketRepository;
    }

    @Transactional(readOnly = true)
    public List<Market> findAll() {
        log.info("Market displayed");

        return marketRepository.findAll();
    }

    @Transactional
    public void save(Market market) {
        log.info("Market with id:{product.getID()} saved");
        marketRepository.save(market);
    }

    @Transactional
    public void delete(int id) {
        log.info("Market with id:{id} deleted");
        marketRepository.deleteById(id);
    }
}
