package com.android.sawagi.adapter;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.android.sawagi.R;
import com.android.sawagi.SplashScreen;
import com.android.sawagi.trip.TripDetailScreen;

/**
 * Created by karan on 23/11/16.
 */

public class TripAdapter extends BaseAdapter {

    private Activity mActivity;
    LayoutInflater mInflater;

    public TripAdapter(Activity activity) {

        this.mActivity = activity;
        mInflater = (LayoutInflater) this.mActivity.getApplicationContext()
                .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return 5;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {


        final ViewHolder holder;

        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.trip_history_list_item, null);

            holder = new ViewHolder();
            holder.txtDate = (TextView) convertView.findViewById(R.id.trip_txtDate);
            holder.txtDay = (TextView) convertView.findViewById(R.id.trip_txtDay);
            holder.txtTime = (TextView) convertView.findViewById(R.id.trip_txtTime);
            holder.txtSource = (TextView) convertView.findViewById(R.id.trip_txtSource);
            holder.txtDestination = (TextView) convertView.findViewById(R.id.trip_txtSource);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        // Apply font to TextView
        holder.txtDate.setTypeface(SplashScreen.Roboto_Regular);
        holder.txtDay.setTypeface(SplashScreen.Roboto_Regular);
        holder.txtTime.setTypeface(SplashScreen.Roboto_Regular);
        holder.txtSource.setTypeface(SplashScreen.Roboto_Regular);
        holder.txtDestination.setTypeface(SplashScreen.Roboto_Regular);


        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mActivity.startActivity(new Intent(mActivity, TripDetailScreen.class));
            }
        });

        return convertView;
    }

    static class ViewHolder {

        TextView txtDate, txtDay, txtTime, txtSource, txtDestination;
    }

}
