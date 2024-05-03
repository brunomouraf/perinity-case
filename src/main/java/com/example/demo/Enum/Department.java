package com.example.demo.Enum;

public enum Department {
    BE("Back-end"),
    FE("Front-end"),
    DO("DevOps");

    private String description;

    Department(String description){
        this.description = description;
    }

    public String getDescription(){
        return description;
    }
}
