package com.example.evaluacion.models;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Evaluation implements Serializable, IEvaluation {
    private long id;
    private double height;
    private double weight;
    private Date date;
    private long userId;
    private double imc;

    public Evaluation(double height, double weight, Date date, long userId, double imc) {
        this.height = height;
        this.weight = weight;
        this.date = date;
        this.userId = userId;
        this.imc = imc;
    }

    public long getId() { return id; }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public double getHeight() {
        return height;
    }

    @Override
    public double getWeight() {
        return weight;
    }

    public double getImc() {
        return imc;
    }

    public Date getDate() { return date; }

    public long getUserID() { return userId; }

    public String getStringDate(){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        return formatter.format(date);
    }
}