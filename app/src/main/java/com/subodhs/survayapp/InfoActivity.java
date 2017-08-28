package com.subodhs.survayapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class InfoActivity extends AppCompatActivity {
    Button mLetsGo;
    EditText mName;
    EditText mEmailId;
    Spinner mGender;
    public static final String NAME_PATTERN = "^[ A-Za-z]+$";
    public static final String EMAIL_PATTERN = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    public static final String NAME = "name";
    public static final String EMAIL = "email";
    public static final String GENDER = "gender";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mLetsGo = (Button) findViewById(R.id.letsGoButton);
        mName = (EditText) findViewById(R.id.personName);
        mEmailId = (EditText) findViewById(R.id.personEmail);
        mGender = (Spinner) findViewById(R.id.genderSpinner);
        mLetsGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(InfoActivity.this,SurveyActivity.class));
                /*String name, email, gender;
                name = mName.getText().toString().trim();
                email = mEmailId.getText().toString().trim();
                gender = mGender.getSelectedItem().toString();
                boolean validationFlag = true;
                if (name.length() == 0) {
                    mName.setError("Enter Your Name");
                    validationFlag = false;
                } else if (!name.matches(NAME_PATTERN)) {
                    mName.setError("Enter Proper Name");
                    validationFlag = false;
                }
                if (email.length() == 0) {
                    mEmailId.setError("Enter Your Email ID");
                    validationFlag = false;
                } else if (!email.matches(EMAIL_PATTERN)) {
                    mEmailId.setError("Enter Proper Email ID");
                    validationFlag = false;
                }
                if (validationFlag) {
                    Intent intent = new Intent(InfoActivity.this, SurveyActivity.class);
                    intent.putExtra(NAME,name);
                    intent.putExtra(EMAIL,email);
                    intent.putExtra(GENDER,gender);
                    startActivity(intent);
                }
*/
                finish();
            }
        });
    }

}
