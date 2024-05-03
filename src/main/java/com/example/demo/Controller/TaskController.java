package com.example.demo.Controller;

import com.example.demo.Entity.Task;
import com.example.demo.Request.TaskRequest;
import com.example.demo.Response.ListPerson;
import com.example.demo.Service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskController {

    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping("/tarefas")
    public ResponseEntity<Task> registerTask(@RequestBody TaskRequest taskRequest){
        Task task = taskService.saveTask(taskRequest);
        return new ResponseEntity<>(task, HttpStatus.CREATED);
    }

    @PutMapping("/tarefas/alocar")
    public ResponseEntity<Task> allocatePerson(@RequestBody TaskRequest taskRequest){
        Task task = taskService.allocatePerson(taskRequest);
        return new ResponseEntity<>(task, HttpStatus.OK);
    }

    @PutMapping("/tarefas/finalizar/{id}")
    public ResponseEntity<Task> finishTask(@PathVariable int id){
        Task task = taskService.finishTask(id);
        return new ResponseEntity<>(task, HttpStatus.OK);
    }

    @GetMapping("/pendentes")
    public List<Task> listPendingTasks(){
        return taskService.listPendingTasks();
    }
}
