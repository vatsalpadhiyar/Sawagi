package com.android.sawagi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.sawagi.login.LoginScreen;

public class WalkThrough extends AppCompatActivity implements View.OnClickListener {

    private int imageArra[] = {R.drawable.walktrough1, R.drawable.walktrough2,
            R.drawable.walktrough3, R.drawable.walktrough4, R.drawable.walktrough5};
    private String intro1[] = {"Register a driver and add a family", "Request pickup and help your",
            "Keep favorited address into", "Always keep track of your driver", "Monthly subscription start at"};

    private String intro2[] = {"member into the app", "driver with map navigation",
            "address book", "speed and location", "USD 9.99 or refer to friend and"};

    private String intro3[] = {"", "", "", "", "get one month subscription!"};

    private ImageView dot_img1, dot_img2, dot_img3, dot_img4, dot_img5;
    private ViewPager introPager;
    private LinearLayout layoutContinue;
    private TextView txtContinue, txt_Intro1, txt_Intro2, txt_Intro3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_walk_through);

        ViewPagerAdapter adapter = new ViewPagerAdapter(this, imageArra);
        introPager = (ViewPager) findViewById(R.id.viewpager);
        dot_img1 = (ImageView) findViewById(R.id.imgview1_fill);
        dot_img2 = (ImageView) findViewById(R.id.imgview2_fill);
        dot_img3 = (ImageView) findViewById(R.id.imgview3_fill);
        dot_img4 = (ImageView) findViewById(R.id.imgview4_fill);
        dot_img5 = (ImageView) findViewById(R.id.imgview5_fill);
        layoutContinue = (LinearLayout) findViewById(R.id.walk_layoutContinue);
        txtContinue = (TextView) findViewById(R.id.walk_txtContinue);
        txt_Intro1 = (TextView) findViewById(R.id.walk_txtIntro1);
        txt_Intro2 = (TextView) findViewById(R.id.walk_txtIntro2);
        txt_Intro3 = (TextView) findViewById(R.id.walk_txtIntro3);

        introPager.setAdapter(adapter);
        introPager.setCurrentItem(0);
        txt_Intro1.setText(intro1[0]);
        txt_Intro2.setText(intro2[0]);
        txt_Intro3.setText(intro3[0]);
        txt_Intro3.setVisibility(View.GONE);

        introPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int arg0) {
                // TODO Auto-generated method stub
                changDot(arg0);
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onPageScrollStateChanged(int arg0) {
                // TODO Auto-generated method stub

            }
        });

        //set font
        txtContinue.setTypeface(SplashScreen.Roboto_Regular);
        txt_Intro1.setTypeface(SplashScreen.Roboto_Regular);
        txt_Intro2.setTypeface(SplashScreen.Roboto_Regular);
        txt_Intro3.setTypeface(SplashScreen.Roboto_Regular);

        // set Button onClickListener
        layoutContinue.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.walk_layoutContinue:
                //Open Login Screen
                startActivity(new Intent(WalkThrough.this, LoginScreen.class));
                break;
            default:
                break;
        }
    }

    public class ViewPagerAdapter extends PagerAdapter {

        Activity activity;
        int imageArray[];

        public ViewPagerAdapter(Activity act, int[] imgArra) {
            imageArray = imgArra;
            activity = act;
        }

        public int getCount() {
            return imageArray.length;
        }

        public Object instantiateItem(View collection, int position) {

            LayoutInflater inflater = (LayoutInflater) activity
                    .getSystemService(activity.getApplicationContext().LAYOUT_INFLATER_SERVICE);

            View view = inflater.inflate(R.layout.page_list_item, null);

            LinearLayout pagelayout = (LinearLayout) view
                    .findViewById(R.id.pagerlayout);

            pagelayout.setBackgroundResource(imageArray[position]);

            ((ViewPager) collection).addView(view, 0);

            return view;
        }

        @Override
        public void destroyItem(View arg0, int arg1, Object arg2) {
            ((ViewPager) arg0).removeView((View) arg2);
        }

        @Override
        public boolean isViewFromObject(View arg0, Object arg1) {
            return arg0 == ((View) arg1);
        }

        @Override
        public Parcelable saveState() {
            return null;
        }
    }

    public void changDot(int position) {

        switch (position) {
            case 0:
                dot_img1.setVisibility(View.VISIBLE);
                dot_img2.setVisibility(View.GONE);
                dot_img3.setVisibility(View.GONE);
                dot_img4.setVisibility(View.GONE);
                dot_img5.setVisibility(View.GONE);
                txt_Intro1.setText(intro1[0]);
                txt_Intro2.setText(intro2[0]);
                txt_Intro3.setText(intro3[0]);
                txt_Intro3.setVisibility(View.GONE);
                break;
            case 1:
                dot_img1.setVisibility(View.VISIBLE);
                dot_img2.setVisibility(View.VISIBLE);
                dot_img3.setVisibility(View.GONE);
                dot_img4.setVisibility(View.GONE);
                dot_img5.setVisibility(View.GONE);
                txt_Intro1.setText(intro1[1]);
                txt_Intro2.setText(intro2[1]);
                txt_Intro3.setText(intro3[1]);
                txt_Intro3.setVisibility(View.GONE);
                break;
            case 2:
                dot_img1.setVisibility(View.VISIBLE);
                dot_img2.setVisibility(View.VISIBLE);
                dot_img3.setVisibility(View.VISIBLE);
                dot_img4.setVisibility(View.GONE);
                dot_img5.setVisibility(View.GONE);
                txt_Intro1.setText(intro1[2]);
                txt_Intro2.setText(intro2[2]);
                txt_Intro3.setText(intro3[2]);
                txt_Intro3.setVisibility(View.GONE);
                break;
            case 3:
                dot_img1.setVisibility(View.VISIBLE);
                dot_img2.setVisibility(View.VISIBLE);
                dot_img3.setVisibility(View.VISIBLE);
                dot_img4.setVisibility(View.VISIBLE);
                dot_img5.setVisibility(View.GONE);
                txt_Intro1.setText(intro1[3]);
                txt_Intro2.setText(intro2[3]);
                txt_Intro3.setText(intro3[3]);
                txt_Intro3.setVisibility(View.GONE);
                break;
            case 4:
                dot_img1.setVisibility(View.VISIBLE);
                dot_img2.setVisibility(View.VISIBLE);
                dot_img3.setVisibility(View.VISIBLE);
                dot_img4.setVisibility(View.VISIBLE);
                dot_img5.setVisibility(View.VISIBLE);
                txt_Intro1.setText(intro1[4]);
                txt_Intro2.setText(intro2[4]);
                txt_Intro3.setText(intro3[4]);
                txt_Intro3.setVisibility(View.VISIBLE);
                break;

            default:
                break;
        }
    }
}
