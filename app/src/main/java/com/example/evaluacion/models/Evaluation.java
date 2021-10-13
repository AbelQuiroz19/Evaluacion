package com.example.evaluacion.models;

import java.io.Serializable;

public class Evaluation implements Serializable {
    private long id;
    private String height;
    private String weight;

    public Evaluation(String height, String weight) {
        this.height = height;
        this.weight = weight;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getHeight() {
        return height;
    }

    public String getWeight() {
        return weight;
    }
}