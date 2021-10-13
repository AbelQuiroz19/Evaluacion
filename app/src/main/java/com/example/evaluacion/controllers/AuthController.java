package com.example.evaluacion.controllers;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;
import android.content.SharedPreferences;
import android.util.Log;

import com.example.evaluacion.LoginActivity;
import com.example.evaluacion.MainActivity;
import com.example.evaluacion.dao.UserDao;
import com.example.evaluacion.library.BCrypt;
import com.example.evaluacion.library.GymAppDatabase;
import com.example.evaluacion.models.User;
import com.example.evaluacion.models.UserEntity;
import com.example.evaluacion.models.UserMapping;

import java.util.Date;


public class AuthController {
    private final String KEY_USER_ID = "userid";
    private final String KEY_USERNAME = "username";
    private final String KEY_FIRST_NAME = "userFirstName";
    private final String KEY_LAST_NAME = "userLastName";

    private Context ctx;
    private UserDao userdao;
    private SharedPreferences preferences;

    public AuthController(Context ctx) {
        this.ctx = ctx;
        int PRIVATE_MODE = 0;
        String PREF_NAME = "GymAppPref";
        this.preferences = ctx.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        this.userdao = GymAppDatabase.getInstance(ctx).userDao();
    }

    private void setUserSession(User user){
        SharedPreferences.Editor editor = this.preferences.edit();
        editor.putLong(KEY_USER_ID, user.getId());
        editor.putString(KEY_USERNAME, user.getUsername());
        editor.putString(KEY_FIRST_NAME, user.getFirstName());
        editor.putString(KEY_LAST_NAME, user.getLastName());
        editor.apply();

    }

    public User getUserSession(){
        long id = preferences.getLong(KEY_USER_ID,0);
        String firstName = preferences.getString(KEY_FIRST_NAME, "");
        String lastName = preferences.getString(KEY_LAST_NAME, "");
        String username = preferences.getString(KEY_USERNAME, "");

        User user = new User(firstName, lastName, username, new Date());
        user.setId(id);

        return user;
    }

    public void CheckUserSession(){
        long id = preferences.getLong(KEY_USER_ID, 0);
        if (id != 0){
            Intent i = new Intent(ctx, MainActivity.class);
            ctx.startActivity(i);
            ((Activity) ctx).finish();
        }
    }

    public void register(User user) {
        String hashedPassword = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
        user.setPassword(hashedPassword);

        UserEntity userEntity = new UserMapping(user).toEntity();

        userdao.insert(userEntity);

        Toast.makeText(ctx, String.format("Usuario %s registrado", user.getUsername()), Toast.LENGTH_SHORT).show();
        Intent i = new Intent(ctx, LoginActivity.class);
        ctx.startActivity(i);
    }

    public void login(String email, String password) {
        UserEntity userEntity = userdao.findByUsername(email);
        User user = new UserMapping(userEntity).toBase();

        if (BCrypt.checkpw(password, user.getPassword())) {
            setUserSession(user);
            Toast.makeText(ctx, String.format("Bienvenido %s", email), Toast.LENGTH_SHORT).show();
            Intent i = new Intent(ctx, MainActivity.class);
            ctx.startActivity(i);
            ((Activity) ctx).finish();
        } else {
            Toast.makeText(ctx, String.format("La contraseña es incorrecta", email), Toast.LENGTH_SHORT).show();
        }
    }
    public void logout() {
        SharedPreferences.Editor editor = this.preferences.edit();
        editor.clear();
        editor.apply();
        Toast.makeText(ctx, "Cerrando Sesión", Toast.LENGTH_SHORT).show();
        Intent i = new Intent(ctx, LoginActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        ctx.startActivity(i);
        ((Activity) ctx).finish();
    }

}