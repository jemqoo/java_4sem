package com.example.p14.controllers;

import com.example.p14.dao.MarketDAO;
import com.example.p14.models.Market;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/markets")
public class MarketController {
    private final MarketDAO marketDAO;

    @Autowired
    public MarketController(MarketDAO marketDAO) {
        this.marketDAO = marketDAO;
    }

    @GetMapping
    public List<Market> getAll() {
        return marketDAO.findAll();
    }

    @PostMapping
    public HttpStatus add(@RequestBody Market market){
        marketDAO.save(market);
        return HttpStatus.OK;
    }

    @DeleteMapping("/{name}")
    public HttpStatus delete(@PathVariable("name") String name) {
        marketDAO.delete(name);
        return HttpStatus.OK;
    }
}