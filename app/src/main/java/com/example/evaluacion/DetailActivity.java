package com.example.evaluacion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.evaluacion.controllers.EvaluationController;
import com.example.evaluacion.models.Evaluation;

import java.text.SimpleDateFormat;


public class DetailActivity extends AppCompatActivity {

    private Button btnDelete;
    private Button btnGoBack;
    private TextView tvId, tvWeight, tvHeight, tvDate, tvImc;
    private final String DATE_PATTERN = "yyyy-MM-dd";

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


        SimpleDateFormat dateFormatter = new SimpleDateFormat(DATE_PATTERN);

        String weight = dateFormatter.format(evaluation.getWeight());
        String Height = dateFormatter.format(evaluation.getHeight());
        String Imc =  dateFormatter.format(evaluation.getImc());

        tvId.setText(String.format("Evaluacion n°: ", evaluation.getId()));
        tvWeight.setText(weight);
        tvHeight.setText(Height);
        tvDate.setText(evaluation.getStringDate());
        tvImc.setText(Imc);

        btnDelete.setOnClickListener(view -> {
            EvaluationController controller = new EvaluationController(view.getContext());
            controller.delete(evaluation.getId());
        });


        btnGoBack.setOnClickListener(view -> {
            super.onBackPressed();
        });
    }
}