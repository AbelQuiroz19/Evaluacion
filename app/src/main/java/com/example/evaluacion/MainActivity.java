package com.example.evaluacion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.evaluacion.models.Task;
import com.example.evaluacion.ui.DatePickerFragment;
import com.example.evaluacion.ui.TaskEvaluationAdapter;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private Button btnConsult;
    private Button btnInsert;
    private Button btnClose;
    private TextInputLayout tilDateOne, tilDateTwo;
    private ListView LvTasks;

    private List<Task> taskList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LvTasks = findViewById(R.id.activity_main_lv_tasks);
        btnConsult = findViewById(R.id.main_activity_btn_consult);
        tilDateOne = findViewById(R.id.DateOne);
        tilDateTwo = findViewById(R.id.DateTwo);

        for (int x = 0; x < 10; ++x) {
            Task newTask = new Task(String.format("Title %d", x), String.format("Description %d", x));
            newTask.setId(x);
            taskList.add(newTask);
        }

        TaskEvaluationAdapter adapter = new TaskEvaluationAdapter(this, taskList);

        LvTasks.setAdapter(adapter);

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