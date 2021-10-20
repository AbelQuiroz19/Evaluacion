package com.example.evaluacion.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.evaluacion.models.EvaluationEntity;

import java.util.Date;
import java.util.List;

@Dao
public interface EvaluationDao {
    @Query("SELECT id,height, weight, date, imc, user_id FROM evaluations WHERE user_id = :userId")
    List<EvaluationEntity> findAll (long userId);

    @Query("SELECT id,height, weight, date, imc, user_id FROM evaluations WHERE user_id = :userId AND date BETWEEN :one AND :two")
    List<EvaluationEntity> findByRange (Date one, Date two, long userId);


    @Insert
    long insert(EvaluationEntity evaluation);

    @Query("DELETE FROM evaluations WHERE id = :id")
    void delete(long id);
}
