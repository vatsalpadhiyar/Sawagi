package com.android.sawagi.register;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.sawagi.R;
import com.android.sawagi.SplashScreen;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterScreen extends AppCompatActivity implements View.OnClickListener {

    private Toolbar toolbar;
    private TextView mTitle, txtCode, btnNext;
    private EditText editPhoneNo;
    private LinearLayout layoutCode;
    private TextInputLayout inputLayoutPhone;
    private FirebaseAuth auth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_screen);

        //Initialize Toolbar
        initToolBar();

        //get Id of declare variables
        txtCode = (TextView) findViewById(R.id.register_txt_Code);
        btnNext = (TextView) findViewById(R.id.register_btnNext);
        editPhoneNo = (EditText) findViewById(R.id.register_editPhoneNumber);
        layoutCode = (LinearLayout) findViewById(R.id.register_layout_Code);
        inputLayoutPhone = (TextInputLayout) findViewById(R.id.register_layout_phone);

        //set Typeface
        txtCode.setTypeface(SplashScreen.Roboto_Regular);
        btnNext.setTypeface(SplashScreen.Roboto_Regular);
        editPhoneNo.setTypeface(SplashScreen.Roboto_Regular);
        inputLayoutPhone.setTypeface(SplashScreen.Roboto_Regular);

        //set Button OnClickListener
        btnNext.setOnClickListener(this);
        layoutCode.setOnClickListener(this);

    }

    public void initToolBar() {
        toolbar = (Toolbar) findViewById(R.id.register_toolbar);

        setSupportActionBar(toolbar);

        // Remove default title text
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        mTitle = (TextView) toolbar.findViewById(R.id.register_toolbar_title);
        mTitle.setTypeface(SplashScreen.Roboto_Regular);
        mTitle.setText("Register");

        toolbar.setNavigationIcon(R.drawable.ic_back);
        toolbar.setNavigationOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //Finish Current Screen and Go Back to the Previous Screen
                        finish();
                    }
                }

        );
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.register_btnNext:
                //Open Activation Screen
                startActivity(new Intent(RegisterScreen.this, ActivationScreen.class));
                break;
            case R.id.register_layout_Code:
                break;
            default:
                break;
        }
    }
}
