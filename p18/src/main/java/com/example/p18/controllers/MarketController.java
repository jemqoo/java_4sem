package com.example.p18.controllers;

import com.example.p18.services.MarketService;
import com.example.p18.dto.MarketDTO;
import com.example.p18.models.Market;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/markets")
public class MarketController {
    private final MarketService marketService;
    private final ModelMapper modelMapper;

    @Autowired
    public MarketController(MarketService marketService, ModelMapper modelMapper) {
        this.marketService = marketService;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    public List<MarketDTO> getAll() {
        return marketService.findAll().stream().map(this::convertToManufactureDTO).collect(Collectors.toList());
    }


    @DeleteMapping("/{id}")
    public HttpStatus deleteById(@PathVariable("id")int id) {
        marketService.delete(id);
        return HttpStatus.OK;
    }

    @PostMapping
    public HttpStatus add(@RequestBody MarketDTO marketDTO) {
        marketService.save(convertToManufacture(marketDTO));
        return HttpStatus.OK;
    }

    private MarketDTO convertToManufactureDTO(Market market) {
        return modelMapper.map(market, MarketDTO.class);
    }

    private Market convertToManufacture(MarketDTO marketDTO) {
        return modelMapper.map(marketDTO, Market.class);
    }
}