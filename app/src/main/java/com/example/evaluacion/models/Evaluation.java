package com.example.evaluacion.models;

import java.io.Serializable;

public class Evaluation implements Serializable {
    private long id;
    private String Height;
    private String Weight;

    public Evaluation(String Height, String Weight) {
        this.Height = Height;
        this.Weight = Weight;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getHeight() {
        return Height;
    }

    public String getWeight() {
        return Weight;
    }
}