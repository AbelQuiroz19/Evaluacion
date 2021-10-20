package com.example.evaluacion;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import com.example.evaluacion.controllers.AuthController;
import com.example.evaluacion.models.User;
import com.example.evaluacion.ui.DatePickerFragment;
import com.google.android.material.textfield.TextInputLayout;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class RegisterActivity extends AppCompatActivity {

    private TextInputLayout tilFirstName, tilLastName, tilEmail, tilPassword, tilBirthday, tilHeight;
    private Button btnRegister;

    private final String DATE_PATTERN = "yyyy-MM-dd";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        tilHeight = findViewById(R.id.activity_register_field_height);
        tilFirstName = findViewById(R.id.activity_register_field_name);
        tilLastName = findViewById(R.id.activity_register_field_apellido);
        tilEmail = findViewById(R.id.activity_register_field_username);
        tilPassword = findViewById(R.id.activity_register_field_password);
        tilBirthday = findViewById(R.id.activity_register_field_birthday);
        btnRegister = findViewById(R.id.activity_register_btn_register);
        tilBirthday.getEditText().setOnClickListener(view -> {
            DatePickerFragment.showDatePickerDialog(this, tilBirthday, new Date());
        });

        btnRegister.setOnClickListener(view -> {
            String firstName = tilFirstName.getEditText().getText().toString();
            String lastName = tilLastName.getEditText().getText().toString();
            String email = tilEmail.getEditText().getText().toString();
            String password = tilPassword.getEditText().getText().toString();
            String birthday = tilBirthday.getEditText().getText().toString();
            String height = tilHeight.getEditText().getText().toString();

            boolean firstNameValid = !firstName.isEmpty();
            boolean lastNameValid = !lastName.isEmpty();
            boolean emailValid = !email.isEmpty();
            boolean passwordValid = !password.isEmpty();
            boolean birthdayValid = !birthday.isEmpty();
            boolean heightValid = !height.isEmpty();


            if (!firstNameValid) {
                tilFirstName.setError("Campo obligatorio");
            } else {
                tilFirstName.setError(null);
                tilFirstName.setErrorEnabled(false);
            }
            if (!lastNameValid) {
                tilLastName.setError("Campo obligatorio");
            } else {
                tilLastName.setError(null);
                tilLastName.setErrorEnabled(false);
            }
            if (!emailValid) {
                tilEmail.setError("Campo obligatorio");
            } else {
                tilEmail.setError(null);
                tilEmail.setErrorEnabled(false);
            }
            if (!passwordValid) {
                tilPassword.setError("Campo obligatorio");
            } else {
                tilPassword.setError(null);
                tilPassword.setErrorEnabled(false);
            }
            if (!birthdayValid) {
                tilBirthday.setError("Campo obligatorio");
            } else {
                tilBirthday.setError(null);
                tilBirthday.setErrorEnabled(false);
            }if (!heightValid) {
                tilHeight.setError("Campo obligatorio");
            } else {
                tilHeight.setError(null);
                tilHeight.setErrorEnabled(false);
            }


            if (firstNameValid && lastNameValid && emailValid && passwordValid && birthdayValid && heightValid) {
                SimpleDateFormat dateFormatter = new SimpleDateFormat(DATE_PATTERN);

                Date birthdayDate = null;
                try {
                    birthdayDate = dateFormatter.parse(birthday);
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                User user = new User(firstName, lastName, email, birthdayDate, height);
                user.setPassword(password);

                AuthController controller = new AuthController(view.getContext());

                controller.register(user);
            } else {

                Toast.makeText(view.getContext(), "Campos inválidos", Toast.LENGTH_SHORT).show();
            }
        });

    }
}