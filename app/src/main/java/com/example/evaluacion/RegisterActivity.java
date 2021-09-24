package com.example.evaluacion;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    private Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        btnRegister = findViewById(R.id.activity_register_btn_register);

        btnRegister.setOnClickListener(view -> {
            Toast.makeText(view.getContext(), "Registrando usuario", Toast.LENGTH_SHORT).show();
        });

    }
}