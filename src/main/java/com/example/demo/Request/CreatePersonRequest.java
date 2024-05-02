package com.example.demo.Request;

import com.example.demo.Entity.Person;
import jakarta.persistence.Column;

public class CreatePersonRequest {
    private String name;
    private String department;

    public CreatePersonRequest(String name, String department) {
        this.name = name;
        this.department = department;
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

    public Person saveRequestObeject(){
        Person person = new Person();
        person.setName(this.name);
        person.setDepartment(this.department);

        return person;
    }
}
