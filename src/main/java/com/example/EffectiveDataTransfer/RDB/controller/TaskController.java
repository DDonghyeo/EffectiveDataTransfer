package com.example.EffectiveDataTransfer.RDB.controller;

import com.example.EffectiveDataTransfer.RDB.Service.CreateTaskService;
import com.example.EffectiveDataTransfer.RDB.dto.CreateTaskCommand;
import com.example.EffectiveDataTransfer.RDB.dto.CreateTaskResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/RDB")
public class TaskController {

    @Autowired
    private CreateTaskService createTaskService;

    @GetMapping("/createTask")
    public CreateTaskResponse createTask(CreateTaskCommand command) {
        return createTaskService.createTask(command);
    }

}
