package com.beautyfast.apibeautyfast.controller;

import com.beautyfast.apibeautyfast.dto.UserDTO;
import com.beautyfast.apibeautyfast.model.entity.User;
import com.beautyfast.apibeautyfast.model.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;


    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody UserDTO userDTO) {
        User userReturn = userService.createNewUser(userDTO);
        return new ResponseEntity<>(userReturn, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getOnUser(@PathVariable Long id) {

        return new ResponseEntity<UserDTO>(HttpStatus.OK);
    }

    @GetMapping("/list")
    public ResponseEntity<List<UserDTO>> getOnUser() {

        return new ResponseEntity<List<UserDTO>>(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable Long id){

        return new ResponseEntity<UserDTO>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<UserDTO> deleteUser(@PathVariable Long id){

        return new ResponseEntity<UserDTO>(HttpStatus.CREATED);
    }
}
