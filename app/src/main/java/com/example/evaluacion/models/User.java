package com.example.evaluacion.models;

import java.util.Date;

public class User implements IUser {
    private long id;
    private String firstName;
    private String lastName;
    private String username;
    private Date birthday;
    private String password;
    private String height;

    public User(String firstName, String lastName, String username, Date birthday, String height) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.birthday = birthday;
        this.height = height;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getUsername() {
        return username;
    }

    public Date getBirthday() {
        return birthday;
    }

    public String getHeight() { return height; }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}