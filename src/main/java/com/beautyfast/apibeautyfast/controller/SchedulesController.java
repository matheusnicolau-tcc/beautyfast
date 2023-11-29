package com.beautyfast.apibeautyfast.controller;

import com.beautyfast.apibeautyfast.dto.ScheduleDTO;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/schedules")
public class SchedulesController {

    @PostMapping
    public ResponseEntity<ScheduleDTO> createUser(@Valid @RequestBody ScheduleDTO userDTO) {

        return new ResponseEntity<ScheduleDTO>(HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ScheduleDTO> getOnUser(@PathVariable Long id) {

        return new ResponseEntity<ScheduleDTO>(HttpStatus.OK);
    }

    @GetMapping("/list")
    public ResponseEntity<List<ScheduleDTO>> getOnUser() {

        return new ResponseEntity<List<ScheduleDTO>>(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ScheduleDTO> updateUser(@PathVariable Long id){

        return new ResponseEntity<ScheduleDTO>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ScheduleDTO> deleteUser(@PathVariable Long id){

        return new ResponseEntity<ScheduleDTO>(HttpStatus.CREATED);
    }
}
