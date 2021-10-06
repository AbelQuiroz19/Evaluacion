package com.example.evaluacion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.evaluacion.models.Evaluation;



public class DetailActivity extends AppCompatActivity {

    private Button btnDelete;
    private Button btnGoBack;
    private TextView TvId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Evaluation evaluation = (Evaluation) getIntent().getSerializableExtra("evaluation");

        btnDelete = findViewById(R.id.activity_detail_btn_delete);
        btnGoBack = findViewById(R.id.activity_detail_btn_goback);
        TvId = findViewById(R.id.activity_detail_tv_id);

        TvId.setText(Long.toString(evaluation.getId()));

        btnDelete.setOnClickListener(view -> {
            Toast.makeText(view.getContext(),"Eliminando...", Toast.LENGTH_SHORT).show();
        });


        btnGoBack.setOnClickListener(view -> {
            Intent i = new Intent(view.getContext(), MainActivity.class);
            startActivity(i);
            finish();
        });
    }
}