package com.example.p15.controllers;

import com.example.p15.dao.MarketDAO;
import com.example.p15.models.Market;
import com.example.p15.utils.MarketNotFoundException;
import com.example.p15.utils.MarketResponse;
import com.example.p15.utils.MarketValidator;
import com.example.p15.utils.WrongMarketDataException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/markets")
public class MarketsController {
    private final MarketDAO marketDAO;
    private final MarketValidator workerValidator;

    @Autowired
    public MarketsController(MarketDAO marketDAO, MarketValidator workerValidator) {
        this.marketDAO = marketDAO;
        this.workerValidator = workerValidator;
    }

    @GetMapping
    public List<Market> getAll() {
        return marketDAO.findAll();
    }

    @PostMapping("/add")
    public HttpStatus add(@RequestBody Market market) throws WrongMarketDataException {
        if(!workerValidator.validate(market))
            throw new WrongMarketDataException("Wrong values in fields");
        marketDAO.save(market);
        return HttpStatus.OK;
    }

    @DeleteMapping("/{id}")
    public HttpStatus delete(@PathVariable("id") int id) throws MarketNotFoundException {
        try{
            marketDAO.delete(id);
        }
        catch (Exception e){
            throw new MarketNotFoundException();
        }
        return HttpStatus.OK;
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<MarketResponse> notFound(MarketNotFoundException e) {
        MarketResponse response = new MarketResponse(e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<MarketResponse> wrongWorkerFields(MarketNotFoundException e) {
        MarketResponse response = new MarketResponse(e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}