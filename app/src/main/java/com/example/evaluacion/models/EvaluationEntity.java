package com.example.evaluacion.models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;


@Entity(tableName = "evaluations")
public class EvaluationEntity implements IEvaluation{
    @PrimaryKey(autoGenerate = true)
    private long id;

    @ColumnInfo(name = "height")
    private double height;

    @ColumnInfo(name = "weight")
    private double weight;

    @ColumnInfo(name = "date")
    private Date date;

    @ColumnInfo(name = "user_id")
    private long userId;

    @ColumnInfo(name = "imc")
    private double imc;


    public EvaluationEntity(long id, double height, double weight, Date date, long userId, double imc) {
        this.id = id;
        this.height = height;
        this.weight = weight;
        this.date = date;
        this.userId = userId;
        this.imc = imc;
    }

    public long getUserId() {
        return userId;
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public double getHeight() {
        return height;
    }

    @Override
    public double getWeight() {
        return weight;
    }

    @Override
    public double getImc() {
        return imc;
    }

    @Override
    public Date getDate() {
        return date;
    }

    public long  getUserID() {
        return userId;
    }
}
