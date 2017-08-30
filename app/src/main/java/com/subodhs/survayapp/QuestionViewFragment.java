package com.subodhs.survayapp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.subodhs.survayapp.Questions.QuestionsContent;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;


/**
 * A fragment with view to display question
 */
public class QuestionViewFragment extends Fragment implements View.OnClickListener {
    private static final String QUESTION_NUMBER = "question_number";
    QuestionsContent.QuestionsBean questionsBean;
    LinearLayout mAnswerLayout;
    Button mSubmitButton;
    Communication comm;

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
        questionsBean = SurveyActivity.QUESTIONS.get(getArguments().getInt(QUESTION_NUMBER));
        View rootView = inflater.inflate(R.layout.fragment_question_view, container, false);
        TextView textView = (TextView) rootView.findViewById(R.id.questionText);
        mAnswerLayout = (LinearLayout) rootView.findViewById(R.id.answerLayout);
        mSubmitButton = (Button) rootView.findViewById(R.id.submitButton);
        comm = (Communication) getActivity();
        mSubmitButton.setOnClickListener(this);
        if (questionsBean.isCompulsary()) {
            textView.setText(questionsBean.getText() + " *");

        } else textView.setText(questionsBean.getText());

        switch (questionsBean.getType()) {
            case "scale":
                ((TextView) rootView.findViewById(R.id.answerType)).setText("Drag on bar to select");
                final View answerOptionView = getActivity().getLayoutInflater().inflate(R.layout.scale_option, null);
                SeekBar mSeekBar = (SeekBar) answerOptionView.findViewById(R.id.seekBar);
                mSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        ((TextView) answerOptionView.findViewById(R.id.rangeValue)).setText(progress + "");
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
            case "MCQ":
                if (questionsBean.isSingle()) {
                    ((TextView) rootView.findViewById(R.id.answerType)).setText("Select one option from below");
                    final View answerRadioView = getActivity().getLayoutInflater().inflate(R.layout.radiogroup_view, null);
                    RadioGroup radioGroup = (RadioGroup) answerRadioView.findViewById(R.id.radioGroupView);

                    List<String> optionList = questionsBean.getAnswers();
                    int listSize = optionList.size();
                    for (int i = 0; i < listSize; i++) {
                        View radioItem = getActivity().getLayoutInflater().inflate(R.layout.radio_button, null);
                        RadioButton radioButton = (RadioButton) radioItem.findViewById(R.id.radioButtonId);
                        radioButton.setId(View.generateViewId());
                        radioButton.setText(optionList.get(i));
                        radioGroup.addView(radioItem);
                    }
                    mAnswerLayout.addView(answerRadioView);
                } else {
                    ((TextView) rootView.findViewById(R.id.answerType)).setText("Select options from below");
                }
                break;
            case "text":
                final View answerTextView = getActivity().getLayoutInflater().inflate(R.layout.text_view, null);
                ((TextView) rootView.findViewById(R.id.answerType)).setText("Enter the answer below");
                EditText answerText = (EditText) answerTextView.findViewById(R.id.answerTextId);
                mAnswerLayout.addView(answerTextView);
                break;

            default:
                break;
        }

        return rootView;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.submitButton:
                boolean flag = true;
                JSONObject jsonObject = new JSONObject();
                try {
                    View view = getView();
                    jsonObject.put("question", questionsBean.getText());
                    if (questionsBean.getType().equals("scale")) {
                        int num = ((SeekBar) view.findViewById(R.id.seekBar)).getProgress();
                        jsonObject.put("answer", num);
                    } else if (questionsBean.getType().equals("text")) {
                        String ans = ((EditText) view.findViewById(R.id.answerTextId)).getText().toString().trim();
                        if (ans.length() == 0 && questionsBean.isCompulsary()) {
                            flag = false;
                        }
                        jsonObject.put("answer", ans);
                    } else if (questionsBean.getType().equals("MCQ")) {
                        int id = ((RadioGroup) view.findViewById(R.id.radioGroupView)).getCheckedRadioButtonId();
                        System.out.println("radio button ans" + id);
                        if (id == -1) {
                            flag = false;
                        } else {
                            String ans = ((RadioButton) view.findViewById(id)).getText().toString();
                            jsonObject.put("answer", ans);
                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                if (flag) {
                    comm.addResponse(jsonObject);
                    SurveyActivity.mViewPager.setCurrentItem(getArguments().getInt(QUESTION_NUMBER) + 1);
                    if ((getArguments().getInt(QUESTION_NUMBER) + 1) == SurveyActivity.QUESTIONS.size()) {
                        comm.sendData();
                    }
                } else {
                    Toast.makeText(getActivity(), "Question is compulsory", Toast.LENGTH_SHORT).show();
                }
                break;
            default:
                break;
        }
    }

    /*
    * Communication with Activity from Fragment using the interface*/
    public interface Communication {
        /*
        * add one answer object to the answer array in Survey Activity */
        public void addResponse(JSONObject singleQuestionObject);

        /*
        * To tell the Survey Activity that the questions ended*/
        public void sendData();

    }
}
