package com.example.evaluacion.models;

public class EvaluationMapper {
    private IEvaluation evaluation;

    public EvaluationMapper(IEvaluation evaluation) {
        this.evaluation = evaluation;
    }

    public Evaluation toBase(){
        Evaluation baseEvaluation = new Evaluation(
                this.evaluation.getHeight(),
                this.evaluation.getWeight(),
                this.evaluation.getDate(),
                this.evaluation.getUserID(),
                this.evaluation.getImc()
        );
        baseEvaluation.setId(this.evaluation.getId());
        return baseEvaluation;

    }
    public EvaluationEntity toEntity(){
        return new EvaluationEntity(
                this.evaluation.getId(),
                this.evaluation.getHeight(),
                this.evaluation.getWeight(),
                this.evaluation.getDate(),
                this.evaluation.getUserID(),
                this.evaluation.getImc()
        );
    }
}
