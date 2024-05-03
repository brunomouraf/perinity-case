package com.example.demo.Response;

import com.example.demo.Enum.Department;
import com.example.demo.Enum.TaskStatus;

public class ListPerson {
    private String name;
    private String department;
    private int totalHours;

    public ListPerson(String name, String department, int totalHours) {
        this.name = name;
        this.department = department;
        this.totalHours = totalHours;
    }

    public ListPerson() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getTotalHours() {
        return totalHours;
    }

    public void setTotalHours(int totalHours) {
        this.totalHours = totalHours;
    }
}
