package com.android.sawagi.addressbook;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.android.sawagi.R;
import com.android.sawagi.SplashScreen;
import com.android.sawagi.adapter.RecentAdapter;

public class AddAddressScreen extends AppCompatActivity {

    private Toolbar toolbar;
    private EditText editTitle;
    private TextView txtRecent;
    private ListView recentListview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_address_screen);

        //Initialize Toolbar
        initToolBar();

        //get The Id of declare variables
        txtRecent = (TextView) findViewById(R.id.addAddress_txtRecent);
        recentListview = (ListView) findViewById(R.id.addAddress_recentList);


        //set Font Type
        txtRecent.setTypeface(SplashScreen.Roboto_Regular);

        //set Adapter
        recentListview.setAdapter(new RecentAdapter(AddAddressScreen.this));
    }

    public void initToolBar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);

        // Remove default title text
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        editTitle = (EditText) toolbar.findViewById(R.id.toolbar_editText);
        editTitle.setTypeface(SplashScreen.Roboto_Regular);

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
}
