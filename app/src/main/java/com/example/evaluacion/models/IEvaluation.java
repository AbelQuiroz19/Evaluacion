package com.example.evaluacion.models;

import java.util.Date;

public interface IEvaluation {
    long getId();
    double getHeight();
    double getWeight();
    Date getDate();
    long getUserID();
    double getImc();
}
