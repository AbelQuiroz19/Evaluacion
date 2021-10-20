package com.example.evaluacion;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import com.example.evaluacion.controllers.AuthController;
import com.example.evaluacion.controllers.EvaluationController;
import com.example.evaluacion.models.Evaluation;
import com.example.evaluacion.models.User;
import com.example.evaluacion.ui.DatePickerFragment;
import com.google.android.material.textfield.TextInputLayout;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class NewEvaluationActivity extends AppCompatActivity {

    private Button btnNewEvaluationRegister, btnGoBack;
    private TextInputLayout tilNewEvaluationDate,tilNewEvaluationWeight, tilNewEvaluationHeight;
    private final String DATE_PATTERN = "yyyy-MM-dd";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_evaluation);

        tilNewEvaluationDate = findViewById(R.id.activity_new_evaluation_field_date);
        tilNewEvaluationWeight = findViewById(R.id.activity_new_evaluation_field_weight);
        tilNewEvaluationHeight = findViewById(R.id.activity_new_evaluation_field_height);
        btnNewEvaluationRegister = findViewById(R.id.activity_new_evaluation_btn_register);
        btnGoBack =  findViewById(R.id.activity_new_evaluation_btn_goBack);

        tilNewEvaluationDate.getEditText().setOnClickListener(view -> {
            DatePickerFragment.showDatePickerDialog(this, tilNewEvaluationDate, new Date());
        });

        btnNewEvaluationRegister.setOnClickListener( view -> {
            String date = tilNewEvaluationDate.getEditText().getText().toString();
            String weight = tilNewEvaluationWeight.getEditText().getText().toString();
            String Height = tilNewEvaluationHeight.getEditText().getText().toString();

            SimpleDateFormat dateFormatter = new SimpleDateFormat(DATE_PATTERN);

            Date dateDate = null;
            try {
                dateDate = dateFormatter.parse(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            AuthController authController = new AuthController(view.getContext());

            User user = authController.getUserSession();

            double dobleHeight = Double.parseDouble(Height);

            double dobleWeight = Double.parseDouble(weight);

            double imc = dobleWeight / ( dobleHeight * dobleHeight);

            Evaluation evaluation = new Evaluation(dobleHeight, dobleWeight, dateDate, user.getId(), imc);

            EvaluationController controller = new EvaluationController(view.getContext());

            controller.register(evaluation);

            Toast.makeText(view.getContext(), "Registrando", Toast.LENGTH_SHORT).show();
        });

        btnGoBack.setOnClickListener( view -> {
            super.onBackPressed();
        });
    }
}