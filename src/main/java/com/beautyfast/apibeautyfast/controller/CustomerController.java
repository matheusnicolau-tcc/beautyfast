package com.beautyfast.apibeautyfast.controller;

import com.beautyfast.apibeautyfast.dto.CustomerDTO;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @PostMapping
    public ResponseEntity<CustomerDTO> createUser(@Valid @RequestBody CustomerDTO userDTO) {

        return new ResponseEntity<CustomerDTO>(HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDTO> getOnUser(@PathVariable Long id) {

        return new ResponseEntity<CustomerDTO>(HttpStatus.OK);
    }

    @GetMapping("/list")
    public ResponseEntity<List<CustomerDTO>> getOnUser() {

        return new ResponseEntity<List<CustomerDTO>>(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerDTO> updateUser(@PathVariable Long id){

        return new ResponseEntity<CustomerDTO>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CustomerDTO> deleteUser(@PathVariable Long id){

        return new ResponseEntity<CustomerDTO>(HttpStatus.CREATED);
    }
}
