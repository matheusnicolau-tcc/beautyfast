package com.beautyfast.apibeautyfast.controller;

import com.beautyfast.apibeautyfast.dto.ScheduleDTO;
import com.beautyfast.apibeautyfast.model.entity.Schedules;
import com.beautyfast.apibeautyfast.model.entity.User;
import com.beautyfast.apibeautyfast.model.service.SchedulesService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/schedules")
public class SchedulesController {

    @Autowired
    SchedulesService schedulesService;

    @PostMapping
    public ResponseEntity<Schedules> createUser(@Valid @RequestBody ScheduleDTO scheduleDTO) {
        Schedules schedulesReturn = schedulesService.createNewSchedule(scheduleDTO);
        return new ResponseEntity<Schedules>(schedulesReturn, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ScheduleDTO> getOnUser(@PathVariable Long id) {
        return new ResponseEntity<ScheduleDTO>(schedulesService.searchById(id), HttpStatus.OK);
    }

    @GetMapping("/list")
    public ResponseEntity<List<Schedules>> getOnUser() {
        List<Schedules> schedulesList = schedulesService.findAll();
        return new ResponseEntity<List<Schedules>>(schedulesList, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateUser(@PathVariable Long id, @RequestBody ScheduleDTO scheduleDTO){
        return new ResponseEntity<>(schedulesService.updateSchedules(id, scheduleDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id){
        return new ResponseEntity<>(schedulesService.deleteUser(id), HttpStatus.OK);
    }
}
