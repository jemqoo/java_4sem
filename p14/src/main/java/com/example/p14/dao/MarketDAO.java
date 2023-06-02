package com.example.p14.dao;

import com.example.p14.models.Market;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MarketDAO {
    private ArrayList<Market> markets;

    public MarketDAO() {
        markets = new ArrayList<>();
        markets.add(new Market("a", "5ka"));
        markets.add(new Market("b", "magnit"));
        markets.add(new Market("c", "diksi"));
        markets.add(new Market("d", "magnoliya"));
        markets.add(new Market("e", "lenta"));
    }

    public List<Market> findAll() {
        return markets;
    }

    public void save(Market market) {
        markets.add(market);
    }

    public void delete(String address) {
        markets.removeIf(it -> it.getAddress().equals(address));
    }
}
