package com.spring.mateusz.spring6reactive.mappers;

import com.spring.mateusz.spring6reactive.domain.Customer;
import com.spring.mateusz.spring6reactive.model.CustomerDTO;
import org.mapstruct.Mapper;

@Mapper
public interface CustomerMapper {
    Customer customerDtoToCustomer(CustomerDTO customerDTO);
    CustomerDTO customerToCustomerDto(Customer customer);
}
