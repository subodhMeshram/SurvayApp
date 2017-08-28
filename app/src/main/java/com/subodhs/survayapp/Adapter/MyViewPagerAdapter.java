package com.subodhs.survayapp.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.subodhs.survayapp.QuestionViewFragment;
import com.subodhs.survayapp.SurveyActivity;

/**
 * Created by Subhodh on 8/28/2017.
 */

public class MyViewPagerAdapter extends FragmentStatePagerAdapter {
    public MyViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return QuestionViewFragment.newInstance(position + 1);
    }

    @Override
    public int getCount() {
        return 3;
    }
}
