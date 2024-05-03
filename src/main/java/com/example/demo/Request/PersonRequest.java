package com.example.demo.Request;

import com.example.demo.Entity.Person;
import com.example.demo.Enum.Department;

public class PersonRequest {

    private int id;
    private String name;
    private Department department;

    public PersonRequest(int id, String name, Department department) {
        this.id = id;
        this.name = name;
        this.department = department;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Person saveRequestObeject(){
        Person person = new Person();
        person.setName(this.name);
        person.setDepartment(this.department);

        return person;
    }
}
