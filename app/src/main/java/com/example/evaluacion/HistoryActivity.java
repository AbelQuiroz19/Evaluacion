package com.example.evaluacion;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

public class HistoryActivity extends AppCompatActivity {

    private Button btnHistory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        btnHistory = findViewById(R.id.activity_history_btn_hist);

        btnHistory.setOnClickListener( view -> {
            Toast.makeText(view.getContext(), "Registrando imc", Toast.LENGTH_SHORT).show();
        });
    }
}