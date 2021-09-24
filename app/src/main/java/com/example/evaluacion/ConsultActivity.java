package com.example.evaluacion;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

public class ConsultActivity extends AppCompatActivity {
    private Button btnConsult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consult);

        btnConsult = findViewById(R.id.activity_consult_btn_consultt);

        btnConsult.setOnClickListener( view -> {
            Toast.makeText(view.getContext(), "Consultando Resultados", Toast.LENGTH_SHORT).show();
                });
    }
}