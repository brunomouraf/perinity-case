package com.example.demo.Request;

import com.example.demo.Enum.Department;
import com.example.demo.Enum.TaskStatus;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public class TaskRequest {

    private int id;
    private String title;
    private String description;
    private int deadline;
    private Department department;
    private String allocatedPerson;
    private TaskStatus taskStatus;
    private int personId;


}
