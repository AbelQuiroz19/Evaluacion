package com.example.evaluacion.models;

import java.util.Date;

public interface IUser {
    long getId();
    String getFirstName();
    String getLastName();
    String getUsername();
    Date getBirthday();
    String getPassword();

}
