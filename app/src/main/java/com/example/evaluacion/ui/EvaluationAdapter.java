package com.example.evaluacion.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.evaluacion.R;
import com.example.evaluacion.models.Evaluation;

import java.io.Serializable;
import java.util.List;

public class EvaluationAdapter extends BaseAdapter {
    private Context ctx;
    private List<Evaluation> evaluationList;

    public EvaluationAdapter(Context ctx, List<Evaluation> evaluationList) {
        this.ctx = ctx;
        this.evaluationList = evaluationList;
    }

    @Override
    public int getCount() {
        return evaluationList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = LayoutInflater.from(ctx);

        view = inflater.inflate(R.layout.item_evaluation, null);

        Evaluation evaluation = evaluationList.get(i);

        TextView tvHeight = view.findViewById(R.id.item_evaluation_tv_Height);
        TextView tvId = view.findViewById(R.id.item_evaluation_tv_id);
        TextView tvWeight = view.findViewById(R.id.item_evaluation_tv_Weight);

        tvId.setText(Long.toString(evaluation.getId()));
        tvHeight.setText(evaluation.getHeight());
        tvWeight.setText(evaluation.getWeight());

        return view;

    }
}
