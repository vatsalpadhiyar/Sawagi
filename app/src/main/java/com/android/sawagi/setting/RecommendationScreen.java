package com.android.sawagi.setting;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.sawagi.R;
import com.android.sawagi.SplashScreen;

public class RecommendationScreen extends AppCompatActivity implements View.OnClickListener {

    private Toolbar toolbar;
    private TextView mTitle, txtPremium, txtRecommend, txtFB, txtTwitter, txtEmail;
    private LinearLayout btnFb, btnTwitter, btnEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recommendation_screen);

        //Initialize Toolbar
        initToolBar();

        //get Id of declare variables
        txtPremium = (TextView) findViewById(R.id.recommendation_txtPremium);
        txtRecommend = (TextView) findViewById(R.id.recommendation_txtRecommend);
        txtFB = (TextView) findViewById(R.id.recommendation_txtFB);
        txtTwitter = (TextView) findViewById(R.id.recommendation_txtTwitter);
        txtEmail = (TextView) findViewById(R.id.recommendation_txtEmail);
        btnFb = (LinearLayout) findViewById(R.id.recommendation_btnFB);
        btnTwitter = (LinearLayout) findViewById(R.id.recommendation_btnTwitter);
        btnEmail = (LinearLayout) findViewById(R.id.recommendation_btnEmail);

        //set Font Type
        txtPremium.setTypeface(SplashScreen.Roboto_Regular);
        txtRecommend.setTypeface(SplashScreen.Roboto_Regular);
        txtFB.setTypeface(SplashScreen.Roboto_Regular);
        txtTwitter.setTypeface(SplashScreen.Roboto_Regular);
        txtEmail.setTypeface(SplashScreen.Roboto_Regular);


        //set Button OnClickListener
        btnFb.setOnClickListener(this);
        btnTwitter.setOnClickListener(this);
        btnEmail.setOnClickListener(this);

    }

    public void initToolBar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);

        // Remove default title text
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        mTitle = (TextView) toolbar.findViewById(R.id.toolbar_title);
        mTitle.setTypeface(SplashScreen.Roboto_Regular);
        mTitle.setText("Recommendation");

        toolbar.setNavigationIcon(R.drawable.ic_back);
        toolbar.setNavigationOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        finish();
                    }
                }
        );
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.recommendation_btnFB:
                break;
            case R.id.recommendation_btnTwitter:
                break;
            case R.id.recommendation_btnEmail:
                break;
            default:
                break;
        }
    }
}
