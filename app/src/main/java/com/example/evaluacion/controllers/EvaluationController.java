package com.example.evaluacion.controllers;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.widget.Toast;

import com.example.evaluacion.MainActivity;
import com.example.evaluacion.RegisterActivity;
import com.example.evaluacion.dao.EvaluationDao;
import com.example.evaluacion.library.GymAppDatabase;
import com.example.evaluacion.models.Evaluation;
import com.example.evaluacion.models.EvaluationEntity;
import com.example.evaluacion.models.EvaluationMapper;
import com.example.evaluacion.models.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EvaluationController {

    private Context ctx;
    private EvaluationDao evaluationDao;
    private EvaluationMapper evaluationMapper;

    public EvaluationController(Context ctx) {

        this.ctx = ctx;
        this.evaluationDao = GymAppDatabase.getInstance(ctx).evaluationDao();
    }

    public void register(Evaluation evaluation){
        EvaluationMapper mapper = new EvaluationMapper(evaluation);
        EvaluationEntity newEvaluation = mapper.toEntity();
        evaluationDao.insert(newEvaluation);
        ((Activity) ctx).onBackPressed();
    }

    public void delete(long id){
        DialogInterface.OnClickListener dialogClickListener = (Dialog, which) ->{
            switch (which){
                case DialogInterface.BUTTON_POSITIVE:
                    try{
                        evaluationDao.delete(id);
                        ((Activity) ctx).onBackPressed();
                    }catch(Error error){
                        error.printStackTrace();
                        Toast.makeText(this.ctx, "error al eliminar la evaluacion", Toast.LENGTH_SHORT).show();
                    }

                    break;
                case DialogInterface.BUTTON_NEGATIVE:
                    break;
            }
        };

        AlertDialog.Builder builder = new AlertDialog.Builder(this.ctx);
        builder.setMessage("estas seguro de eliminar la evaluacion ?")
                .setPositiveButton("Si", dialogClickListener)
                .setNegativeButton("No", dialogClickListener)
                .show();


    }

    public List<Evaluation> getAll(){
        AuthController authController = new AuthController(ctx);
        User user = authController.getUserSession();
        List<EvaluationEntity> evaluationEntityList = evaluationDao.findAll(user.getId());
        List<Evaluation> evaluationList = new ArrayList<>();

        for (EvaluationEntity evaluationEntity : evaluationEntityList ){
            EvaluationMapper mapper = new EvaluationMapper(evaluationEntity);
            Evaluation evaluation = mapper.toBase();
            evaluationList.add(evaluation);
        }

        return evaluationList;
    }
    public List<Evaluation> getRange(Date from, Date to) {
        AuthController authController = new AuthController(ctx);
        User user = authController.getUserSession();
        List<EvaluationEntity> evaluationEntityList = evaluationDao.findByRange(from, to, user.getId());
        List<Evaluation> evaluationList = new ArrayList<>();

        for (EvaluationEntity evaluationEntity : evaluationEntityList) {
            EvaluationMapper mapper = new EvaluationMapper(evaluationEntity);
            Evaluation evaluation = mapper.toBase();
            evaluationList.add(evaluation);
        }
        return evaluationList;
    }
}
