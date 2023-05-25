package com.spring.mateusz.spring6reactive.repositories;

import com.spring.mateusz.spring6reactive.config.DatabaseConfig;
import com.spring.mateusz.spring6reactive.domain.Beer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.r2dbc.DataR2dbcTest;
import org.springframework.context.annotation.Import;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@DataR2dbcTest
@Import(DatabaseConfig.class)
class BeerRepositoryTest {

    @Autowired
    BeerRepository beerRepository;

    @Test
    void testSaveNewBeer() {
        beerRepository.save(getTestBeer())
                .subscribe(beer -> {
                    System.out.println(beer.toString());
                });
    }

    Beer getTestBeer() {
        return Beer.builder()
                .beerName("Grass Hopper")
                .beerStyle("ALE")
                .price(BigDecimal.TEN)
                .quantityOnHand(11)
                .upc("623442")
                .build();
    }
}