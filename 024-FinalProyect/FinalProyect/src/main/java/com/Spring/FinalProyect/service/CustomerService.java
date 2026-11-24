package com.Spring.FinalProyect.service;

import com.Spring.FinalProyect.dto.CustomerRequestDTO;
import com.Spring.FinalProyect.dto.CustomerResponseDTO;
import com.Spring.FinalProyect.exception.CustomerNotFoundException;
import com.Spring.FinalProyect.mapper.CustomerMapper;
import com.Spring.FinalProyect.model.Customer;
import com.Spring.FinalProyect.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService implements ICustomerService{

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public CustomerResponseDTO createCustomer(CustomerRequestDTO dto) {
        Customer saved = customerRepository.save(customerMapper.toEntity(dto));
        return customerMapper.toDto(saved);
    }

    @Override
    public List<CustomerResponseDTO> findCustomers() {
        List<Customer> customers = customerRepository.findAll();
        List<CustomerResponseDTO> list = new ArrayList<>();
        for (Customer customer : customers) {
            list.add(customerMapper.toDto(customer));
        }
        return list;
    }

    @Override
    public CustomerResponseDTO findCustomer(Long customerCode) {
        Customer customer = customerRepository.findById(customerCode)
                .orElseThrow(() -> new CustomerNotFoundException(customerCode));
        return customerMapper.toDto(customer);
    }

    @Override
    public CustomerResponseDTO updateCustomer(Long customerCode, CustomerRequestDTO dto) {
        Customer customer = customerRepository.findById(customerCode)
                .orElseThrow(() -> new CustomerNotFoundException(customerCode));
        customerMapper.updateEntity(customer, dto);
        Customer saved = customerRepository.save(customer);
        return customerMapper.toDto(saved);
    }

    @Override
    public void deleteCustomer(Long customerCode) {
        if (!customerRepository.existsById(customerCode)) {
            throw new CustomerNotFoundException(customerCode);
        }
        customerRepository.deleteById(customerCode);
    }
}
