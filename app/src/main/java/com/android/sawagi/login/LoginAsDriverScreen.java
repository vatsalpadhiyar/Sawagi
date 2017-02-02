package com.android.sawagi.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.sawagi.ForgotPasswordScreen;
import com.android.sawagi.R;
import com.android.sawagi.SplashScreen;

public class LoginAsDriverScreen extends AppCompatActivity implements View.OnClickListener {

    private Toolbar toolbar;
    private TextView mTitle, txtShow, txtForgotPwd, btnLogin;
    private EditText editPhoneNo, editPassword;
    private LinearLayout layoutShow;
    private TextInputLayout inputLayoutPhone, inputLayoutpassword;
    boolean isShow = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_as_driver_screen);

        //Initialize Toolbar
        initToolBar();

        //get Id of declare variables
        txtShow = (TextView) findViewById(R.id.driver_login_txtShow);
        txtForgotPwd = (TextView) findViewById(R.id.driver_login_txtForgotPassword);
        btnLogin = (TextView) findViewById(R.id.driver_login_btnLogin);
        editPhoneNo = (EditText) findViewById(R.id.driver_login_editPhoneNumber);
        editPassword = (EditText) findViewById(R.id.driver_login_editPassword);
        layoutShow = (LinearLayout) findViewById(R.id.driver_login_layoutShow);
        inputLayoutPhone = (TextInputLayout) findViewById(R.id.driver_login_layout_phone);
        inputLayoutpassword = (TextInputLayout) findViewById(R.id.driver_login_layout_password);


        //set Typeface
        txtShow.setTypeface(SplashScreen.Roboto_Regular);
        txtForgotPwd.setTypeface(SplashScreen.Roboto_Regular);
        btnLogin.setTypeface(SplashScreen.Roboto_Regular);
        editPhoneNo.setTypeface(SplashScreen.Roboto_Regular);
        editPassword.setTypeface(SplashScreen.Roboto_Regular);
        inputLayoutPhone.setTypeface(SplashScreen.Roboto_Regular);
        inputLayoutpassword.setTypeface(SplashScreen.Roboto_Regular);


        //set Button OnClickListener
        btnLogin.setOnClickListener(this);
        txtForgotPwd.setOnClickListener(this);
        layoutShow.setOnClickListener(this);
    }

    public void initToolBar() {
        toolbar = (Toolbar) findViewById(R.id.driver_toolbar);

        setSupportActionBar(toolbar);

        // Remove default title text
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        mTitle = (TextView) toolbar.findViewById(R.id.driver_toolbar_title);
        mTitle.setTypeface(SplashScreen.Roboto_Regular);

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
            case R.id.driver_login_btnLogin:
                break;
            case R.id.driver_login_txtForgotPassword:
                startActivity(new Intent(LoginAsDriverScreen.this, ForgotPasswordScreen.class));
                break;
            case R.id.driver_login_layoutShow:
                if (isShow) {
                    isShow = false;
                    // show password
                    editPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                } else {
                    isShow = true;
                    // hide password
                    editPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }
                break;
            default:
                break;
        }
    }
}
