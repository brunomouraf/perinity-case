package com.example.demo.Entity;

import com.example.demo.Enum.Department;
import com.example.demo.Enum.TaskStatus;
import jakarta.persistence.*;

@Entity
@Table(name = "tb_task")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;
    @Column(name = "deadline")
    private int deadline;
    @Column(name = "department")
    private Department department;
    @Column(name = "allocated_person")
    private String allocatedPerson;
    @Column(name = "task_status")
    @Enumerated(EnumType.STRING)
    private TaskStatus taskStatus;
    @Column(name = "person_id")
    private int personId;

    public Task(int id, String title, String description, int deadline, Department department, String allocatedPerson, TaskStatus taskStatus, int personId) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.deadline = deadline;
        this.department = department;
        this.allocatedPerson = allocatedPerson;
        this.taskStatus = taskStatus;
        this.personId = personId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDeadline() {
        return deadline;
    }

    public void setDeadline(int deadline) {
        this.deadline = deadline;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public String getAllocatedPerson() {
        return allocatedPerson;
    }

    public void setAllocatedPerson(String allocatedPerson) {
        this.allocatedPerson = allocatedPerson;
    }

    public TaskStatus getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(TaskStatus taskStatus) {
        this.taskStatus = taskStatus;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }
}
