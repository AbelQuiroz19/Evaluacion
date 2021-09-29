package com.example.evaluacion;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;


public class AuthController {
    private Context ctx;

    public AuthController(Context ctx) {
        this.ctx = ctx;
    }

    public void register(User user) {
        Toast.makeText(ctx, String.format("Usuario %s registrado", user.getEmail()), Toast.LENGTH_SHORT).show();
        Intent i = new Intent(ctx, LoginActivity.class);
        ctx.startActivity(i);
    }

    public void login(String email, String password) {
        if (password.equals("123456")) {
            Toast.makeText(ctx, String.format("Bienvenido %s", email), Toast.LENGTH_SHORT).show();
            Intent i = new Intent(ctx, MainActivity.class);
            ctx.startActivity(i);
            ((Activity) ctx).finish();
        } else {
            Toast.makeText(ctx, String.format("La contraseña es incorrecta", email), Toast.LENGTH_SHORT).show();
        }
    }
}