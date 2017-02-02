package com.android.sawagi.member;

import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.sawagi.R;
import com.android.sawagi.SplashScreen;

public class AddMemberScreen extends AppCompatActivity implements View.OnClickListener {

    private Toolbar toolbar;
    private TextView mTitle, txtPicture, btnSave;
    private EditText editPhoneNo, editName;
    private TextInputLayout inputLayoutPhone, inputLayoutName;
    private ImageView profileImage;
    private String strType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_member_screen);


        //get Value from previous activity
        strType = getIntent().getStringExtra("Type");

        //Initialize Toolbar
        initToolBar();

        //get Id of declare variables
        txtPicture = (TextView) findViewById(R.id.addMember_txtAddPicture);
        btnSave = (TextView) findViewById(R.id.addMember_btnSave);
        editPhoneNo = (EditText) findViewById(R.id.addMember_editPhoneNumber);
        editName = (EditText) findViewById(R.id.addMember_editName);
        profileImage = (ImageView) findViewById(R.id.addMember_profileImage);
        inputLayoutPhone = (TextInputLayout) findViewById(R.id.addMember_layout_PhoneNumber);
        inputLayoutName = (TextInputLayout) findViewById(R.id.addMember_layout_name);


        //set Typeface
        txtPicture.setTypeface(SplashScreen.Roboto_Regular);
        btnSave.setTypeface(SplashScreen.Roboto_Regular);
        editPhoneNo.setTypeface(SplashScreen.Roboto_Regular);
        editName.setTypeface(SplashScreen.Roboto_Regular);
        inputLayoutPhone.setTypeface(SplashScreen.Roboto_Regular);
        inputLayoutName.setTypeface(SplashScreen.Roboto_Regular);

        //set Button OnClickListener
        btnSave.setOnClickListener(this);

    }

    public void initToolBar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);

        // Remove default title text
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        mTitle = (TextView) toolbar.findViewById(R.id.toolbar_title);
        mTitle.setTypeface(SplashScreen.Roboto_Regular);
        mTitle.setText(strType);

        toolbar.setNavigationIcon(R.drawable.cross);
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
            case R.id.addMember_btnSave:
                break;
            default:
                break;
        }
    }
}
