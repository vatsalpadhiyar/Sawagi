package com.android.sawagi.adapter;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.sawagi.R;
import com.android.sawagi.SplashScreen;
import com.android.sawagi.trip.TripDetailScreen;

/**
 * Created by karan on 25/11/16.
 */

public class AddressAdapter extends BaseAdapter {

    private Activity mActivity;
    LayoutInflater mInflater;

    public AddressAdapter(Activity activity) {

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
            convertView = mInflater.inflate(R.layout.address_list_item, null);

            holder = new ViewHolder();
            holder.txtName = (TextView) convertView.findViewById(R.id.address_list_txtName);
            holder.txtAddress = (TextView) convertView.findViewById(R.id.address_list_txtAddress);
            holder.imageMore = (ImageView) convertView.findViewById(R.id.address_list_imageMore);
            holder.btnMore = (LinearLayout) convertView.findViewById(R.id.address_list_btnMore);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        // Apply font to TextView
        holder.txtName.setTypeface(SplashScreen.Roboto_Regular);
        holder.txtAddress.setTypeface(SplashScreen.Roboto_Regular);


        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mActivity.startActivity(new Intent(mActivity, TripDetailScreen.class));
            }
        });

        return convertView;
    }

    static class ViewHolder {

        TextView txtName, txtAddress;
        LinearLayout btnMore;
        ImageView imageMore;
    }

}
