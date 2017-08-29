package com.subodhs.survayapp.Adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.subodhs.survayapp.Questions.QuestionAnswerContent;
import com.subodhs.survayapp.R;

import java.util.List;

/**
 * Created by Subhodh on 8/29/2017.
 */

public class SimpleItemRecyclerViewAdapter extends RecyclerView.Adapter<SimpleItemRecyclerViewAdapter.ViewHolder> {
    private final List<QuestionAnswerContent.QuestionAnswer> mValues;
    private QuestionAnswerContent.QuestionAnswer mItemResult;
    private Context context;

    public SimpleItemRecyclerViewAdapter(List<QuestionAnswerContent.QuestionAnswer> items,Context context) {
        mValues = items;
        this.context=context;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.question_answer_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mQuestion.setText(holder.mItem.questionText);
        holder.mAnswer.setText(holder.mItem.answerText);
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mQuestion;
        public final TextView mAnswer;
        public QuestionAnswerContent.QuestionAnswer mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mQuestion = (TextView) view.findViewById(R.id.questionText);
            mAnswer = (TextView) view.findViewById(R.id.answerText);
        }


    }
}
