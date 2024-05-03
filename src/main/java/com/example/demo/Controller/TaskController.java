package com.example.demo.Controller;

import com.example.demo.Entity.Task;
import com.example.demo.Request.TaskRequest;
import com.example.demo.Service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
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

    @PostMapping("/allocate-person")
    public ResponseEntity<Task> allocatePerson(@RequestBody TaskRequest taskRequest){
        Task task = taskService.allocatePerson(taskRequest);
        return new ResponseEntity<>(task, HttpStatus.OK);
    }
}
