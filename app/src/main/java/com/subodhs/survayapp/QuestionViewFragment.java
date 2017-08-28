package com.subodhs.survayapp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A fragment with view to display question
 */
public class QuestionViewFragment extends Fragment {
    private static final String QUESTION_NUMBER = "question_number";

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
        View rootView=inflater.inflate(R.layout.fragment_question_view, container, false);
        TextView textView = (TextView) rootView.findViewById(R.id.section_label);
        textView.setText(getString(R.string.section_format, getArguments().getInt(QUESTION_NUMBER)));
        return rootView;
    }

}
