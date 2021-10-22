package com.example.evaluacion;

import androidx.appcompat.app.AppCompatActivity;

import com.example.evaluacion.controllers.AuthController;
import com.google.android.material.textfield.TextInputLayout;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;


public class LoginActivity extends AppCompatActivity {

    private Button btnLogin, btnRegister;
    private TextInputLayout tilUsername, tilPassword;
    private AuthController authController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnRegister = findViewById(R.id.activity_login_btn_register);
        btnLogin = findViewById(R.id.activity_login_btn_log);
        tilUsername = findViewById(R.id.activity_login_field_Username);
        tilPassword = findViewById(R.id.activity_login_field_password);

        authController = new AuthController(this);

        btnLogin.setOnClickListener(view -> {
            Toast.makeText(view.getContext(), "Iniciando sesión", Toast.LENGTH_SHORT).show();
            String username = tilUsername.getEditText().getText().toString();
            String password = tilPassword.getEditText().getText().toString();

            boolean userNameValid = !username.isEmpty();
            boolean passwordValid = !password.isEmpty();

            if (!userNameValid) {
                tilUsername.setError("Campo requerido");
            } else {
                tilUsername.setError(null);
                tilUsername.setErrorEnabled(false);
            }
            if (!passwordValid) {
                tilPassword.setError("Campo requerido");
            } else {
                tilPassword.setError(null);
                tilPassword.setErrorEnabled(false);
            }

            if (userNameValid && passwordValid) {
                AuthController controller = new AuthController(view.getContext());
                controller.login(username, password);
            } else {
                Toast.makeText(view.getContext(), "Campos inválidos", Toast.LENGTH_SHORT).show();
            }
        });

        btnRegister.setOnClickListener(view -> {
            Intent i = new Intent(view.getContext(), RegisterActivity.class);
            startActivity(i);
            finish();
        });
    }
}