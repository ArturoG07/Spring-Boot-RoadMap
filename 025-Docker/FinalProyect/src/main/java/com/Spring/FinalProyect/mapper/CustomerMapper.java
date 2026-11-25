package com.Spring.FinalProyect.mapper;

import com.Spring.FinalProyect.dto.CustomerRequestDTO;
import com.Spring.FinalProyect.dto.CustomerResponseDTO;
import com.Spring.FinalProyect.model.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {

    public CustomerResponseDTO toDto(Customer customer) {
        return new CustomerResponseDTO(
                customer.getCustomerCode(),
                customer.getFirstName(),
                customer.getLastName(),
                customer.getNationalId()
        );
    }

    public Customer toEntity(CustomerRequestDTO dto) {
        Customer customer = new Customer();
        customer.setFirstName(dto.getFirstName());
        customer.setLastName(dto.getLastName());
        customer.setNationalId(dto.getNationalId());
        return customer;
    }

    public void updateEntity(Customer customer, CustomerRequestDTO dto) {
        customer.setFirstName(dto.getFirstName());
        customer.setLastName(dto.getLastName());
        customer.setNationalId(dto.getNationalId());

    }
}
