package com.android.sawagi;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.sawagi.login.LoginScreen;
import com.android.sawagi.register.CreateAccountScreen;

public class ForgotPasswordScreen extends AppCompatActivity implements View.OnClickListener {

    private Toolbar toolbar;
    private TextView mTitle, txtCode, btnReset, txtEmail, txtPassword;
    private EditText editPhoneNo;
    private LinearLayout layoutCode;
    private TextInputLayout inputLayoutPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password_screen);

        //Initialize Toolbar
        initToolBar();

        //get Id of declare variables
        txtCode = (TextView) findViewById(R.id.forgot_txt_Code);
        txtEmail = (TextView) findViewById(R.id.forgot_txtEmail);
        txtPassword = (TextView) findViewById(R.id.forgot_txtPassword);
        btnReset = (TextView) findViewById(R.id.forgot_btnReset);
        editPhoneNo = (EditText) findViewById(R.id.forgot_editPhoneNumber);
        layoutCode = (LinearLayout) findViewById(R.id.forgot_layout_Code);
        inputLayoutPhone = (TextInputLayout) findViewById(R.id.forgot_layout_phone);

        //set Typeface
        txtCode.setTypeface(SplashScreen.Roboto_Regular);
        txtEmail.setTypeface(SplashScreen.Roboto_Regular);
        txtPassword.setTypeface(SplashScreen.Roboto_Regular);
        btnReset.setTypeface(SplashScreen.Roboto_Regular);
        editPhoneNo.setTypeface(SplashScreen.Roboto_Regular);
        inputLayoutPhone.setTypeface(SplashScreen.Roboto_Regular);

        //set Button OnClickListener
        btnReset.setOnClickListener(this);
        layoutCode.setOnClickListener(this);


    }

    public void initToolBar() {
        toolbar = (Toolbar) findViewById(R.id.forgot_toolbar);

        setSupportActionBar(toolbar);

        // Remove default title text
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        mTitle = (TextView) toolbar.findViewById(R.id.forgot_toolbar_title);
        mTitle.setTypeface(SplashScreen.Roboto_Regular);
        mTitle.setText("Forgot Password");

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
            case R.id.forgot_btnReset:
                //Open Login Screen
                Intent in = new Intent(ForgotPasswordScreen.this, LoginScreen.class);
                in.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(in);
                finish();
                break;
            default:
                break;
        }
    }
}
