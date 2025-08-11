package com.example.pos.app.controller;


import com.example.pos.app.dto.CustomerDTO;
import com.example.pos.app.dto.request.CustomerUpdateDTO;
import com.example.pos.app.service.CustomerService;
import com.example.pos.app.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/customer")
@CrossOrigin
public class CustomerController {
    @Autowired
    private CustomerService customerService;
//    @PostMapping(path = "/save")
//    public String saveCustomer(@RequestBody CustomerDTO customerDTO) {
//        customerService.saveCustomer(customerDTO);
//        return "saved";
//    }

    @PostMapping(path = "/save")
    public ResponseEntity<StandardResponse> saveCustomer(@RequestBody CustomerDTO customerDTO) {
       String message= customerService.saveCustomer(customerDTO);
//       ResponseEntity<StandardResponse> response=new ResponseEntity<StandardResponse>(
//               new StandardResponse(201,"Sucess",message), HttpStatus.CREATED
//
//       );
//       return response;

        return new ResponseEntity<StandardResponse>(
                new StandardResponse(201,"Sucess",message),
                HttpStatus.CREATED
        );
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

//    @GetMapping(path = "/get-all-customers")
//    public List<CustomerDTO> getAllCustomers() {
//        List<CustomerDTO> allCustomers=customerService.getAllCustomers();
//        return allCustomers;
//    }

    @GetMapping(path = "/get-all-customers")
    public ResponseEntity<StandardResponse> getAllCustomers() {
        List<CustomerDTO> customerDTOList=customerService.getAllCustomers();
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"Sucess",customerDTOList),
                HttpStatus.OK
        );
    }




}
