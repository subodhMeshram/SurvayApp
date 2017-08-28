package com.subodhs.survayapp;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.subodhs.survayapp.Adapter.MyViewPagerAdapter;
import com.subodhs.survayapp.Interface.GetQuestions;
import com.subodhs.survayapp.Questions.QuestionsContent;

import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SurveyActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener{

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private MyViewPagerAdapter mQuestionsPagerAdapter;

    public static final String BASE_URL="https://raw.githubusercontent.com/";
    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;
    ProgressBar progressBar;
    private ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_survey);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mQuestionsPagerAdapter = new MyViewPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mQuestionsPagerAdapter);
        progressBar= (ProgressBar) findViewById(R.id.progressBar);
        progressBar.setVisibility(View.VISIBLE);
        mViewPager.addOnPageChangeListener(this);


        Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL).
                addConverterFactory(GsonConverterFactory.create()).build();
        GetQuestions getMovies = retrofit.create(GetQuestions.class);
        retrofit2.Call<QuestionsContent> call = getMovies.all();
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Connecting...");
        progressDialog.setCancelable(false);
        progressDialog.show();
        call.enqueue(new Callback<QuestionsContent>() {
            @Override
            public void onResponse(retrofit2.Call<QuestionsContent> call, Response<QuestionsContent> response) {
                QuestionsContent questionsContent = response.body();
                parseQuestions(questionsContent);
                progressDialog.dismiss();
            }

            @Override
            public void onFailure(retrofit2.Call<QuestionsContent> call, Throwable t) {
                Toast.makeText(SurveyActivity.this, "Error in connecting to network", Toast.LENGTH_SHORT).show();
                progressDialog.dismiss();

            }
        });

    }

    private void parseQuestions(QuestionsContent questionsContent) {
        System.out.println(questionsContent.getIntro());
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        progressBar.setProgress(progressBar.getProgress()+1);

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }



}
