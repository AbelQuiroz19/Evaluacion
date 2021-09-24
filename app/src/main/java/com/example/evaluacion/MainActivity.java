package com.example.evaluacion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btnConsult;
    private Button btnInsert;
    private Button btnClose;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnConsult = findViewById(R.id.main_activity_btn_consult);

        btnConsult.setOnClickListener(view -> {
            Toast.makeText(view.getContext(), "Moviendo a consultar", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(view.getContext(), ConsultActivity.class);
            startActivity(i);
        });

        btnInsert = findViewById(R.id.main_activity_btn_insert);


        btnInsert.setOnClickListener(view -> {
            Toast.makeText(view.getContext(), "Moviendo a ingresar", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(view.getContext(), HistoryActivity.class);
            startActivity(i);

        });

        btnClose = findViewById(R.id.main_activity_btn_close);

        btnClose.setOnClickListener(view -> {
            Toast.makeText(view.getContext(), "cerrando aplicacion", Toast.LENGTH_SHORT).show();
        });


    }

}