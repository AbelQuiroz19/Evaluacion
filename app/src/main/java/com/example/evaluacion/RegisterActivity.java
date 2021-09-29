package com.example.evaluacion;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import com.example.evaluacion.ui.DatePickerFragment;
import com.google.android.material.textfield.TextInputLayout;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class RegisterActivity extends AppCompatActivity {

    private TextInputLayout tilFirstName, tilLastName, tilEmail, tilPassword, tilBirthday;
    private Button btnRegister;

    private final String DATE_PATTERN = "yyyy-MM-dd";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        tilFirstName = findViewById(R.id.activity_register_field_name);
        tilLastName = findViewById(R.id.activity_register_field_apellido);
        tilEmail = findViewById(R.id.activity_register_field_email);
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

            // TODO: Implementar validaciones

            SimpleDateFormat dateFormatter = new SimpleDateFormat(DATE_PATTERN);

            Date birthdayDate = null;
            try {
                birthdayDate = dateFormatter.parse(birthday);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            User user = new User(firstName, lastName, email, birthdayDate);
            user.setPassword(password);

            AuthController controller = new AuthController(view.getContext());

            controller.register(user);
        });


    }
}