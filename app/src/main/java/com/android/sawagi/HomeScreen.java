package com.android.sawagi;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class HomeScreen extends AppCompatActivity implements View.OnClickListener {

    View drawerView;
    private LinearLayout btnMenu, btnHome, btnTrip, btnMember, btnAddress, btnSetting;
    private TextView txtLocation, txtDestination, txtProfileName, txtProfileCat,
            txtHome, txtTrip, txtMember, txtAddress, txtSetting, txtTell, txtSubscription;
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
        setContentView(R.layout.activity_home_screen);

        //get Id of declare variables
        txtLocation = (TextView) findViewById(R.id.home_txtYourLocation);
        txtDestination = (TextView) findViewById(R.id.home_txtDestination);
        txtProfileName = (TextView) findViewById(R.id.sideBar_txtName);
        txtProfileCat = (TextView) findViewById(R.id.sideBar_txtCategory);
        txtHome = (TextView) findViewById(R.id.sideBar_txtHome);
        txtHome.setTextColor(Color.parseColor("#18816B"));
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
        btnMenu = (LinearLayout) findViewById(R.id.home_btnMenu);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawerView = (View) findViewById(R.id.drawer);
        mDrawerLayout.setScrimColor(getResources().getColor(
                android.R.color.transparent));
        mDrawerLayout.setDrawerListener(mDrawerListener);


        //set Typeface
        txtLocation.setTypeface(SplashScreen.Roboto_Regular);
        txtDestination.setTypeface(SplashScreen.Roboto_Regular);
        txtProfileName.setTypeface(SplashScreen.Roboto_Regular);
        txtProfileCat.setTypeface(SplashScreen.Roboto_Regular);
        txtHome.setTypeface(SplashScreen.Roboto_Regular);
        txtTrip.setTypeface(SplashScreen.Roboto_Regular);
        txtMember.setTypeface(SplashScreen.Roboto_Regular);
        txtAddress.setTypeface(SplashScreen.Roboto_Regular);
        txtSetting.setTypeface(SplashScreen.Roboto_Regular);
        txtTell.setTypeface(SplashScreen.Roboto_Regular);
        txtSubscription.setTypeface(SplashScreen.Roboto_Regular);


        //set Button OnClickListener
        btnMenu.setOnClickListener(this);
        txtLocation.setOnClickListener(this);
        txtDestination.setOnClickListener(this);
        btnHome.setOnClickListener(this);
        btnTrip.setOnClickListener(this);
        btnMember.setOnClickListener(this);
        btnAddress.setOnClickListener(this);
        btnSetting.setOnClickListener(this);
        btnFb.setOnClickListener(this);
        btnTwitter.setOnClickListener(this);
        btnMail.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.home_btnMenu:
                if (mDrawerLayout.isDrawerOpen(drawerView)) {
                    mDrawerLayout.closeDrawer(drawerView);
                } else {
                    mDrawerLayout.openDrawer(drawerView);
                }
                break;
            case R.id.sideBar_menuHome:
                mDrawerLayout.closeDrawer(drawerView);
                break;
            case R.id.sideBar_menuTrip:

                mDrawerLayout.closeDrawer(drawerView);
                Intent in = new Intent(HomeScreen.this, NavigationActivity.class);
                in.putExtra("Type", "Trip History");
                startActivity(in);
                finish();
                break;
            case R.id.sideBar_menuMember:
                mDrawerLayout.closeDrawer(drawerView);
                Intent mIn = new Intent(HomeScreen.this, NavigationActivity.class);
                mIn.putExtra("Type", "Manage Member");
                startActivity(mIn);
                finish();
                break;
            case R.id.sideBar_menuAddressBook:
                mDrawerLayout.closeDrawer(drawerView);
                Intent addressIn = new Intent(HomeScreen.this, NavigationActivity.class);
                addressIn.putExtra("Type", "Address Book");
                startActivity(addressIn);
                finish();
                break;
            case R.id.sideBar_menuSetting:
                mDrawerLayout.closeDrawer(drawerView);
                Intent settingIn = new Intent(HomeScreen.this, NavigationActivity.class);
                settingIn.putExtra("Type", "Settings");
                startActivity(settingIn);
                finish();
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
