package com.example.demo.Response;

public class ListSpentHours {

    private String name;
    private int averageHours;

    public ListSpentHours() {
    }

    public ListSpentHours(String name, int averageHours) {
        this.name = name;
        this.averageHours = averageHours;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAverageHours() {
        return averageHours;
    }

    public void setAverageHours(int averageHours) {
        this.averageHours = averageHours;
    }
}
