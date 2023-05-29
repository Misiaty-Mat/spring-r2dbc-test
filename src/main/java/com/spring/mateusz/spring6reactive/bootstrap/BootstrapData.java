package com.spring.mateusz.spring6reactive.bootstrap;

import com.spring.mateusz.spring6reactive.domain.Beer;
import com.spring.mateusz.spring6reactive.domain.Customer;
import com.spring.mateusz.spring6reactive.repositories.BeerRepository;
import com.spring.mateusz.spring6reactive.repositories.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;

@Component
@RequiredArgsConstructor
public class BootstrapData implements CommandLineRunner {

    private final BeerRepository beerRepository;
    private final CustomerRepository customerRepository;

    @Override
    public void run(String... args) {
        loadBeerData();
        loadCustomerData();
        beerRepository.count().subscribe(count -> {
            System.out.println("Count of beers: " + count);
        });
    }

    private void loadBeerData() {
        beerRepository.count().subscribe(count -> {
            if (count != 0)
                return;

            Beer beer1 = Beer.builder()
                    .beerName("Galaxy Cat")
                    .beerStyle("Pale Ale")
                    .upc("123456")
                    .price(new BigDecimal("12.99"))
                    .quantityOnHand(122)
                    .createdDate(LocalDateTime.now())
                    .lastModifiedDate(LocalDateTime.now())
                    .build();

            Beer beer2 = Beer.builder()
                    .beerName("Crank")
                    .beerStyle("Pale Ale")
                    .upc("541231")
                    .price(new BigDecimal("11.99"))
                    .quantityOnHand(332)
                    .createdDate(LocalDateTime.now())
                    .lastModifiedDate(LocalDateTime.now())
                    .build();

            Beer beer3 = Beer.builder()
                    .beerName("Sunshine city")
                    .beerStyle("Ipa")
                    .upc("65432")
                    .price(new BigDecimal("13.99"))
                    .quantityOnHand(1237)
                    .createdDate(LocalDateTime.now())
                    .lastModifiedDate(LocalDateTime.now())
                    .build();

            beerRepository.save(beer1).subscribe();
            beerRepository.save(beer2).subscribe();
            beerRepository.save(beer3).subscribe();
        });
    }

    private void loadCustomerData() {
        customerRepository.count().subscribe(count -> {
            if (count != 0) {
                return;
            }

            Customer customer1 = Customer.builder()
                    .name("Mateusz")
                    .createdDate(LocalDateTime.now())
                    .lastModifiedDate(LocalDateTime.now())
                    .build();

            Customer customer2 = Customer.builder()
                    .name("Pateusz")
                    .createdDate(LocalDateTime.now())
                    .lastModifiedDate(LocalDateTime.now())
                    .build();

            Customer customer3 = Customer.builder()
                    .name("Vateusz")
                    .createdDate(LocalDateTime.now())
                    .lastModifiedDate(LocalDateTime.now())
                    .build();

            customerRepository.save(customer1).subscribe();
            customerRepository.save(customer2).subscribe();
            customerRepository.save(customer3).subscribe();
        });
    }
}
