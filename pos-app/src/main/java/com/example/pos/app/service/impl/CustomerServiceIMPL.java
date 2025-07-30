package com.example.pos.app.service.impl;

import com.example.pos.app.dto.CustomerDTO;
import com.example.pos.app.entity.Customer;
import com.example.pos.app.repo.CustomerRepo;
import com.example.pos.app.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceIMPL implements CustomerService {
    @Autowired
    private CustomerRepo customerRepo;
    @Override
    public String saveCustomer(CustomerDTO customerDTO) {
        Customer customer = new Customer(
              customerDTO.getCustomerId(),
              customerDTO.getCustomerName(),
              customerDTO.getCustomerAddress(),
              customerDTO.getCustomerSalary(),
              customerDTO.getContactNumber(),
              customerDTO.getNic()
        );
        customerRepo.save(customer);
        return customerDTO.getCustomerName();


    }
}
