package com.example.evaluacion.models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity(tableName = "users", indices = {@Index(value = "username", unique = true)})
public class UserEntity  implements  IUser{
    @PrimaryKey(autoGenerate = true)
    private long id;

    @ColumnInfo(name = "first_name")
    private String firstName;

    @ColumnInfo(name = "last_name")
    private String lastName;

    @ColumnInfo(name = "username")
    private String username;

    @ColumnInfo(name = "birthday")
    private Date birthday;

    @ColumnInfo(name = "password")
    private String password;

    @ColumnInfo(name = "height")
    private String height;


    public UserEntity(long id, String firstName, String lastName, String username, Date birthday, String password, String height) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.birthday = birthday;
        this.password = password;
        this.height = height;
    }

    public long getId() {
        return id;
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

    public String getPassword() { return password; }

    public String getHeight() { return height; }

}
