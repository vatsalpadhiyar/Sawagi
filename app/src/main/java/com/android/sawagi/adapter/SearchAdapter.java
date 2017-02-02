package com.android.sawagi.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.sawagi.R;
import com.android.sawagi.SplashScreen;

/**
 * Created by karan on 25/11/16.
 */

public class SearchAdapter extends BaseAdapter {

    private Activity mActivity;
    LayoutInflater mInflater;

    public SearchAdapter(Activity activity) {

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
            convertView = mInflater.inflate(R.layout.recent_address_list_item, null);

            holder = new ViewHolder();
            holder.icon = (ImageView) convertView.findViewById(R.id.recent_list_iconImage);
            holder.txtName = (TextView) convertView.findViewById(R.id.recent_list_txtName);
            holder.txtAddress = (TextView) convertView.findViewById(R.id.recent_list_txtAddress);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.icon.setImageResource(R.drawable.address_pin);

        // Apply font to TextView
        holder.txtName.setTypeface(SplashScreen.Roboto_Regular);
        holder.txtAddress.setTypeface(SplashScreen.Roboto_Regular);

        return convertView;
    }

    static class ViewHolder {

        TextView txtName, txtAddress;
        ImageView icon;
    }

}
