package com.android.sawagi;

import android.content.Intent;
import android.graphics.Color;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.sawagi.addressbook.AddressBook;
import com.android.sawagi.member.ManageMember;
import com.android.sawagi.setting.SettingScreen;
import com.android.sawagi.trip.TripHistory;

public class NavigationActivity extends AppCompatActivity implements View.OnClickListener {

    View drawerView;
    private Toolbar toolbar;
    private TextView mTitle, txtProfileName, txtProfileCat,
            txtHome, txtTrip, txtMember, txtAddress, txtSetting, txtTell, txtSubscription;
    private LinearLayout btnHome, btnTrip, btnMember, btnAddress, btnSetting;
    private String strType;
    private ImageView profileImage, btnFb, btnTwitter, btnMail;
    private DrawerLayout mDrawerLayout;
    private DrawerLayout.DrawerListener mDrawerListener = new DrawerLayout.DrawerListener() {

        @Override
        public void onDrawerStateChanged(int status) {

        }

        @Override
        public void onDrawerSlide(View view, float slideArg) {

        }

        @Override
        public void onDrawerOpened(View view) {
        }

        @Override
        public void onDrawerClosed(View view) {
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);


        //get Value from previous activity
        strType = getIntent().getStringExtra("Type");

        //Initialize Toolbar
        initToolBar();

        //get Id of declare variables
        txtProfileName = (TextView) findViewById(R.id.sideBar_txtName);
        txtProfileCat = (TextView) findViewById(R.id.sideBar_txtCategory);
        txtHome = (TextView) findViewById(R.id.sideBar_txtHome);
        txtTrip = (TextView) findViewById(R.id.sideBar_txtTrip);
        txtMember = (TextView) findViewById(R.id.sideBar_txtMember);
        txtAddress = (TextView) findViewById(R.id.sideBar_txtAddressBook);
        txtSetting = (TextView) findViewById(R.id.sideBar_txtSetting);
        txtTell = (TextView) findViewById(R.id.sideBar_txtTell);
        txtSubscription = (TextView) findViewById(R.id.sideBar_txtSubscription);
        profileImage = (ImageView) findViewById(R.id.sideBar_profileImage);
        btnFb = (ImageView) findViewById(R.id.sideBar_btnFacebook);
        btnTwitter = (ImageView) findViewById(R.id.sideBar_btnTwitter);
        btnMail = (ImageView) findViewById(R.id.sideBar_btnMail);
        btnHome = (LinearLayout) findViewById(R.id.sideBar_menuHome);
        btnTrip = (LinearLayout) findViewById(R.id.sideBar_menuTrip);
        btnMember = (LinearLayout) findViewById(R.id.sideBar_menuMember);
        btnAddress = (LinearLayout) findViewById(R.id.sideBar_menuAddressBook);
        btnSetting = (LinearLayout) findViewById(R.id.sideBar_menuSetting);

        //get the Id of Drawer variables
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawerView = (View) findViewById(R.id.drawer);
        mDrawerLayout.setScrimColor(getResources().getColor(
                android.R.color.transparent));
        mDrawerLayout.setDrawerListener(mDrawerListener);

        //set Typeface
        txtProfileName.setTypeface(SplashScreen.Roboto_Regular);
        txtProfileCat.setTypeface(SplashScreen.Roboto_Regular);
        txtHome.setTypeface(SplashScreen.Roboto_Regular);
        txtTrip.setTypeface(SplashScreen.Roboto_Regular);
        txtMember.setTypeface(SplashScreen.Roboto_Regular);
        txtAddress.setTypeface(SplashScreen.Roboto_Regular);
        txtSetting.setTypeface(SplashScreen.Roboto_Regular);
        txtTell.setTypeface(SplashScreen.Roboto_Regular);
        txtSubscription.setTypeface(SplashScreen.Roboto_Regular);

        //Initialize fragment
        if (strType.equals("Trip History")) {
            txtTrip.setTextColor(Color.parseColor("#18816B"));
            TripHistory fragment = new TripHistory();
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.content_frame, fragment).commit();
            getSupportFragmentManager()
                    .beginTransaction().addToBackStack(null);
        } else if (strType.equals("Manage Member")) {
            txtMember.setTextColor(Color.parseColor("#18816B"));
            ManageMember fragment = new ManageMember();
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.content_frame, fragment).commit();
            getSupportFragmentManager()
                    .beginTransaction().addToBackStack(null);
        } else if (strType.equals("Address Book")) {
            txtAddress.setTextColor(Color.parseColor("#18816B"));
            AddressBook fragment = new AddressBook();
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.content_frame, fragment).commit();
            getSupportFragmentManager()
                    .beginTransaction().addToBackStack(null);
        } else {
            txtSetting.setTextColor(Color.parseColor("#18816B"));
            SettingScreen fragment = new SettingScreen();
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.content_frame, fragment).commit();
            getSupportFragmentManager()
                    .beginTransaction().addToBackStack(null);
        }


        //set Button OnClickListener
        btnHome.setOnClickListener(this);
        btnTrip.setOnClickListener(this);
        btnMember.setOnClickListener(this);
        btnAddress.setOnClickListener(this);
        btnSetting.setOnClickListener(this);
        btnFb.setOnClickListener(this);
        btnTwitter.setOnClickListener(this);
        btnMail.setOnClickListener(this);


    }

    public void initToolBar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);

        // Remove default title text
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        mTitle = (TextView) toolbar.findViewById(R.id.toolbar_title);
        mTitle.setTypeface(SplashScreen.Roboto_Regular);
        mTitle.setText(strType);

        toolbar.setNavigationIcon(R.drawable.ic_icon);
        toolbar.setNavigationOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (mDrawerLayout.isDrawerOpen(drawerView)) {
                            mDrawerLayout.closeDrawer(drawerView);
                        } else {
                            mDrawerLayout.openDrawer(drawerView);
                        }
                    }
                }

        );
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.sideBar_menuHome:
                mDrawerLayout.closeDrawer(drawerView);
                startActivity(new Intent(NavigationActivity.this, HomeScreen.class));
                finish();
                break;
            case R.id.sideBar_menuTrip:
                mDrawerLayout.closeDrawer(drawerView);

                mTitle.setText("Trip History");
                txtHome.setTextColor(Color.parseColor("#000000"));
                txtTrip.setTextColor(Color.parseColor("#18816B"));
                txtMember.setTextColor(Color.parseColor("#000000"));
                txtAddress.setTextColor(Color.parseColor("#000000"));
                txtSetting.setTextColor(Color.parseColor("#000000"));

                TripHistory fragment = new TripHistory();
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.content_frame, fragment).commit();
                getSupportFragmentManager()
                        .beginTransaction().addToBackStack(null);
                break;
            case R.id.sideBar_menuMember:
                mDrawerLayout.closeDrawer(drawerView);

                mTitle.setText("Manage Member");
                txtHome.setTextColor(Color.parseColor("#000000"));
                txtTrip.setTextColor(Color.parseColor("#000000"));
                txtMember.setTextColor(Color.parseColor("#18816B"));
                txtAddress.setTextColor(Color.parseColor("#000000"));
                txtSetting.setTextColor(Color.parseColor("#000000"));

                ManageMember memberFragment = new ManageMember();
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.content_frame, memberFragment).commit();
                getSupportFragmentManager()
                        .beginTransaction().addToBackStack(null);
                break;
            case R.id.sideBar_menuAddressBook:
                mDrawerLayout.closeDrawer(drawerView);

                mTitle.setText("Address Book");
                txtHome.setTextColor(Color.parseColor("#000000"));
                txtTrip.setTextColor(Color.parseColor("#000000"));
                txtMember.setTextColor(Color.parseColor("#000000"));
                txtAddress.setTextColor(Color.parseColor("#18816B"));
                txtSetting.setTextColor(Color.parseColor("#000000"));

                AddressBook addressFragment = new AddressBook();
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.content_frame, addressFragment).commit();
                getSupportFragmentManager()
                        .beginTransaction().addToBackStack(null);
                break;
            case R.id.sideBar_menuSetting:
                mDrawerLayout.closeDrawer(drawerView);

                mTitle.setText("Settings");
                txtHome.setTextColor(Color.parseColor("#000000"));
                txtTrip.setTextColor(Color.parseColor("#000000"));
                txtMember.setTextColor(Color.parseColor("#000000"));
                txtAddress.setTextColor(Color.parseColor("#000000"));
                txtSetting.setTextColor(Color.parseColor("#18816B"));

                SettingScreen settingFragment = new SettingScreen();
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.content_frame, settingFragment).commit();
                getSupportFragmentManager()
                        .beginTransaction().addToBackStack(null);
                break;
            case R.id.sideBar_btnFacebook:
                break;
            case R.id.sideBar_btnTwitter:
                break;
            case R.id.sideBar_btnMail:
                break;
            default:
                break;
        }
    }
}
