package com.example.evaluacion;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;
import com.example.evaluacion.ui.DatePickerFragment;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Date;

public class HistoryActivity extends AppCompatActivity {

    private Button btnHistory;
    private TextInputLayout tilHistory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        tilHistory = findViewById(R.id.activity_history_field_date);
        btnHistory = findViewById(R.id.activity_history_btn_hist);

        tilHistory.getEditText().setOnClickListener(view -> {
            DatePickerFragment.showDatePickerDialog(this, tilHistory, new Date());
        });

        btnHistory.setOnClickListener( view -> {
            Toast.makeText(view.getContext(), "Registrando imc", Toast.LENGTH_SHORT).show();
        });
    }
}