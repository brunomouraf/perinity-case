package com.example.demo.Controller;

import com.example.demo.Entity.Task;
import com.example.demo.Request.TaskRequest;
import com.example.demo.Service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class TaskController {

    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping("/register-task")
    public ResponseEntity<Task> registerTask(@RequestBody TaskRequest taskRequest){
        Task task = taskService.saveTask(taskRequest);
        return new ResponseEntity<>(task, HttpStatus.CREATED);
    }

    @PutMapping("/finish-task/{id}")
    public ResponseEntity<Task> finishTask(@PathVariable int id){
        Task task = taskService.finishTask(id);
        return new ResponseEntity<>(task, HttpStatus.OK);
    }
}
