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
import com.android.sawagi.sUtils;
import com.google.firebase.auth.FirebaseAuth;
import com.mobily.api.sms.entity.CommonResponseData;
import com.mobily.api.sms.utility.MobilyAPI;
import com.mobily.api.sms.utility.OnDataReceiveListner;
import com.mobily.api.sms.entity.Error;

import java.util.Random;

public class RegisterScreen extends AppCompatActivity implements View.OnClickListener {

    private static final String MOBILY_USERNAME = "962798310891";
    private static final String MOBILY_PASSWORD = "bas1982l";
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
                sendSMS();

                break;
            case R.id.register_layout_Code:
                break;
            default:
                break;
        }
    }

    private void sendSMS() {

        Random ran = new Random();
        String otp = "" + (100000 + ran.nextInt(900000));

        sUtils.log("otp :: " + otp );

        sUtils.saveOtp(getApplicationContext(), otp);

        MobilyAPI  mobilyAPI = new MobilyAPI(getApplicationContext(), MOBILY_USERNAME, MOBILY_PASSWORD);

        mobilyAPI.sendMessage("BARY",
                "Welcome! Your OTP is " + otp,
                editPhoneNo.getText().toString().trim(),
                "",
                "",
                "DELETEKEY",
                "ALIAS",
                new OnDataReceiveListner() {
                    @Override
                    public void onSuccess(Object object) {
                        sUtils.log("success");

                        CommonResponseData data = (CommonResponseData) object;
                        sUtils.log(data.getMessageEn());
                        sUtils.saveMobileNumber(getApplicationContext(), editPhoneNo.getText().toString().trim());
                        startActivity(new Intent(RegisterScreen.this, ActivationScreen.class));
                    }

                    @Override
                    public void onFailure(Object object) {
                        Error  e = (Error) object;
                        sUtils.log(e.getMessageEn());

                        // TODO: remove this line
                        sUtils.saveMobileNumber(getApplicationContext(), editPhoneNo.getText().toString().trim());
                        startActivity(new Intent(RegisterScreen.this, ActivationScreen.class));
                    }
                }
        );
    }
}
