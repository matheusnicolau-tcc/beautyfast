package com.beautyfast.apibeautyfast.controller;


import com.beautyfast.apibeautyfast.dto.CustomerDTO;
import com.beautyfast.apibeautyfast.model.entity.Customer;
import com.beautyfast.apibeautyfast.model.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;


    @PostMapping
    public ResponseEntity<Customer> createUser(@RequestBody CustomerDTO customerDTO) {
        Customer customerReturn = customerService.createNewCustomer(customerDTO);
        return new ResponseEntity<>(customerReturn, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDTO> getOnUser(@PathVariable Long id) {
        return new ResponseEntity<>(customerService.searchById(id), HttpStatus.OK);
    }

    @GetMapping("/list")
    public ResponseEntity<List<Customer>> getOnUser() {
        List<Customer> usersList = customerService.findAll();
        return new ResponseEntity<List<Customer>>(usersList, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateUser(@PathVariable Long id, @RequestBody CustomerDTO userDTO){
        return new ResponseEntity<>(customerService.updateCustomer(id, userDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id){
        return new ResponseEntity<>(customerService.deleteCustomer(id), HttpStatus.OK);
    }
}
