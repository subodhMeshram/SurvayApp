package com.subodhs.survayapp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import com.subodhs.survayapp.Questions.QuestionsContent;

import java.util.List;


/**
 * A fragment with view to display question
 */
public class QuestionViewFragment extends Fragment {
    private static final String QUESTION_NUMBER = "question_number";
    QuestionsContent.QuestionsBean questionsBean;
    LinearLayout mAnswerLayout;
    Button mSubmitButton;

    public QuestionViewFragment() {

    }

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static QuestionViewFragment newInstance(int sectionNumber) {
        QuestionViewFragment fragment = new QuestionViewFragment();
        Bundle args = new Bundle();
        args.putInt(QUESTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        questionsBean=SurveyActivity.QUESTIONS.get(getArguments().getInt(QUESTION_NUMBER));
        View rootView=inflater.inflate(R.layout.fragment_question_view, container, false);
        TextView textView = (TextView) rootView.findViewById(R.id.questionText);
        mAnswerLayout= (LinearLayout) rootView.findViewById(R.id.answerLayout);
        mSubmitButton= (Button) rootView.findViewById(R.id.submitButton);
        if (questionsBean.isCompulsary()){
            textView.setText(questionsBean.getText()+" *");

        }else textView.setText(questionsBean.getText());

        switch (questionsBean.getType()){
            case "scale":
                final View answerOptionView=getActivity().getLayoutInflater().inflate(R.layout.scale_option,null);
                SeekBar mSeekBar= (SeekBar) answerOptionView.findViewById(R.id.seekBar);
                mSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        ((TextView)answerOptionView.findViewById(R.id.rangeValue)).setText(progress+"");
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {

                    }
                });
                mAnswerLayout.addView(answerOptionView);
                break;
            default:break;
        }

        return rootView;
    }

}
