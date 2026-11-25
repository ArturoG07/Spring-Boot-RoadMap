package com.Spring.FinalProyect.service;

import com.Spring.FinalProyect.dto.CustomerRequestDTO;
import com.Spring.FinalProyect.dto.CustomerResponseDTO;
import java.util.List;

public interface ICustomerService {
    public CustomerResponseDTO createCustomer(CustomerRequestDTO dto);
    public List<CustomerResponseDTO> findCustomers();
    public CustomerResponseDTO findCustomer(Long customerCode);
    public CustomerResponseDTO updateCustomer(Long customerCode, CustomerRequestDTO dto);
    public void deleteCustomer(Long customerCode);
}
