package com.example.demo.Service;

import com.example.demo.Entity.Person;
import com.example.demo.Entity.Task;
import com.example.demo.Repository.PersonRepository;
import com.example.demo.Repository.TaskRepository;
import com.example.demo.Request.TaskRequest;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

    private PersonRepository personRepository;
    private TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository, PersonRepository personRepository){
        this.taskRepository = taskRepository;
        this.personRepository = personRepository;
    }

    public Task saveTask(TaskRequest taskRequest){
        try{
            Task task = taskRequest.saveRequestObeject();
            return taskRepository.save(task);

        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public Task allocatePerson(TaskRequest taskRequest){
        try{
            Person person = personRepository.findById(taskRequest.getPersonId());
            Task task = taskRepository.findById(taskRequest.getId());

            if(task.getDepartment().equals(person.getDepartment())){
                task.setAllocatedPerson(person.getName());
                task.setPersonId(person.getId());
                return taskRepository.save(task);
            }else throw new RuntimeException("Permissão negada - Departamentos incompativeis");

        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
}
