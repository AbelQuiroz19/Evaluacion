package com.example.evaluacion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.evaluacion.controllers.AuthController;
import com.example.evaluacion.controllers.EvaluationController;
import com.example.evaluacion.models.Evaluation;
import com.example.evaluacion.ui.DatePickerFragment;
import com.example.evaluacion.ui.EvaluationAdapter;
import com.google.android.material.textfield.TextInputLayout;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private Button btnConsult;
    private Button btnInsert;
    private Button btnClose;
    private TextInputLayout tilDateFrom, tilDateTo;
    private ListView LvEvaluations;
    private AuthController authController;
    private EvaluationController evaluationController;
    private TextView tvClearFilter;
    private final String DATE_PATTERN = "yyyy-MM-dd";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LvEvaluations = findViewById(R.id.activity_main_lv_evaluations);
        btnConsult = findViewById(R.id.main_activity_btn_consult);
        tilDateFrom = findViewById(R.id.activity_main_Date_from);
        tilDateTo = findViewById(R.id.activity_main_Date_to);
        btnClose = findViewById(R.id.main_activity_btn_close);
        tvClearFilter = findViewById(R.id.activity_main_clear_filter);

        authController = new AuthController(this);
        evaluationController = new EvaluationController(this);

        List<Evaluation> evaluationList = evaluationController.getAll();

        EvaluationAdapter adapter = new EvaluationAdapter(this, evaluationList);

        LvEvaluations.setAdapter(adapter);

        LvEvaluations.setOnItemClickListener(((adapterView, view, index, id) -> {

            Evaluation evaluation = evaluationList.get(index);

            Intent i = new Intent(view.getContext(), DetailActivity.class);
            i.putExtra("evaluation", evaluation);
            view.getContext().startActivity(i);

        }));

        btnInsert = findViewById(R.id.main_activity_btn_insert);


        btnInsert.setOnClickListener(view -> {
            Toast.makeText(view.getContext(), "Moviendo a ingresar", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(view.getContext(), NewEvaluationActivity.class);
            startActivity(i);

        });

        tilDateFrom.getEditText().setOnClickListener(view -> {
            DatePickerFragment.showDatePickerDialog(this, tilDateFrom, new Date());
        });

        tilDateTo.getEditText().setOnClickListener(view -> {
            DatePickerFragment.showDatePickerDialog(this, tilDateTo, new Date());
        });

        btnConsult.setOnClickListener(view -> {
            String fromStr = tilDateFrom.getEditText().getText().toString();
            String toStr = tilDateTo.getEditText().getText().toString();

            boolean validFrom = !fromStr.isEmpty();
            boolean validTo = !toStr.isEmpty();

            if (validFrom && validTo){
                SimpleDateFormat dateFormatter = new SimpleDateFormat(DATE_PATTERN);

                try {
                   Date from = dateFormatter.parse(fromStr);
                   Date to = dateFormatter.parse(toStr);

                    List<Evaluation> evaluationRangeList = evaluationController.getRange(from, to);
                    EvaluationAdapter rangeAdapter = new EvaluationAdapter(this, evaluationRangeList);

                    LvEvaluations.setAdapter(rangeAdapter);

                    LvEvaluations.setOnItemClickListener(((adapterView, rangeView, index, id) -> {

                        Evaluation evaluation = evaluationRangeList.get(index);

                        Intent i = new Intent(rangeView.getContext(), DetailActivity.class);
                        i.putExtra("evaluation", evaluation);
                        rangeView.getContext().startActivity(i);

                    }));


                } catch (ParseException e) {
                    e.printStackTrace();
                }


            }
        });


        btnClose.setOnClickListener(view -> { authController.logout(); });

        tvClearFilter.setOnClickListener(view ->{
            LvEvaluations.setAdapter(adapter);
        });


    }

    @Override
    protected void onResume(){
        super.onResume();
        List<Evaluation> evaluationList = evaluationController.getAll();
        EvaluationAdapter adapter = new EvaluationAdapter(this, evaluationList);

        LvEvaluations.setAdapter(adapter);

        LvEvaluations.setOnItemClickListener(((adapterView, view, index, id) -> {

            Evaluation evaluation = evaluationList.get(index);

            Intent i = new Intent(view.getContext(), DetailActivity.class);
            i.putExtra("evaluation", evaluation);
            view.getContext().startActivity(i);

        }));

    }

}