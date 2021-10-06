package com.example.evaluacion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.evaluacion.models.Evaluation;
import com.example.evaluacion.ui.DatePickerFragment;
import com.example.evaluacion.ui.EvaluationAdapter;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private Button btnConsult;
    private Button btnInsert;
    private Button btnClose;
    private TextInputLayout tilDateOne, tilDateTwo;
    private ListView LvEvaluations;

    private List<Evaluation> evaluationList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LvEvaluations = findViewById(R.id.activity_main_lv_evaluations);
        btnConsult = findViewById(R.id.main_activity_btn_consult);
        tilDateOne = findViewById(R.id.DateOne);
        tilDateTwo = findViewById(R.id.DateTwo);

        for (int x = 0; x < 10; ++x) {
            Evaluation newEvaluation = new Evaluation(String.format("Altura: %d", x), String.format("Peso: %d", x));
            newEvaluation.setId(x);
            evaluationList.add(newEvaluation);
        }

        EvaluationAdapter adapter = new EvaluationAdapter(this, evaluationList);

        LvEvaluations.setAdapter(adapter);

        LvEvaluations.setOnItemClickListener(((adapterView, view, index, id) -> {

            Evaluation evaluation = evaluationList.get(index);

            Intent i = new Intent(view.getContext(), DetailActivity.class);
            i.putExtra("evaluation", evaluation);
            view.getContext().startActivity(i);

        }));

        btnConsult.setOnClickListener(view -> {
            Toast.makeText(view.getContext(), "consultando", Toast.LENGTH_SHORT).show();
        });

        btnInsert = findViewById(R.id.main_activity_btn_insert);


        btnInsert.setOnClickListener(view -> {
            Toast.makeText(view.getContext(), "Moviendo a ingresar", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(view.getContext(), HistoryActivity.class);
            startActivity(i);

        });

        tilDateOne.getEditText().setOnClickListener(view -> {
            DatePickerFragment.showDatePickerDialog(this, tilDateOne, new Date());
        });

        tilDateTwo.getEditText().setOnClickListener(view -> {
            DatePickerFragment.showDatePickerDialog(this, tilDateTwo, new Date());
        });

        btnClose = findViewById(R.id.main_activity_btn_close);

        btnClose.setOnClickListener(view -> {
            Toast.makeText(view.getContext(), "cerrando aplicacion", Toast.LENGTH_SHORT).show();
        });


    }

}