package com.subodhs.survayapp;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.subodhs.survayapp.Adapter.SimpleItemRecyclerViewAdapter;
import com.subodhs.survayapp.Questions.QuestionAnswerContent;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Displaying result of questionnaire*/
public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        JSONObject answerObject;
        final String resultString = getIntent().getStringExtra(SurveyActivity.FINAL_JSON);
        try {
            answerObject = new JSONObject(resultString);
            ((TextView) findViewById(R.id.nameText)).setText(answerObject.getString(InfoActivity.NAME));
            ((TextView) findViewById(R.id.emailText)).setText(answerObject.getString(InfoActivity.EMAIL));
            ((TextView) findViewById(R.id.genderText)).setText(answerObject.getString(InfoActivity.GENDER));
            JSONArray answerArray = answerObject.getJSONArray("results");
            int count = answerArray.length();
            JSONObject tempAnswerObject;
            String question, answer;
            for (int i = 0; i < count; i++) {
                tempAnswerObject = answerArray.getJSONObject(i);
                question = tempAnswerObject.getString("question");
                answer = tempAnswerObject.getString("answer");
                QuestionAnswerContent.QuestionAnswer questionAnswer = new QuestionAnswerContent.QuestionAnswer(question, answer);
                QuestionAnswerContent.addItem(questionAnswer);
                System.out.println(questionAnswer.questionText);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        ((Button) findViewById(R.id.viewJsonButton)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*
                * Displaying Json*/
                AlertDialog.Builder builder = new AlertDialog.Builder(ResultActivity.this);
                builder.setTitle("JSON DATA");
                builder.setMessage(resultString);
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.show();
            }
        });
        View recyclerView = findViewById(R.id.resultList);
        assert recyclerView != null;
        setupRecyclerView((RecyclerView) recyclerView);
    }

    private void setupRecyclerView(@NonNull RecyclerView recyclerView) {
        recyclerView.setAdapter(new SimpleItemRecyclerViewAdapter(QuestionAnswerContent.ANSWER_LIST));

    }
}
