package com.example.demo.Enum;

public enum TaskStatus {

    TD("To Do"),
    IP("In Progress"),
    D("Done");

    private String description;

    TaskStatus(String description){
        this.description = description;
    }

    public String getDescription(){
        return description;
    }
}
