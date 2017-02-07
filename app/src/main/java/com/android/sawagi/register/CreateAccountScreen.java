package com.android.sawagi.register;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.sawagi.R;
import com.android.sawagi.SplashScreen;
import com.android.sawagi.login.LoginScreen;
import com.android.sawagi.sUtils;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class CreateAccountScreen extends AppCompatActivity implements View.OnClickListener {

    boolean isShow = false;
    private Toolbar toolbar;
    private TextView mTitle, txtShow, txtAddPicture, btnNext;
    private EditText editPhoneNo, editPassword, editFullName;
    private LinearLayout layoutShow;
    private TextInputLayout inputLayoutPhone, inputLayoutPassword, inputLayoutFullName;
    private ImageView profileImage;

    FirebaseAuth firebaseAuth;
    FirebaseAuth.AuthStateListener authStateListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account_screen);

        //Initialize Toolbar
        initToolBar();

        firebaseAuth = FirebaseAuth.getInstance();

        //get Id of declare variables
        txtShow = (TextView) findViewById(R.id.create_txtShow);
        txtAddPicture = (TextView) findViewById(R.id.create_txtAddPicture);
        btnNext = (TextView) findViewById(R.id.create_btnNext);
        editPhoneNo = (EditText) findViewById(R.id.create_editPhoneNumber);
        editPassword = (EditText) findViewById(R.id.create_editPassword);
        editFullName = (EditText) findViewById(R.id.create_editFullName);
        layoutShow = (LinearLayout) findViewById(R.id.create_layoutShow);
        profileImage = (ImageView) findViewById(R.id.create_profileImage);
        inputLayoutPhone = (TextInputLayout) findViewById(R.id.create_layout_phone);
        inputLayoutPassword = (TextInputLayout) findViewById(R.id.create_layout_password);
        inputLayoutFullName = (TextInputLayout) findViewById(R.id.create_layout_fullName);


        //set Typeface
        txtShow.setTypeface(SplashScreen.Roboto_Regular);
        txtAddPicture.setTypeface(SplashScreen.Roboto_Regular);
        btnNext.setTypeface(SplashScreen.Roboto_Regular);
        editPhoneNo.setTypeface(SplashScreen.Roboto_Regular);
        editPassword.setTypeface(SplashScreen.Roboto_Regular);
        editFullName.setTypeface(SplashScreen.Roboto_Regular);
        inputLayoutFullName.setTypeface(SplashScreen.Roboto_Regular);
        inputLayoutPhone.setTypeface(SplashScreen.Roboto_Regular);
        inputLayoutPassword.setTypeface(SplashScreen.Roboto_Regular);


        editPhoneNo.setText(sUtils.getMobileNumber(getApplicationContext()));
        editPhoneNo.setEnabled(false);

        //set Button OnClickListener
        btnNext.setOnClickListener(this);
        txtAddPicture.setOnClickListener(this);
        layoutShow.setOnClickListener(this);


    }

    public void initToolBar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);

        // Remove default title text
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        mTitle = (TextView) toolbar.findViewById(R.id.toolbar_title);
        mTitle.setTypeface(SplashScreen.Roboto_Regular);
        mTitle.setText("Create An Account");

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
            case R.id.create_btnNext:
                //Open Login Screen After Registration
                createAccount();
                break;
            case R.id.create_txtAddPicture:
                break;
            case R.id.create_layoutShow:
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

    private void createAccount() {

        firebaseAuth.createUserWithEmailAndPassword("+" + sUtils.getMobileNumber(getApplicationContext()) + "@sawagi.net",
                editPassword.getText().toString().trim())
        .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {
                sUtils.log("User Registered");
                Intent in = new Intent(CreateAccountScreen.this, LoginScreen.class);
                in.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(in);
                finish();
            }
        })
        .addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                sUtils.log("Error while registering user : " + e.toString());
                sUtils.showToast(getApplicationContext(), "Some error occured. Please try again.");
            }
        });
    }
}
