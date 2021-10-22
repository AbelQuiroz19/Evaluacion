package com.example.evaluacion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.evaluacion.controllers.AuthController;
import com.example.evaluacion.controllers.EvaluationController;
import com.example.evaluacion.models.Evaluation;
import com.example.evaluacion.models.User;

import java.text.SimpleDateFormat;


public class DetailActivity extends AppCompatActivity {

    private Button btnDelete;
    private Button btnGoBack;
    private TextView tvId, tvWeight, tvHeight, tvDate, tvImc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Evaluation evaluation = (Evaluation) getIntent().getSerializableExtra("evaluation");

        btnDelete = findViewById(R.id.activity_detail_btn_delete);
        btnGoBack = findViewById(R.id.activity_detail_btn_goback);
        tvId = findViewById(R.id.activity_detail_tv_id);
        tvHeight = findViewById(R.id.activity_detail_field_height);
        tvWeight = findViewById(R.id.activity_detail_field_weight);
        tvDate = findViewById(R.id.activity_detail_field_date);
        tvImc = findViewById(R.id.activity_detail_field_imc);

        String weightStr = Double.toString(evaluation.getWeight());
        String heightStr = Double.toString(evaluation.getHeight());
        String imcStr =  Double.toString(evaluation.getImc());

        tvId.setText(String.format("Evaluacion n°: ", evaluation.getId()));
        tvWeight.setText(weightStr);
        tvHeight.setText(heightStr);
        tvDate.setText(evaluation.getStringDate());
        tvImc.setText(imcStr);

        btnDelete.setOnClickListener(view -> {
            EvaluationController controller = new EvaluationController(view.getContext());
            controller.delete(evaluation.getId());
        });


        btnGoBack.setOnClickListener(view -> {
            super.onBackPressed();
        });
    }
}