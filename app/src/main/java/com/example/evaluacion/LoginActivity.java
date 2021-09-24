package com.example.evaluacion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private Button btnLogin;
    private Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnLogin = findViewById(R.id.activity_login_btn_log);

        btnLogin.setOnClickListener(view -> {
                Toast.makeText(view.getContext(), "Iniciando sesion", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(view.getContext(), MainActivity.class);
                startActivity(i);
        });

        btnRegister =findViewById(R.id.activity_login_btn_register);

        btnRegister.setOnClickListener(view -> {
            Toast.makeText(view.getContext(), "Ingresando a registro", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(view.getContext(), RegisterActivity.class);
            startActivity(i);
        });
    }
}