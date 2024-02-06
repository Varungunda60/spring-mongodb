package com.varun.mongodbpractice.controller;

import com.varun.mongodbpractice.Dto.TaskDto;
import com.varun.mongodbpractice.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    TaskService taskService;
    @GetMapping("/getAll")
    public ResponseEntity<List<TaskDto>> getAllTasks(){
        return new ResponseEntity<>(taskService.findAllTasks(), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<TaskDto> create(@RequestBody TaskDto taskDto){
        return new ResponseEntity<>(taskService.createTask(taskDto),HttpStatus.CREATED);
    }

}
