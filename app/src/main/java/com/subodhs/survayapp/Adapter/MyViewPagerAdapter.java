package com.subodhs.survayapp.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.subodhs.survayapp.QuestionViewFragment;
import com.subodhs.survayapp.Questions.QuestionsContent;
import com.subodhs.survayapp.SurveyActivity;

/**
 * A {@link FragmentStatePagerAdapter} that returns a fragment corresponding to
 * one of the question.
 */

public class MyViewPagerAdapter extends FragmentStatePagerAdapter {

    public MyViewPagerAdapter(FragmentManager fm) {
        super(fm);

    }

    @Override
    public Fragment getItem(int position) {
        //new Instance of QuestionViewFragment is created and returned to
        // instantiate the fragment of given page;
        return QuestionViewFragment.newInstance(position);
    }

    @Override
    public int getCount() {
        //returns the number of questions
        System.out.println(SurveyActivity.QUESTIONS.size());
        return SurveyActivity.QUESTIONS.size();
    }
}
