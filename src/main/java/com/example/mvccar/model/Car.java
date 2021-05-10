package com.example.mvccar.model;

import org.springframework.http.ResponseEntity;

public class Car {

    private int id;

    private String mark;

    private String model;

    private String color;

    private boolean flagAdd;

    public Car(int id, String mark, String model, String color) {
        this.id = id;
        this.mark = mark;
        this.model = model;
        this.color = color;
    }
    public Car(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean getFlagAdd() {
        return flagAdd;
    }

    public void setFlagAdd(boolean flagAdd) {
        this.flagAdd = flagAdd;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", mark='" + mark + '\'' +
                ", model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", flagAdd=" + flagAdd +
                '}';
    }
}

