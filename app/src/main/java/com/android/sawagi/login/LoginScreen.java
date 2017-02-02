package com.android.sawagi.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.sawagi.ForgotPasswordScreen;
import com.android.sawagi.HomeScreen;
import com.android.sawagi.R;
import com.android.sawagi.SplashScreen;
import com.android.sawagi.register.RegisterScreen;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginScreen extends AppCompatActivity implements View.OnClickListener {

    private Toolbar toolbar;
    private TextView mTitle, txtShow, txtForgotPwd, btnLogin, btnCreateAccount, btnLoginDriver;
    private EditText editPhoneNo, editPassword;
    private LinearLayout layoutShow;
    private TextInputLayout inputLayoutPhone, inputLayoutpassword;
    boolean isShow = false;

    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);

        //Get Firebase auth instance
        auth = FirebaseAuth.getInstance();

        if (auth.getCurrentUser() != null) {
            Intent in = new Intent(LoginScreen.this, HomeScreen.class);
            in.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(in);
            finish();
        }

        //Initialize Toolbar
        initToolBar();

        //get Id of declare variables
        txtShow = (TextView) findViewById(R.id.login_txtShow);
        txtForgotPwd = (TextView) findViewById(R.id.login_txtForgotPassword);
        btnLogin = (TextView) findViewById(R.id.login_btnLogin);
        btnCreateAccount = (TextView) findViewById(R.id.login_btnCreateAccount);
        btnLoginDriver = (TextView) findViewById(R.id.login_btnLoginDriver);
        editPhoneNo = (EditText) findViewById(R.id.login_editPhoneNumber);
        editPassword = (EditText) findViewById(R.id.login_editPassword);
        layoutShow = (LinearLayout) findViewById(R.id.login_layoutShow);
        inputLayoutPhone = (TextInputLayout) findViewById(R.id.login_layout_phone);
        inputLayoutpassword = (TextInputLayout) findViewById(R.id.login_layout_password);


        //set Typeface
        txtShow.setTypeface(SplashScreen.Roboto_Regular);
        txtForgotPwd.setTypeface(SplashScreen.Roboto_Regular);
        btnLogin.setTypeface(SplashScreen.Roboto_Regular);
        btnCreateAccount.setTypeface(SplashScreen.Roboto_Regular);
        btnLoginDriver.setTypeface(SplashScreen.Roboto_Regular);
        editPhoneNo.setTypeface(SplashScreen.Roboto_Regular);
        editPassword.setTypeface(SplashScreen.Roboto_Regular);
        inputLayoutPhone.setTypeface(SplashScreen.Roboto_Regular);
        inputLayoutpassword.setTypeface(SplashScreen.Roboto_Regular);


        //set Button OnClickListener
        btnLogin.setOnClickListener(this);
        btnCreateAccount.setOnClickListener(this);
        btnLoginDriver.setOnClickListener(this);
        txtForgotPwd.setOnClickListener(this);
        layoutShow.setOnClickListener(this);

        auth = FirebaseAuth.getInstance();
    }

    public void initToolBar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);

        // Remove default title text
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        mTitle = (TextView) toolbar.findViewById(R.id.toolbar_title);
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
            case R.id.login_btnLogin:
                checkLogin();
                //Open Home Screen After successfull Login

                break;
            case R.id.login_btnCreateAccount:
                //Open Register Screen
                startActivity(new Intent(LoginScreen.this, RegisterScreen.class));
                break;
            case R.id.login_btnLoginDriver:
                //Open Login Driver Screen
                startActivity(new Intent(LoginScreen.this, LoginAsDriverScreen.class));
                break;
            case R.id.login_txtForgotPassword:
                //Open Forgot Password Screen
                startActivity(new Intent(LoginScreen.this, ForgotPasswordScreen.class));
                break;
            case R.id.login_layoutShow:
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

    private void checkLogin() {
        String email = editPhoneNo.getText().toString();
        final String password = editPassword.getText().toString();

        if (TextUtils.isEmpty(email)) {
            Toast.makeText(getApplicationContext(), "Enter email address!", Toast.LENGTH_SHORT).show();
            return;
        }

        if (TextUtils.isEmpty(password)) {
            Toast.makeText(getApplicationContext(), "Enter password!", Toast.LENGTH_SHORT).show();
            return;
        }

        //authenticate user
        auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(LoginScreen.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task){
                        if (!task.isSuccessful()) {
                            // there was an error
                            if (password.length() < 6) {
                                editPassword.setError(getString(R.string.minimum_password));
                            } else {
                                Toast.makeText(LoginScreen.this, getString(R.string.auth_failed), Toast.LENGTH_LONG).show();
                            }
                        } else {
                            Intent in = new Intent(LoginScreen.this, HomeScreen.class);
                            in.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                            startActivity(in);
                            finish();
                        }
                    }
                });
    }
}
