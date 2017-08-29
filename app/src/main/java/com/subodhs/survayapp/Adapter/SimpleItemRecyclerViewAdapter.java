package com.subodhs.survayapp.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.subodhs.survayapp.Questions.QuestionAnswerContent;
import com.subodhs.survayapp.R;

import java.util.List;

/**
 * Recycler view adapter to handle the
 */

public class SimpleItemRecyclerViewAdapter extends RecyclerView.Adapter<SimpleItemRecyclerViewAdapter.ViewHolder> {

    private final List<QuestionAnswerContent.QuestionAnswer> mValues;

    public SimpleItemRecyclerViewAdapter(List<QuestionAnswerContent.QuestionAnswer> items) {
        mValues = items;

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
        System.out.println(holder.mItem.questionText);
        holder.mAnswer.setText(holder.mItem.answerText);
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        final View mView;
        final TextView mQuestion;
        final TextView mAnswer;
        QuestionAnswerContent.QuestionAnswer mItem;

        ViewHolder(View view) {
            super(view);
            mView = view;
            mQuestion = (TextView) view.findViewById(R.id.questionText);
            mAnswer = (TextView) view.findViewById(R.id.answerText);
        }


    }
}
