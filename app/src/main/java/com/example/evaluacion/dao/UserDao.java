package com.example.evaluacion.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.evaluacion.models.UserEntity;

@Dao
public interface UserDao {
    @Query("SELECT id, first_name, last_name, username, birthday, password FROM users WHERE username = :username LIMIT 1")
    UserEntity findByUsername (String username);

    @Insert
    long insert(UserEntity user);
}
