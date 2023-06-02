package com.example.p24;

import com.example.p24.models.Market;
import com.example.p24.repositories.MarketRepository;
import com.example.p24.services.MarketService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class MarketServiceTest {
    @Mock
    private MarketRepository marketRepository;
    @Captor
    private ArgumentCaptor<Market> captor;

    @Test
    void getProducts() {
        Market market = new Market();
        market.setName("market1");
        Market market1 = new Market();
        market1.setName("market2");
        Market market2 = new Market();
        market2.setName("market3");

        Mockito.when(marketRepository.findAll()).thenReturn(List.of(market, market1, market2));
        MarketService marketService = new MarketService(marketRepository);

        Assertions.assertEquals(3, marketService.findAll().size());
        Assertions.assertEquals(market.getName(), marketService.findAll().get(0).getName());
    }

    @Test
    void save() {
        Market market = new Market();
        market.setName("nameTest");

        MarketService service = new MarketService(marketRepository);
        service.save(market);
        Mockito.verify(marketRepository).save(captor.capture());
        Market market1 = captor.getValue();

        Assertions.assertEquals("nameTest", market.getName());
    }

}