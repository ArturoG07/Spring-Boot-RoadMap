package com.Spring.FinalProyect.controller;

import com.Spring.FinalProyect.dto.CustomerRequestDTO;
import com.Spring.FinalProyect.dto.CustomerResponseDTO;
import com.Spring.FinalProyect.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @PostMapping("/customers")
    public CustomerResponseDTO createCustomer(@RequestBody CustomerRequestDTO dto) {
        return customerService.createCustomer(dto);
    }

    @GetMapping("/customers")
    public List<CustomerResponseDTO> getCustomers() {
        return customerService.findCustomers();
    }

    @GetMapping("/customers/{customerCode}")
    public CustomerResponseDTO getCustomer(@PathVariable Long customerCode) {
        return customerService.findCustomer(customerCode);
    }

    @PutMapping("/customers/{customerCode}")
    public CustomerResponseDTO updateCustomer(@PathVariable Long customerCode,
                                              @RequestBody CustomerRequestDTO dto) {
        return customerService.updateCustomer(customerCode, dto);
    }

    @DeleteMapping("/customers/{customerCode}")
    public void deleteCustomer(@PathVariable Long customerCode) {
        customerService.deleteCustomer(customerCode);
    }
}
