package com.example.pos.app.service.impl;

import com.example.pos.app.dto.CustomerDTO;
import com.example.pos.app.dto.request.CustomerUpdateDTO;
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

    @Override
    public String updateCustomerDetails(CustomerUpdateDTO customerUpdateDTO) {
        if(customerRepo.existsById(customerUpdateDTO.getCustomerId())) {
            Customer customer = customerRepo.getReferenceById(customerUpdateDTO.getCustomerId());
            customer.setCustomerName(customerUpdateDTO.getCustomerName());
            customer.setCustomerAddress(customerUpdateDTO.getCustomerAddress());
            customer.setCustomerSalary(customerUpdateDTO.getCustomerSalary());
            customerRepo.save(customer);
            return customerUpdateDTO.getCustomerName() + " updated";

        }else{
            throw new RuntimeException("Customer not found");
        }

    }

    @Override
    public CustomerDTO getCustomerById(int customerId) {
        if(customerRepo.existsById(customerId)) {
            Customer customer = customerRepo.getReferenceById(customerId);
            CustomerDTO customerDTO = new CustomerDTO(
                    customer.getCustomerId(),
                    customer.getCustomerName(),
                    customer.getCustomerAddress(),
                    customer.getCustomerSalary(),
                    customer.getContactNumber(),
                    customer.getNic()

            );
            return customerDTO;

        }else{
            throw new RuntimeException("Customer not found");
        }
    }
}
