package com.android.sawagi.setting;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.sawagi.R;
import com.android.sawagi.SplashScreen;

/**
 * Created by karan on 23/11/16.
 */

public class SettingScreen extends Fragment implements View.OnClickListener {

    private ImageView profileImage;
    private LinearLayout layoutProfile, layoutPremium, layoutShare, layoutSignOut;
    private TextView txtName, txtAccount, txtType, txtTrial, txtTrialDate, txtPremium, txtUSD, txtVIPCharge, txtMember,
            txtRecommend, txtShare, txtSignOut;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_setting, container, false);

        //get Id of Declare variable
        profileImage = (ImageView) view.findViewById(R.id.setting_profileImage);
        txtName = (TextView) view.findViewById(R.id.setting_txtName);
        txtAccount = (TextView) view.findViewById(R.id.setting_txtAccount);
        txtType = (TextView) view.findViewById(R.id.setting_txtType);
        txtTrial = (TextView) view.findViewById(R.id.setting_txtTrial);
        txtTrialDate = (TextView) view.findViewById(R.id.setting_txtTrialDate);
        txtPremium = (TextView) view.findViewById(R.id.setting_txtPremium);
        txtUSD = (TextView) view.findViewById(R.id.setting_txtUSD);
        txtVIPCharge = (TextView) view.findViewById(R.id.setting_txtVIPCharge);
        txtMember = (TextView) view.findViewById(R.id.setting_txtMember);
        txtRecommend = (TextView) view.findViewById(R.id.setting_txtRecommend);
        txtShare = (TextView) view.findViewById(R.id.setting_txtShare);
        txtSignOut = (TextView) view.findViewById(R.id.setting_txtSignOut);
        layoutProfile = (LinearLayout) view.findViewById(R.id.setting_layoutProfile);
        layoutPremium = (LinearLayout) view.findViewById(R.id.setting_layoutPremium);
        layoutShare = (LinearLayout) view.findViewById(R.id.setting_layoutShare);
        layoutSignOut = (LinearLayout) view.findViewById(R.id.setting_layoutSignOut);

        //set Font
        txtName.setTypeface(SplashScreen.Roboto_Regular);
        txtAccount.setTypeface(SplashScreen.Roboto_Regular);
        txtType.setTypeface(SplashScreen.Roboto_Regular);
        txtTrial.setTypeface(SplashScreen.Roboto_Regular);
        txtTrialDate.setTypeface(SplashScreen.Roboto_Regular);
        txtPremium.setTypeface(SplashScreen.Roboto_Regular);
        txtUSD.setTypeface(SplashScreen.Roboto_Regular);
        txtVIPCharge.setTypeface(SplashScreen.Roboto_Regular);
        txtMember.setTypeface(SplashScreen.Roboto_Regular);
        txtRecommend.setTypeface(SplashScreen.Roboto_Regular);
        txtShare.setTypeface(SplashScreen.Roboto_Regular);
        txtSignOut.setTypeface(SplashScreen.Roboto_Regular);


        //set Button OnClickListener
        layoutProfile.setOnClickListener(this);
        layoutPremium.setOnClickListener(this);
        layoutShare.setOnClickListener(this);
        layoutSignOut.setOnClickListener(this);


        return view;
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.setting_layoutProfile:
                break;
            case R.id.setting_layoutPremium:
                break;
            case R.id.setting_layoutShare:
                // Open Recommendation Screen
                startActivity(new Intent(getActivity(), RecommendationScreen.class));

                break;
            case R.id.setting_layoutSignOut:
                break;

            default:
                break;
        }
    }
}
