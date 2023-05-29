package com.spring.mateusz.spring6reactive.repositories;

import com.spring.mateusz.spring6reactive.domain.Customer;

public class CustomerRepositoryTest {
    public static Customer getTestCustomer() {
        return Customer.builder()
                .name("Megan")
                .build();
    }
}
