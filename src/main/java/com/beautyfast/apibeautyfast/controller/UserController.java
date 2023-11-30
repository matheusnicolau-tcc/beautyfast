package com.beautyfast.apibeautyfast.controller;

import com.beautyfast.apibeautyfast.dto.UserDTO;
import com.beautyfast.apibeautyfast.model.entity.User;
import com.beautyfast.apibeautyfast.model.service.UserService;
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
        return new ResponseEntity<UserDTO>(userService.searchById(id), HttpStatus.OK);
    }

    @GetMapping("/list")
    public ResponseEntity<List<User>> getOnUser() {
        List<User> usersList = userService.findAll();
        return new ResponseEntity<List<User>>(usersList, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateUser(@PathVariable Long id, @RequestBody UserDTO userDTO){
        return new ResponseEntity<>(userService.updateUser(id, userDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id){
        return new ResponseEntity<>(userService.deleteUser(id), HttpStatus.OK);
    }
}
