package com.android.sawagi.register;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.sawagi.R;
import com.android.sawagi.SplashScreen;

public class ActivationScreen extends AppCompatActivity implements View.OnClickListener {

    private Toolbar toolbar;
    private TextView mTitle, txtMessage, txtCode, txtResent, txtPhoneNo, btnNext;
    private EditText editCode;
    private TextInputLayout inputLayoutCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activation_screen);

        //Initialize Toolbar
        initToolBar();

        //get Id of declare variables
        txtMessage = (TextView) findViewById(R.id.activation_txtMessage);
        txtCode = (TextView) findViewById(R.id.activation_txtCode);
        txtPhoneNo = (TextView) findViewById(R.id.activation_txtPhoneNo);
        txtResent = (TextView) findViewById(R.id.activation_txtResent);
        btnNext = (TextView) findViewById(R.id.activation_btnNext);
        editCode = (EditText) findViewById(R.id.activation_editCode);
        inputLayoutCode = (TextInputLayout) findViewById(R.id.activation_layout_code);

        //set Typeface
        txtMessage.setTypeface(SplashScreen.Roboto_Regular);
        txtCode.setTypeface(SplashScreen.Roboto_Regular);
        txtPhoneNo.setTypeface(SplashScreen.Roboto_Regular);
        txtResent.setTypeface(SplashScreen.Roboto_Regular);
        btnNext.setTypeface(SplashScreen.Roboto_Regular);
        editCode.setTypeface(SplashScreen.Roboto_Regular);
        inputLayoutCode.setTypeface(SplashScreen.Roboto_Regular);

        //set Button OnClickListener
        btnNext.setOnClickListener(this);
        txtResent.setOnClickListener(this);

    }

    public void initToolBar() {
        toolbar = (Toolbar) findViewById(R.id.activation_toolbar);

        setSupportActionBar(toolbar);

        // Remove default title text
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        mTitle = (TextView) toolbar.findViewById(R.id.activation_toolbar_title);
        mTitle.setTypeface(SplashScreen.Roboto_Regular);
        mTitle.setText("Activation Code");

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
            case R.id.activation_btnNext:
                //Open Create An Account screen
                startActivity(new Intent(ActivationScreen.this, CreateAccountScreen.class));
                break;
            case R.id.activation_txtResent:
                break;
            default:
                break;
        }
    }
}
