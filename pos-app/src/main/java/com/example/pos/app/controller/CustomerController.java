package com.example.pos.app.controller;


import com.example.pos.app.dto.CustomerDTO;
import com.example.pos.app.dto.request.CustomerUpdateDTO;
import com.example.pos.app.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/customer")
@CrossOrigin
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @PostMapping(path = "/save")
    public String saveCustomer(@RequestBody CustomerDTO customerDTO) {
        customerService.saveCustomer(customerDTO);
        return "saved";
    }

    @PutMapping(path = "/update")
    public String updateCustomer(@RequestBody CustomerUpdateDTO customerUpdateDTO) {
        customerService.updateCustomerDetails(customerUpdateDTO);
        return "updated";

    }

    @GetMapping(path="/get-by-id",params = "id")
    public CustomerDTO getCustomerById(@RequestParam("id") int customerId) {
        CustomerDTO customerDTO=customerService.getCustomerById(customerId);
        return customerDTO;

    }




}
