package com.example.pos.app.service;

import com.example.pos.app.dto.CustomerDTO;
import com.example.pos.app.dto.request.CustomerUpdateDTO;

import java.util.List;

public interface CustomerService {
    String saveCustomer(CustomerDTO customerDTO);

    String updateCustomerDetails(CustomerUpdateDTO customerUpdateDTO);

    CustomerDTO getCustomerById(int customerId);

    List<CustomerDTO> getAllCustomers();
}
